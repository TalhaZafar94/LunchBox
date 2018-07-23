package com.example.lunchbox.service;

import com.example.lunchbox.model.entity.Dishes;
import com.example.lunchbox.model.entity.Foodmaker;
import com.example.lunchbox.model.entity.Order;
import com.example.lunchbox.model.entity.Ratings;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;


public interface FoodmakerService {

    void foodmakerSignup(Foodmaker foodmaker);
    Foodmaker getFoodmakerById(Integer id);
    long countAllFoodMmkers();
    void deleteFoodmaker(String foodmakerEmail);
    List <Foodmaker> getFoodmakerByname(String foodmakerName);
    List<Foodmaker> findAllFoodmakers();
    Foodmaker login(String foodmakerEmail, String foodmakerPassword,String token);
    Foodmaker findByFoodmakerEmail(String foodmakerEmail);
    boolean updatePassword(String oldpassword, String newpassword , String foodmakerEmail);
    String getSHA256(String password) throws NoSuchAlgorithmException;
    Foodmaker getFoodmakerByFoodmakerCreatedAt(Date date);
    Foodmaker getFoodmakerByFoodmakerLastUpdated(Date date);
    List<Foodmaker> getFoodmakersNearBy(Double lat, Double longt);
    void setStatus(int foodmakerId,int status);
    void setRatings(int customerId,int foodmakerId,int stars);
    List<Ratings> getRatingsByFoodmakerId(Integer foodmakerId);
    void saveImage(byte[] image,Foodmaker foodmaker);
    List<Order> getOrdersByfoodmakerId(Integer foodmakerId);
}
