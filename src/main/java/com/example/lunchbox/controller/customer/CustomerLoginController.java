package com.example.lunchbox.controller.customer;

import com.example.lunchbox.model.entity.Customer;
import com.example.lunchbox.service.CustomerService;
import com.example.lunchbox.service.Impl.AndroidPushNotificationsService;
import com.example.lunchbox.service.Impl.SendPushNotification;
import com.example.lunchbox.service.OrderService;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/customer")
public class CustomerLoginController{

    private CustomerService customerService;
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public CustomerLoginController(CustomerService customerService) {
    this.customerService = customerService;

    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST ,produces = "application/json")
    public Customer verifyLogin(@RequestParam String customerEmail, @RequestParam String customerPassword,
                              HttpSession session,@RequestParam String token){

        Customer customer = customerService.login(customerEmail, customerPassword,token);
        if (customer != null) {
            session.setAttribute("loggedInUser", customer);
            return customer;
        }
       return null;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("loggedInUser");
        return "login";
    }

    @RequestMapping(value = "/signup" ,method = RequestMethod.POST,produces = "application/json")
    public String  signup(@RequestBody Customer customer,@RequestParam byte[] image){
        if(customer.getCustomerPassword() != null && customer.getCustomerEmail() != null && customer.getCustomerName() != null &&
                customer.getCustomerNic() != null && customer.getCustomerPhoneNumber() != null)
        {
            customerService.customerSignup(customer);
            customerService.saveImage(image,customer);
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

    @RequestMapping(value = "/upload-img", method = RequestMethod.POST)
    public String uploadImage(@RequestParam Integer id,@RequestParam("file") MultipartFile file) {
        String uploadedPath = null;
        //  adminService.findAllAdmin();
        Customer customer = customerService.getCustomerById(id);
        String UPLOADED_FOLDER = uploadPath;
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            customer.setCustomerImagePath(path.toString());

            uploadedPath = path.toString();
                        customerService.customerSignup(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "{ \"uploadedPath\" : \"+uploadedPath+\"}";
    }

/*    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public ResponseEntity<String> send(@RequestParam String token)
    {
        AndroidPushNotificationsService androidPushNotificationsService = new AndroidPushNotificationsService(deviceId);

        JSONObject body = new JSONObject();
        body.put("to", token);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", "lunchbox Notification");
        notification.put("body", "you have an order!");

        JSONObject data = new JSONObject();
        data.put("Key-1", "order Data 1");
        data.put("Key-2", "order Data 2");

        body.put("notification", notification);
        body.put("data", data);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();

            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
    }*/
}
