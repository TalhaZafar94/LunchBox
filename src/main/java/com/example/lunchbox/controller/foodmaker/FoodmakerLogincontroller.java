package com.example.lunchbox.controller.foodmaker;

import com.example.lunchbox.model.entity.Foodmaker;
import com.example.lunchbox.service.FoodmakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/foodmaker")
public class FoodmakerLogincontroller {

    private FoodmakerService foodmakerService;

    @Autowired
    public FoodmakerLogincontroller(FoodmakerService foodmakerService) {
    this.foodmakerService = foodmakerService;
    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public String verifyLogin(@RequestParam String userName, @RequestParam String password,
                              HttpSession session, Model model){

        Foodmaker foodmaker = foodmakerService.login(userName, password);
        if (foodmaker == null) {
            model.addAttribute("loginError", "Error logging in. Please try again");
            return "login";
        }
        session.setAttribute("loggedInUser", foodmaker);
        return "index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("loggedInUser");
        return "login";
    }

    @RequestMapping(value = "/signup" ,method = RequestMethod.POST)
    public String  signup(@RequestBody Foodmaker foodmaker){
        if(foodmaker.getFoodmakerpassword() != null && foodmaker.getFoodmakerEmail() != null && foodmaker.getFoodmakerName() != null &&
                foodmaker.getFoodmakerNic() != null && foodmaker.getFoodmakerPhoneNumber() != null)
        {
            foodmakerService.foodmakerSignup(foodmaker);
            return "foodmaker added";
        }
        return "please specify the fields";
    }

    @RequestMapping(value = "/update-password" ,method = RequestMethod.POST)
    public String updatePassword(@RequestParam String oldpassword, @RequestParam String newpassword , @RequestParam String foodmakerEmail){
        if(foodmakerService.updatePassword(oldpassword,newpassword,foodmakerEmail)){
            return "password updated";
        }
        return "error";
    }

    @RequestMapping(value = "/count-foodmakers", method = RequestMethod.GET)
    public long countFoodmakers() {
        return foodmakerService.countAllFoodMmkers();
    }

    @RequestMapping(value = "/foodmakers-list", method = RequestMethod.GET)
    public List<Foodmaker> findAllFoodmakers() {
        return foodmakerService.findAllFoodmakers();
    }

    @RequestMapping(value = "/delete-foodmaker", method = RequestMethod.POST)
    public String deleteFoodmaker(@RequestBody String foodmakerEmail) {
        foodmakerService.deleteFoodmaker(foodmakerEmail);
        return "foodmaker deleted";
    }

    @RequestMapping(value = "/search-foodmaker", method = RequestMethod.POST)
    public List<Foodmaker> searchFoodmakers(@RequestParam String foodmakerName) {
        return foodmakerService.getFoodmakerByname(foodmakerName);
    }

    @RequestMapping(value = "/foodmaker-listing" , method = RequestMethod.GET)
    public ModelAndView adminDetail() {
        ModelAndView modelAndView = new ModelAndView("foodmaker-listing");
        return modelAndView;
    }

    @RequestMapping(value = "/add-foodmaker" ,method = RequestMethod.GET)
    public ModelAndView getAddAdminView(){
        ModelAndView modelAndView = new ModelAndView("add-foodmaker");
        return modelAndView;
    }

    @RequestMapping(value = "/add-foodmaker" ,method = RequestMethod.POST)
    public ModelAndView getOrderDetail(@RequestParam Integer rowId){
        Foodmaker foodmaker = foodmakerService.getFoodmakerById(rowId);
        ModelAndView modelAndView = new ModelAndView("add-foodmaker");
        modelAndView.addObject("foodmakerDetail", foodmaker);

        return modelAndView;
    }

}
