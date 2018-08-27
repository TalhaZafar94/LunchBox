package com.example.lunchbox.service.Impl;


import com.example.lunchbox.model.entity.*;
import com.example.lunchbox.repository.*;
import com.example.lunchbox.service.FoodmakerService;

import com.example.lunchbox.service.OrderService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FoodmakerServiceImpl implements FoodmakerService {

    private FoodmakerRepository foodmakerRepository;
    private LocationRepository locationRepository;
    private RatingRepository ratingRepository;
    private OrderRepository orderRepository;
    private DeleteUserRepository deleteUserRepository;
    private OrderService orderService;
    private static final String key = "AIzaSyD6zBHiASrQgjYjoEyRJphf8uOpVbPtQCg";
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public FoodmakerServiceImpl(FoodmakerRepository foodmakerRepository, LocationRepository locationRepository, OrderService orderService
            , RatingRepository ratingRepository, OrderRepository orderRepository, DeleteUserRepository deleteUserRepository) {
        this.foodmakerRepository = foodmakerRepository;
        this.locationRepository = locationRepository;
        this.ratingRepository = ratingRepository;
        this.orderRepository = orderRepository;
        this.deleteUserRepository = deleteUserRepository;
        this.orderService = orderService;
    }

    @Override
    public void foodmakerSignup(Foodmaker foodmaker) {

        Location location = new Location();
        try {
            foodmaker.setFoodmakerpassword(getSHA256(foodmaker.getFoodmakerpassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        foodmakerRepository.saveAndFlush(foodmaker);

        Address address = foodmaker.getFoodmakerAddresId();
        JSONObject object = getLatLng(address.getAddress());

        if (object != null && object.length() > 0) {

            Foodmaker foodmakr = this.findByFoodmakerEmail(foodmaker.getFoodmakerEmail());

            location.setFoodmakerId(foodmakr.getFoodmakerId());
            location.setLocationLatitude((Double) object.get("lat"));
            location.setLocationLongitude((Double) object.get("lng"));

            locationRepository.saveAndFlush(location);
        }
    }

    @Override
    public Foodmaker getFoodmakerById(Integer id) {
        return foodmakerRepository.findOne(id);
    }

    @Override
    public long countAllFoodMmkers() {
        return foodmakerRepository.count();
    }

    @Override
    public void deleteFoodmaker(String foodmakerEmail) {
        Foodmaker foodmaker = this.findByFoodmakerEmail(foodmakerEmail);
        foodmakerRepository.delete(foodmaker.getFoodmakerId());
    }

    @Override
    public List<Foodmaker> getFoodmakerByname(String foodmakerName) {
        return foodmakerRepository.findByFoodmakerNameContaining(foodmakerName);
    }

    @Override
    public List<Foodmaker> findAllFoodmakers() {

        List<Foodmaker> getAll = new ArrayList<>();

        for (Foodmaker foodmaker : foodmakerRepository.findAll()) {
            if (foodmaker.getFoodmakerActive() == 2) {
                continue;
            }
            foodmaker.setAverageRatings(ratingRepository.getAverage(foodmaker.getFoodmakerId()));
            getAll.add(foodmaker);
        }

        return getAll;
    }

    @Override
    public Foodmaker findByFoodmakerEmail(String foodmakerEmail) {
        return foodmakerRepository.findByFoodmakerEmail(foodmakerEmail);
    }

    @Override
    public Foodmaker login(String foodmakerEmail, String foodmakerPassword, String token) {
        Foodmaker foodmaker = this.findByFoodmakerEmail(foodmakerEmail);
        try {
            if (foodmaker != null && getSHA256(foodmakerPassword).equals(foodmaker.getFoodmakerpassword())) {
                if (foodmaker.getFoodmakerRegToken() == null || !foodmaker.getFoodmakerRegToken().equals(token)) {
                    foodmaker.setFoodmakerRegToken(token);
                    foodmakerRepository.save(foodmaker);
                }
                return foodmaker;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updatePassword(String oldpassword, String newpassword, String foodmakerEmail) {
        Foodmaker foodmaker = this.findByFoodmakerEmail(foodmakerEmail);
        try {
            if (foodmaker != null && getSHA256(oldpassword).equals(foodmaker.getFoodmakerpassword())) {
                foodmaker.setFoodmakerpassword(getSHA256(newpassword));
                foodmakerRepository.saveAndFlush(foodmaker);
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
    public Foodmaker getFoodmakerByFoodmakerCreatedAt(Date date) {
        return foodmakerRepository.getFoodmakerByFoodmakerCreatedAt(date);
    }

    @Override
    public Foodmaker getFoodmakerByFoodmakerLastUpdated(Date date) {
        return foodmakerRepository.getFoodmakerByFoodmakerLastUpdated(date);
    }

    private static JSONObject getLatLng(String address) {
        address = address.replace(" ", "+");
        String uri = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + key;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        JSONObject jsonObject = new JSONObject(result);

        JSONArray jsonArray = (JSONArray) jsonObject.get("results");
        JSONObject firstObject = (JSONObject) jsonArray.get(0);
        JSONObject geometryObject = (JSONObject) firstObject.get("geometry");

        return (JSONObject) geometryObject.get("location");
    }

    @Override
    public List<Foodmaker> getFoodmakersNearBy(Double lat, Double longt) {

        List<Foodmaker> inlocations = new ArrayList<>();
        List<Location> locations = locationRepository.findAll();
        Double count = 6.0;

        try {
            for (Location location : locations) {
                if (location.getFoodmakerId() != null) {
                    if (getDistance(lat, longt, location.getLocationLatitude(), location.getLocationLongitude()) <= count) {
                        Foodmaker foodmaker = foodmakerRepository.findOne(location.getFoodmakerId());
                        if (foodmaker.getFoodmakerActive() == 2) {
                            continue;
                        }
                        foodmaker.setAverageRatings(ratingRepository.getAverage(foodmaker.getFoodmakerId()));
                        inlocations.add(foodmaker);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inlocations;
/*
        try {
           int count = 6;

           String url = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=";
           url = String.format("%s%s,%s%s", url, String.valueOf(lat), String.valueOf(longt),"&destinations=");

           for(Location location : locations){
               url = String.format("%s%s,%s", url,
                       String.valueOf(location.getLocationLatitude()), String.valueOf(location.getLocationLongitude()) + "|");
           }
           url = url.substring(0, url.length()-2);
           url = String.format("%s%s%s", url, "&key=", key);
           RestTemplate restTemplate = new RestTemplate();
           String result = restTemplate.getForObject(url, String.class);
           JSONObject jsonObject = new JSONObject(result);
           JSONArray jsonArray = (JSONArray) jsonObject.get("rows");
           JSONObject firstObject = (JSONObject) jsonArray.get(0);
           JSONArray geometryObject = (JSONArray) firstObject.get("elements");

           for(int i = 0; i< geometryObject.length(); i++){
               JSONObject object = geometryObject.getJSONObject(i);
               if(object.has("distance"))
               {
                   JSONObject distance = (JSONObject) object.get("distance");
                   try {
                       if(count >= Double.parseDouble(distance.get("text").toString().replace(" mi", "").replace(",",""))){
                           // inlocations.add(locations.get(i));
                           //inlocations.add(this.getFoodmakerById(locations.get(i).getFoodmakerId()));
                           Foodmaker foodmaker = this.getFoodmakerById(locations.get(i).getFoodmakerId());
                           if(foodmaker.getFoodmakerActive() == 2)
                           {
                               continue;
                           }
                           foodmaker.setAverageRatings(ratingRepository.getAverage(foodmaker.getFoodmakerId()));
                           inlocations.add(foodmaker);
                       }
                   }
                   catch (NumberFormatException e)
                   {
                       inlocations = this.findAllFoodmakers();
                       return inlocations;
                   }

               }
               else
               {
                   inlocations = this.findAllFoodmakers();
                   return inlocations;
               }
           }

           if(inlocations.size() > 0)
           {
               return inlocations;
           }

           while (count <= 9)
           {
               if(inlocations.size() > 0)
               {
                   return inlocations;
               }
               else {
                   count++;
                   for (int i = 0; i < geometryObject.length(); i++) {
                       JSONObject object = geometryObject.getJSONObject(i);
                       JSONObject distance = (JSONObject) object.get("distance");

                       if (count >= Double.parseDouble(distance.get("text").toString().replace(" mi", "").replace(",", ""))) {
                           // inlocations.add(locations.get(i));
                           //inlocations.add(this.getFoodmakerById(locations.get(i).getFoodmakerId()));
                           Foodmaker foodmaker = this.getFoodmakerById(locations.get(i).getFoodmakerId());
                           if(foodmaker.getFoodmakerActive() == 2)
                           {
                               continue;
                           }
                           foodmaker.setAverageRatings(ratingRepository.getAverage(foodmaker.getFoodmakerId()));
                           inlocations.add(foodmaker);
                       }
                   }
               }
           }

           if(inlocations.size() == 0)
           {
               inlocations = this.findAllFoodmakers();
               return inlocations;
           }

       }
       catch (Exception e)
       {
           e.printStackTrace();
       }

*/
    }

    @Override
    public void setStatus(int foodmakerId, int status) {
        Foodmaker foodmaker = foodmakerRepository.findOne(foodmakerId);
        foodmaker.setFoodmakerActive(status);
        foodmakerRepository.save(foodmaker);


    }

    @Override
    public void setRatings(int customerId, int foodmakerId, int stars) {
        Ratings ratings = new Ratings(customerId, foodmakerId, stars);
        ratingRepository.save(ratings);
    }

    @Override
    public List<Ratings> getRatingsByFoodmakerId(Integer foodmakerId) {
        return ratingRepository.getRatingsByFoodmakerId(foodmakerId);
    }

    @Override
    public void saveImage(byte[] image, Foodmaker foodmaker) {

        String final_Path = "localhost:8080/images/";
        Path path = Paths.get(uploadPath + foodmaker.getFoodmakerName());
        try {
            Files.write(path, image);
            final_Path += foodmaker.getFoodmakerName();
            foodmaker.setFoodmakerImagePath(final_Path);
            foodmakerRepository.save(foodmaker);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getOrdersByfoodmakerId(Integer foodmakerId) {
        List<Order> allOrders = orderService.findAllOrders();
        List<Order> orderListbyFoodmaker_id = orderRepository.getAllByFoodmakerId(foodmakerId);
        List<Order> orderListbystatus_id = orderRepository.getAllByOrderStatus(1);

        if (orderListbyFoodmaker_id.size() > 0)
            allOrders.retainAll(orderListbyFoodmaker_id);

        if (orderListbystatus_id.size() > 0)
            allOrders.retainAll(orderListbystatus_id);


        if (allOrders.size() > 0) {
            return allOrders;
        }

        return null;
    }

    @Override
    public List<Order> getAckOrdersByfoodmakerId(Integer foodmakerId) {
        List<Order> allOrders = orderService.findAllOrders();
        List<Order> orderListbyFoodmaker_id = orderRepository.getAllByFoodmakerId(foodmakerId);
        List<Order> orderListbystatus_id = orderRepository.getAllByOrderStatus(2);

        if (orderListbyFoodmaker_id.size() > 0)
            allOrders.retainAll(orderListbyFoodmaker_id);

        if (orderListbystatus_id.size() > 0)
            allOrders.retainAll(orderListbystatus_id);


        if (allOrders.size() > 0) {
            return allOrders;
        }

        return null;
    }

    @Override
    public List<Order> getDoneOrdersByfoodmakerId(Integer foodmakerId) {
        List<Order> allOrders = orderService.findAllOrders();
        List<Order> orderListbyFoodmaker_id = orderRepository.getAllByFoodmakerId(foodmakerId);
        List<Order> orderListbystatus_id = orderRepository.getAllByOrderStatus(3);

        if (orderListbyFoodmaker_id.size() > 0)
            allOrders.retainAll(orderListbyFoodmaker_id);

        if (orderListbystatus_id.size() > 0)
            allOrders.retainAll(orderListbystatus_id);


        if (allOrders.size() > 0) {
            return allOrders;
        }

        return null;
    }


    @Override
    public void deletefoodmakerById(Integer foodmakerId) {
        Foodmaker foodmaker = foodmakerRepository.findOne(foodmakerId);
        DeleteUsers deleteUser = new DeleteUsers(foodmaker.getFoodmakerName(), foodmaker.getFoodmakerEmail(), foodmaker.getFoodmakerNic(), foodmaker.getFoodmakerAccessType(),
                foodmaker.getFoodmakerpassword(), foodmaker.getFoodmakerAddresId().getAddressId(), foodmaker.getFoodmakerImagePath(), foodmaker.getFoodmakerPhoneNumber());

        deleteUserRepository.save(deleteUser);
        foodmakerRepository.delete(foodmakerId);
    }

    private Double getDistance(double lat1, double long1, double lat2, double long2) {
        return 6371 * (Math.acos(
                ((Math.cos(Math.toRadians(lat2))
                        * (Math.cos(Math.toRadians(lat1)))
                        * (Math.cos(Math.toRadians(long1) - Math.toRadians(long2))))
                        + ((Math.sin(Math.toRadians(lat2)))
                        * (Math.sin(Math.toRadians(lat1)))))));
    }
}
