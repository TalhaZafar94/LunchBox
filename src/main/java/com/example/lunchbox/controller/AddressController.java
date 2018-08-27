package com.example.lunchbox.controller;

import com.example.lunchbox.model.entity.Address;
import com.example.lunchbox.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(value = "/save-address", method = RequestMethod.POST)
    public void addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
    }

    @RequestMapping(value = "/delete-address", method = RequestMethod.POST)
    public void deleteAddress(@RequestBody Address address) {
        addressService.deleteAddress(address);
    }

    @RequestMapping(value = "/get-address", method = RequestMethod.POST)
    public Address getAddress(@RequestBody Integer id) {
        return addressService.getAddressById(id);
    }

}
