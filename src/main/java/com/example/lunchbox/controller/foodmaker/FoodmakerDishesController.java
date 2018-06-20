package com.example.lunchbox.controller.foodmaker;


import com.example.lunchbox.model.entity.FoodmakerDishes;
import com.example.lunchbox.service.FoodmakerDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping(value = "/foodmaker_dishes")
public class FoodmakerDishesController {

    private FoodmakerDishesService foodmakerDishesService;
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public FoodmakerDishesController(FoodmakerDishesService foodmakerDishesService) {
        this.foodmakerDishesService = foodmakerDishesService;
    }

    @RequestMapping(value = "/add-dish" ,method = RequestMethod.POST)
    public String  addDish(@RequestBody FoodmakerDishes foodmakerDish){

        if (foodmakerDish != null)
        {
            foodmakerDishesService.addDish(foodmakerDish);
            return "foodmaker added";
        }
        return "please specify the fields";
    }

    @RequestMapping(value = "/delete-foodmaker=dish", method = RequestMethod.POST)
    public String deleteFoodmakerDish(@RequestBody Integer foodmakerDishesId) {
        foodmakerDishesService.deleteFoodmakerDish(foodmakerDishesId);
        return "foodmaker dish deleted";
    }

    @RequestMapping(value = "/foodmakersdishes-list-bydishid", method = RequestMethod.GET)
    public List<FoodmakerDishes> getFoodmakerDishbyDishesId(@RequestParam Integer dishId) {
        return foodmakerDishesService.getFoodmakerDishbyDishesId(dishId);
    }


    @RequestMapping(value = "/foodmakersdishes-list-byfoodmakerid", method = RequestMethod.GET)
    public List<FoodmakerDishes> getFoodmakerDishbyFoodmakerId(@RequestParam Integer foodmakerId) {
        return foodmakerDishesService.getFoodmakerDishbyFoodmakerId(foodmakerId);
    }
/*
    @RequestMapping(value = "/foodmakersdishes-list-bydishid", method = RequestMethod.GET)
    public FoodmakerDishes getFoodmakerDishId(@RequestParam Integer id) {
        return foodmakerDishesService.getFoodmakerDishById(id);
    }
*/

    @RequestMapping(value = "/count-foodmakerdishes", method = RequestMethod.GET)
    public long countFoodmakersdishes() {
        return foodmakerDishesService.countAllFoodMmkerDishes();
    }

    @RequestMapping(value = "/find-all", method = RequestMethod.GET)
    public List<FoodmakerDishes> findAll() {
        return foodmakerDishesService.findAll();
    }

    @RequestMapping(value = "/upload-img", method = RequestMethod.POST)
    public String uploadImage(@RequestParam Integer id,@RequestParam("file") MultipartFile file) {
        String uploadedPath = null;
      //  adminService.findAllAdmin();
        FoodmakerDishes foodmakerDishes = foodmakerDishesService.getFoodmakerDishById(id);
        String UPLOADED_FOLDER = uploadPath;
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            foodmakerDishes.setImagepath(path.toString());

            uploadedPath = path.toString();
            foodmakerDishesService.addDish(foodmakerDishes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "{ \"uploadedPath\" : \"+uploadedPath+\"}";
    }
}