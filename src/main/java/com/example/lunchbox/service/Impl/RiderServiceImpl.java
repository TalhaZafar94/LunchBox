package com.example.lunchbox.service.Impl;

import com.example.lunchbox.model.entity.Location;
import com.example.lunchbox.model.entity.Rider;
import com.example.lunchbox.model.entity.RiderRequest;
import com.example.lunchbox.repository.LocationRepository;
import com.example.lunchbox.repository.RiderRepository;
import com.example.lunchbox.repository.RiderRequestRepository;
import com.example.lunchbox.service.RiderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class RiderServiceImpl implements RiderService {

    private RiderRepository riderRepository;
    private LocationRepository locationRepository;
    private RiderRequestRepository riderRequestRepository;
    @Value("${riderKey}")
    private String riderServerKey;

    @Autowired
    public RiderServiceImpl(RiderRepository riderRepository, LocationRepository locationRepository, RiderRequestRepository riderRequestRepository) {
        this.riderRepository = riderRepository;
        this.locationRepository = locationRepository;
        this.riderRequestRepository = riderRequestRepository;
    }


    @Override
    public void riderSignup(Rider rider) {
        try {
            rider.setRiderPassword(getSHA256(rider.getRiderPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        riderRepository.saveAndFlush(rider);
    }

    @Override
    public Rider getRiderById(Integer id) {
        return riderRepository.findOne(id);
    }

    @Override
    public long countAllRiders() {
        return riderRepository.count();
    }

    @Override
    public void deleteRider(String riderEmail) {
        Rider rider = this.findByRiderEmail(riderEmail);
        riderRepository.delete(rider.getRiderId());
    }

    @Override
    public List<Rider> getRiderByname(String riderName) {
        return riderRepository.findByRiderName(riderName);
    }

    @Override
    public Rider getRiderByRiderLastUpdated(Date date) {
        return riderRepository.getRiderByRiderLastUpdated(date);
    }

    @Override
    public Rider getRiderByRiderCreatedAt(Date date) {
        return riderRepository.getRiderByRiderCreatedAt(date);
    }

    @Override
    public List<Rider> findAllRiders() {
        return riderRepository.findAll();
    }

    @Override
    public Rider findByRiderEmail(String riderEmail) {
        return riderRepository.findByRiderEmail(riderEmail);
    }


    @Override
    public Rider login(String riderEmail, String riderPassword, String token) {
        Rider rider = this.findByRiderEmail(riderEmail);
        try {
            if (rider != null && getSHA256(riderPassword).equals(rider.getRiderPassword())) {
                if (rider.getRiderRegToken() == null || !rider.getRiderRegToken().equals(token)) {
                    rider.setRiderRegToken(token);
                    riderRepository.save(rider);
                }
                return rider;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean updatePassword(String oldpassword, String newpassword, String riderEmail) {
        Rider rider = this.findByRiderEmail(riderEmail);
        try {
            if (rider != null && getSHA256(oldpassword).equals(rider.getRiderPassword())) {
                rider.setRiderPassword(getSHA256(newpassword));
                riderRepository.saveAndFlush(rider);
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getSHA256(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");

        messageDigest.update(password.getBytes());
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((int) (b & 0xff)));
        }
        return sb.toString();
    }

    @Override
    public void setStatus(int riderId, int status) {
        Rider rider = riderRepository.findOne(riderId);
        rider.setRiderActive(status);
        riderRepository.save(rider);
    }

    @Override
    public List<Rider> getRidersNearBy(Double lat, Double longt, Integer orderId) {

        List<Rider> inlocations = new ArrayList<>();
        List<Location> locations = locationRepository.findAll();
        Double count = 6.0;

        try {
            for (Location location : locations) {

                if (location.getRiderId() != null) {
                    if (getDistance(lat, longt, location.getLocationLatitude(), location.getLocationLongitude()) <= count) {
                        Rider rider = riderRepository.findOne(location.getFoodmakerId());
                        if (rider.getRiderActive() == 1) {
                            inlocations.add(rider);

                            RiderRequest request = new RiderRequest(orderId, location.getRiderId(), 1);
                            riderRequestRepository.saveAndFlush(request);

                            Rider rider1 = riderRepository.findOne(location.getRiderId());
                            sendNotification(rider1.getRiderRegToken(), riderServerKey, "you have an order");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inlocations;
    }


    private Double getDistance(double lat1, double long1, double lat2, double long2) {
        return 6371 * (Math.acos(
                ((Math.cos(Math.toRadians(lat2))
                        * (Math.cos(Math.toRadians(lat1)))
                        * (Math.cos(Math.toRadians(long1) - Math.toRadians(long2))))
                        + ((Math.sin(Math.toRadians(lat2)))
                        * (Math.sin(Math.toRadians(lat1)))))));
    }


    @Async
    public ResponseEntity<String> sendNotification(String token, String androidFirebaseKey, String msg) {
        AndroidPushNotificationsService androidPushNotificationsService = new AndroidPushNotificationsService(androidFirebaseKey);

        JSONObject body = new JSONObject();
        body.put("to", token);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", "lunchbox Notification");
        notification.put("body", msg);

        JSONObject data = new JSONObject();
        data.put("Key-1", "order Data 1");
        data.put("Key-2", "order Data 2");

        body.put("notification", notification);
        body.put("data", data);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();

            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
    }
}
