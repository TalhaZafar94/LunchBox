package com.example.lunchbox.service.Impl;

import com.example.lunchbox.model.entity.Rider;
import com.example.lunchbox.repository.RiderRepository;
import com.example.lunchbox.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

@Service
public class RiderServiceImpl implements RiderService {

    private RiderRepository riderRepository;

    @Autowired
    public RiderServiceImpl(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
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
    public Rider login(String riderEmail, String riderPassword,String token) {
        Rider rider = this.findByRiderEmail(riderEmail);
        try {
            if (rider != null && getSHA256(riderPassword).equals(rider.getRiderPassword())) {
                if(rider.getRiderRegToken() == null || !rider.getRiderRegToken().equals(token))
                {
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
    public boolean updatePassword(String oldpassword, String newpassword , String riderEmail) {
        Rider rider = this.findByRiderEmail(riderEmail);
        try {
            if(rider != null && getSHA256(oldpassword).equals(rider.getRiderPassword()))
            {
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
    public String getSHA256(String password) throws NoSuchAlgorithmException
    {
        MessageDigest messageDigest=MessageDigest.getInstance("SHA-512");

        messageDigest.update(password.getBytes());
        byte[] digest=messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((int) (b & 0xff)));
        }
        return sb.toString();
    }
    @Override
    public void setStatus(int riderId,int status)
    {
        Rider rider = riderRepository.findOne(riderId);
        rider.setRiderActive(status);
        riderRepository.save(rider);


    }
}
