package com.example.lunchbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class ViewController {

    @RequestMapping(path = "/")
    public String welcome(HttpSession session) {
        if(session.getAttribute("loggedinAdmin") != null)
        {
            return "index";
        }
        return "login";
    }

    @RequestMapping(value = "/signup")
    public String signup() {
        return "register";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(HttpSession session) {
        if(session.getAttribute("loggedinAdmin") != null){
            return "index";
        }
        return "login";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }

    // for admin

    @RequestMapping(value = "/admin-listing" , method = RequestMethod.GET)
    public String adminDetail() {
        return "admin-listing";
    }

    @RequestMapping(value = "/add-admin")
    public String addAdmin() {
        return "add-admin";
    }

    @RequestMapping(value = "/foodmaker-listing" , method = RequestMethod.GET)
    public String foodmakerListing() {
        return "foodmaker-listing";
    }

    @RequestMapping(value = "/add-foodmaker")
    public String addFoodmaker() {
        return "add-foodmaker";
    }


    @RequestMapping(value = "/customer-listing" ,method = RequestMethod.GET)
    public String  getCustomerListingView(){

        return "customer-listing";
    }

    @RequestMapping(value = "/add-customer" ,method = RequestMethod.GET)
    public String  addCustomerView(){

        return "add-customer";
    }

    @RequestMapping(value = "/rider-listing" ,method = RequestMethod.GET)
    public String  getRiderListingView(){

        return "rider-listing";
    }
    @RequestMapping(value = "/add-rider" ,method = RequestMethod.GET)
    public String  addRiderView(){

        return "add-rider";
    }
    @RequestMapping(value = "/dishes-listing" ,method = RequestMethod.GET)
    public String  getDishesListingView(){
        return "dishes-listing";
    }

    @RequestMapping(value = "/add-dishes" ,method = RequestMethod.GET)
    public String  getAddDishesView(){
        return "add-dishes";
    }

    @RequestMapping(value = "/order-lisitng" ,method = RequestMethod.GET)
    public String  getOrderListing(){
        return "order-listing";
    }

    @RequestMapping(value = "/order-detail" ,method = RequestMethod.GET)
    public String  getOrderDetail(){
        return "order-detail";
    }

}
