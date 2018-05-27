package com.example.lunchbox.controller.rider;

import com.example.lunchbox.model.entity.Rider;
import com.example.lunchbox.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping(value = "/rider")
@RestController
public class Ridercontroller {

    private RiderService riderService;

    @Autowired
    public Ridercontroller(RiderService riderService) {
        this.riderService = riderService;
    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public String verifyLogin(@RequestParam String riderEmail, @RequestParam String riderPassword,
                              HttpSession session, Model model){

        Rider rider = riderService.login(riderEmail, riderPassword);
        if (rider == null) {
            model.addAttribute("loginError", "Error logging in. Please try again");
            return "login";
        }
        session.setAttribute("loggedInUser", rider);
        return "index";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("loggedInUser");
        return "login";
    }

    @RequestMapping(value = "/signup" ,method = RequestMethod.POST)
    public String  signup(@RequestBody Rider rider){
        if(rider.getRiderPassword() != null && rider.getRiderEmail() != null && rider.getRiderName() != null &&
                rider.getRiderNic() != null && rider.getRiderPhoneNumber() != null)
        {
            riderService.riderSignup(rider);
            return "rider added";
        }
        return "please specify the fields";
    }

    @RequestMapping(value = "/update-password" ,method = RequestMethod.POST)
    public String updatePassword(@RequestParam String oldpassword, @RequestParam String newpassword , @RequestParam String riderEmail){
        if(riderService.updatePassword(oldpassword,newpassword,riderEmail)){
            return "password updated";
        }
        return "error";
    }

    @RequestMapping(value = "/count-riders", method = RequestMethod.GET)
    public long countRiders() {
        return riderService.countAllRiders();
    }

    @RequestMapping(value = "/riders-list", method = RequestMethod.GET)
    public List<Rider> findAllRiders() {
        return riderService.findAllRiders();
    }

    @RequestMapping(value = "/delete-rider", method = RequestMethod.POST)
    public String deleteRider(@RequestBody String riderEmail) {
        riderService.deleteRider(riderEmail);
        return "rider deleted";
    }

    @RequestMapping(value = "/search-rider", method = RequestMethod.POST)
    public List<Rider> searchRiders(@RequestParam String riderName) {
        return riderService.getRiderByname(riderName);
    }


}
