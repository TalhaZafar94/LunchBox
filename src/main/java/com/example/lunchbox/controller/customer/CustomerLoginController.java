package com.example.lunchbox.controller.customer;

import com.example.lunchbox.model.entity.Customer;
import com.example.lunchbox.service.CustomerService;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/customer")
public class CustomerLoginController{

    private CustomerService customerService;

    @Autowired
    public CustomerLoginController(CustomerService customerService) {
    this.customerService = customerService;
    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST ,produces = "application/json")
    public String verifyLogin(@RequestParam String customerEmail, @RequestParam String customerPassword,
                              HttpSession session, Model model){

        Customer customer = customerService.login(customerEmail, customerPassword);
        if (customer == null) {
            model.addAttribute("loginError", "Error logging in. Please try again");
            //return JSONObject.quote("login");
            return "{\"status\":\"false\"}";
        }
        session.setAttribute("loggedInUser", customer);
       // return JSONObject.quote("index");
        return "{\"status\":\"true\"}";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("loggedInUser");
        return "login";
    }

    @RequestMapping(value = "/signup" ,method = RequestMethod.POST,produces = "application/json")
    public String  signup(@RequestBody Customer customer){
        if(customer.getCustomerPassword() != null && customer.getCustomerEmail() != null && customer.getCustomerName() != null &&
                customer.getCustomerNic() != null && customer.getCustomerPhoneNumber() != null)
        {
            customerService.customerSignup(customer);
            return "{\"status\":\"true\"}";
        }
        return "{\"status\":\"false\"}";
    }

    @RequestMapping(value = "/update-password" ,method = RequestMethod.POST)
    public String updatePassword(@RequestParam String oldpassword, @RequestParam String newpassword , @RequestParam String customerEmail){
        if(customerService.updatePassword(oldpassword,newpassword,customerEmail)){
            return "password updated";
        }
    return "error";
    }

    @RequestMapping(value = "/count-customers", method = RequestMethod.GET)
    public long countCustomers() {
        return customerService.countAllCustomers();
    }

    @RequestMapping(value = "/customers-list",method = RequestMethod.GET)
    public List<Customer> findAllCustomers(){
        return customerService.findAllCustomers();
    }

    @RequestMapping(value = "/delete-customer", method = RequestMethod.POST)
    public String deleteCustomer(@RequestBody String customerEmail) {
        customerService.deleteCustomer(customerEmail);
        return "customer deleted";
    }

    @RequestMapping(value = "/search-customer",method = RequestMethod.POST)
    public List <Customer> searchCustomers(@RequestParam String customerName){
        return customerService.getCustomerByname(customerName);
    }

    @RequestMapping(value = "/findId",method = RequestMethod.GET)
    public Customer findId(@RequestParam Integer id){
        return customerService.findByCustomerId(id);
    }

    @RequestMapping(value = "/customer-listing" , method = RequestMethod.GET)
    public ModelAndView adminDetail() {
        ModelAndView modelAndView = new ModelAndView("customer-listing");
        return modelAndView;
    }

    @RequestMapping(value = "/add-customer" ,method = RequestMethod.GET)
    public ModelAndView getAddAdminView(){
        ModelAndView modelAndView = new ModelAndView("add-customer");
        return modelAndView;
    }

    @RequestMapping(value = "/add-customer" ,method = RequestMethod.POST)
    public ModelAndView getOrderDetail(@RequestParam Integer rowId){
        Customer customer = customerService.getCustomerById(rowId);
        ModelAndView modelAndView = new ModelAndView("add-customer");
        modelAndView.addObject("customerDetail", customer);

        return modelAndView;
    }
}
