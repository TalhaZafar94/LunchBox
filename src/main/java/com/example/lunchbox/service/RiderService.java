package com.example.lunchbox.service;

import com.example.lunchbox.model.entity.Rider;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

public interface RiderService {

    void riderSignup(Rider rider);

    Rider getRiderById(Integer id);

    long countAllRiders();

    void deleteRider(String riderEmail);

    List<Rider> getRiderByname(String riderName);

    Rider getRiderByRiderLastUpdated(Date date);

    Rider getRiderByRiderCreatedAt(Date date);

    List<Rider> findAllRiders();

    Rider login(String riderEmail, String riderPassword, String token);

    Rider findByRiderEmail(String riderEmail);

    boolean updatePassword(String oldpassword, String newpassword, String riderEmail);

    String getSHA256(String password) throws NoSuchAlgorithmException;

    void setStatus(int riderId, int status);

    List<Rider> getRidersNearBy(Double lat, Double longt, Integer orderId);
}
