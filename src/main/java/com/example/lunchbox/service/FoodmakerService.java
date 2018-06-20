package com.example.lunchbox.service;

import com.example.lunchbox.model.entity.Foodmaker;

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
    Foodmaker login(String foodmakerEmail, String foodmakerPassword);
    Foodmaker findByFoodmakerEmail(String foodmakerEmail);
    boolean updatePassword(String oldpassword, String newpassword , String foodmakerEmail);
    String getSHA256(String password) throws NoSuchAlgorithmException;
    Foodmaker getFoodmakerByFoodmakerCreatedAt(Date date);
    Foodmaker getFoodmakerByFoodmakerLastUpdated(Date date);

    List<Foodmaker> getFoodmakersNearBy(Integer km, Double lat, Double longt);

}
