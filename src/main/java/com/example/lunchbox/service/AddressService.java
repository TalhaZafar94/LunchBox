package com.example.lunchbox.service;


import com.example.lunchbox.model.entity.Address;

public interface AddressService {

    void addAddress(Address dish);

    Address getAddressById(Integer id);

    void deleteAddress(Address admin);

}
