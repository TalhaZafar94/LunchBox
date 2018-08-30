package com.example.lunchbox.controller.rider;

import com.example.lunchbox.model.entity.Order;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Rider verifyLogin(@RequestParam String riderEmail, @RequestParam String riderPassword,
                             HttpSession session, Model model, @RequestParam String token) {

        Rider rider = riderService.login(riderEmail, riderPassword, token);
        if (rider == null) {
            model.addAttribute("loginError", "Error logging in. Please try again");
            return null;
        }
        session.setAttribute("loggedInUser", rider);
        return rider;

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("loggedInUser");
        return "login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@RequestBody Rider rider) {
        if (rider.getRiderPassword() != null && rider.getRiderEmail() != null && rider.getRiderName() != null &&
                rider.getRiderNic() != null && rider.getRiderPhoneNumber() != null) {
            riderService.riderSignup(rider);
            return "rider added";
        }
        return "please specify the fields";
    }

    @RequestMapping(value = "/update-password", method = RequestMethod.POST)
    public String updatePassword(@RequestParam String oldpassword, @RequestParam String newpassword, @RequestParam String riderEmail) {
        if (riderService.updatePassword(oldpassword, newpassword, riderEmail)) {
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

    @RequestMapping(value = "/set-status", method = RequestMethod.POST) //1 : active, 2: unactive,3: assigned a job
    public String setStatus(@RequestParam Integer riderId, @RequestParam Integer status) {
        riderService.setStatus(riderId, status);
        return "{ \"status\" : \"" + status + "\"}";
    }

    @RequestMapping(value = "/send-notification-near-by-riders", method = RequestMethod.GET)
    public void findNearByFoodmakers(@RequestParam Double lat, @RequestParam Double longt, @RequestParam Integer orderId) {
        riderService.getRidersNearBy(lat, longt, orderId);
    }

    @RequestMapping(value = "/get-rider-orders", method = RequestMethod.GET)
    public List<Order> findNearByFoodmakers(@RequestParam Integer riderId) {
        return riderService.getOrderByRiderId(riderId);
    }

    @RequestMapping(value = "/set-rider-request-status", method = RequestMethod.POST)
    public String setRiderRequestStatus(@RequestParam Integer riderId, @RequestParam Integer status) {
        riderService.updateRiderRequestStatus(status,riderId);
        return "{ \"status\" : \"" + status + "\"}";
    }
}
