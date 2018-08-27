package com.example.lunchbox.service.Impl;

import com.example.lunchbox.model.entity.Address;
import com.example.lunchbox.repository.AddressRepository;
import com.example.lunchbox.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void addAddress(Address address) {
        addressRepository.saveAndFlush(address);
    }

    @Override
    public Address getAddressById(Integer id) {
        return addressRepository.findOne(id);
    }

    @Override
    public void deleteAddress(Address address) {
        addressRepository.delete(address);
    }
}
