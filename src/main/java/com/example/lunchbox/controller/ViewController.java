package com.example.lunchbox.controller;

import com.example.lunchbox.service.CustomerService;
import com.example.lunchbox.service.DishService;
import com.example.lunchbox.service.FoodmakerService;
import com.example.lunchbox.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ViewController {
    private CustomerService customerService;
    private OrderService orderService;
    private FoodmakerService foodmakerService;
    private DishService dishService;

    @Autowired
    public ViewController(CustomerService customerService, OrderService orderService, FoodmakerService foodmakerService, DishService dishService) {
        this.customerService = customerService;
        this.orderService = orderService;
        this.foodmakerService = foodmakerService;
        this.dishService = dishService;
    }


    @RequestMapping(path = "/")
    public ModelAndView welcome(HttpSession session) {
        ModelAndView modelAndView;

        if (session.getAttribute("loggedinAdmin") != null) {
            modelAndView = new ModelAndView("index");
            long totalCustomer = customerService.countAllCustomers();
            long totalOrder = orderService.countAllOrders();
            long totalFoodmaker = foodmakerService.countAllFoodMmkers();
            long totalDishes = dishService.countAllDishes();

            modelAndView.addObject("totalCustomer", totalCustomer);
            modelAndView.addObject("totalOrder", totalOrder);
            modelAndView.addObject("totalFoodmaker", totalFoodmaker);
            modelAndView.addObject("totalDishes", totalDishes);
            return modelAndView;
            //return "index";
        }
        modelAndView = new ModelAndView("login");
        return modelAndView;
        //  return "login";
    }

/*
    @RequestMapping(value = "/signup")
    public String signup() {
        return "changePassword";
    }
*/

    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(HttpSession session) {
      /*  if(session.getAttribute("loggedinAdmin") != null){
            return "index";
        }*/
        return "login";
    }

    @RequestMapping(value = "/changePassword")
    public String register() {
        return "changePassword";
    }

    // for admin

    @RequestMapping(value = "/admin-listing", method = RequestMethod.GET)
    public String adminDetail() {
        return "admin-listing";
    }

    @RequestMapping(value = "/add-admin")
    public String addAdmin() {
        return "add-admin";
    }

    @RequestMapping(value = "/foodmaker-listing", method = RequestMethod.GET)
    public String foodmakerListing() {
        return "foodmaker-listing";
    }

    @RequestMapping(value = "/add-foodmaker")
    public String addFoodmaker() {
        return "add-foodmaker";
    }


    @RequestMapping(value = "/customer-listing", method = RequestMethod.GET)
    public String getCustomerListingView() {

        return "customer-listing";
    }

    @RequestMapping(value = "/add-customer", method = RequestMethod.GET)
    public String addCustomerView() {

        return "add-customer";
    }

    @RequestMapping(value = "/rider-listing", method = RequestMethod.GET)
    public String getRiderListingView() {

        return "rider-listing";
    }

    @RequestMapping(value = "/add-rider", method = RequestMethod.GET)
    public String addRiderView() {

        return "add-rider";
    }

    @RequestMapping(value = "/dishes-listing", method = RequestMethod.GET)
    public String getDishesListingView() {
        return "dishes-listing";
    }

    @RequestMapping(value = "/add-dishes", method = RequestMethod.GET)
    public String getAddDishesView() {
        return "add-dishes";
    }

    @RequestMapping(value = "/order-listing", method = RequestMethod.GET)
    public String getOrderListing() {
        return "order-listing";
    }

    @RequestMapping(value = "/order-detail", method = RequestMethod.GET)
    public String getOrderDetail() {
        return "order-detail";
    }

}
