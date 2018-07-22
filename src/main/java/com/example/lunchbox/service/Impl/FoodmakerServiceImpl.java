package com.example.lunchbox.service.Impl;


import com.example.lunchbox.model.entity.*;
import com.example.lunchbox.repository.FoodmakerRepository;
import com.example.lunchbox.repository.LocationRepository;
import com.example.lunchbox.repository.OrderRepository;
import com.example.lunchbox.repository.RatingRepository;
import com.example.lunchbox.service.FoodmakerService;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
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
    private static final String key = "AIzaSyD6zBHiASrQgjYjoEyRJphf8uOpVbPtQCg";
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public FoodmakerServiceImpl(FoodmakerRepository foodmakerRepository,LocationRepository locationRepository
                                ,RatingRepository ratingRepository,OrderRepository orderRepository) {
        this.foodmakerRepository = foodmakerRepository;
        this.locationRepository = locationRepository;
        this.ratingRepository = ratingRepository;
        this.orderRepository = orderRepository;
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

        if(object != null && object.length() > 0) {

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
    public List <Foodmaker> getFoodmakerByname(String foodmakerName) {
        return foodmakerRepository.findByFoodmakerName(foodmakerName);
    }

    @Override
    public List<Foodmaker> findAllFoodmakers() {

        List<Foodmaker> getAll = new ArrayList<>();

        for(Foodmaker foodmaker:foodmakerRepository.findAll())
        {
            if(foodmaker.getFoodmakerActive() == 0)
            {
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
    public Foodmaker login(String foodmakerEmail, String foodmakerPassword,String token) {
        Foodmaker foodmaker = this.findByFoodmakerEmail(foodmakerEmail);
        try {
            if (foodmaker != null && getSHA256(foodmakerPassword).equals(foodmaker.getFoodmakerpassword())) {
                if(foodmaker.getFoodmakerRegToken() == null || !foodmaker.getFoodmakerRegToken().equals(token))
                {
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
    public boolean updatePassword(String oldpassword, String newpassword , String foodmakerEmail) {
        Foodmaker foodmaker = this.findByFoodmakerEmail(foodmakerEmail);
        try {
            if(foodmaker != null && getSHA256(oldpassword).equals(foodmaker.getFoodmakerpassword()))
            {
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
    public Foodmaker getFoodmakerByFoodmakerCreatedAt(Date date) {
        return foodmakerRepository.getFoodmakerByFoodmakerCreatedAt(date);
    }

    @Override
    public Foodmaker getFoodmakerByFoodmakerLastUpdated(Date date) {
        return foodmakerRepository.getFoodmakerByFoodmakerLastUpdated(date);
    }

    private static JSONObject getLatLng(String address)
    {
        address = address.replace(" ","+");
        String uri = "https://maps.googleapis.com/maps/api/geocode/json?address="+address+"&key="+key;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        JSONObject jsonObject = new JSONObject(result);

        JSONArray jsonArray = (JSONArray) jsonObject.get("results");
        JSONObject firstObject = (JSONObject) jsonArray.get(0);
        JSONObject geometryObject = (JSONObject) firstObject.get("geometry");

        return (JSONObject) geometryObject.get("location");
    }

    @Override
    public List<Foodmaker> getFoodmakersNearBy(Double lat, Double longt){

        List<Foodmaker> inlocations = new ArrayList<>();
        try {
           int count = 6;
           List<Location> locations = locationRepository.findAll();
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
                           if(foodmaker.getFoodmakerActive() == 0)
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
                           if(foodmaker.getFoodmakerActive() == 0)
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

        return inlocations;
    }

    @Override
    public void setStatus(int foodmakerId,int status)
    {
        Foodmaker foodmaker = foodmakerRepository.findOne(foodmakerId);
        foodmaker.setFoodmakerActive(status);
        foodmakerRepository.save(foodmaker);
    }

    @Override
    public void setRatings(int customerId, int foodmakerId, int stars) {
        Ratings ratings = new Ratings(customerId,foodmakerId,stars);
        ratingRepository.save(ratings);
    }

    @Override
    public List<Ratings> getRatingsByFoodmakerId(Integer foodmakerId) {
        return ratingRepository.getRatingsByFoodmakerId(foodmakerId);
    }

    @Override
    public void saveImage(byte[] image,Foodmaker foodmaker) {

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
    public List<Order> getOrdersByfoodmakerId(Integer foodmakerId)
    {
        List<Order> orderList = orderRepository.getAllByFoodmakerId(foodmakerId);

        if(orderList.size() > 0)
        {
            return orderList;
        }

        return orderList;
    }

}
