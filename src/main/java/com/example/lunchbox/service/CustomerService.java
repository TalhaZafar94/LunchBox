package com.example.lunchbox.service;

import com.example.lunchbox.model.entity.Customer;
import com.example.lunchbox.model.entity.Order;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

public interface CustomerService {

    void customerSignup(Customer customer);

    Customer getCustomerById(Integer id);

    long countAllCustomers();

    void deleteCustomer(String customerEmail);

    List<Customer> getCustomerByname(String customerName);

    List<Customer> findAllCustomers();

    Customer login(String customerEmail, String customerPassword, String token);

    Customer findByCustomerEmail(String customerEmail);

    boolean updatePassword(String oldpassword, String newpassword, String customerEmail);

    String getSHA256(String password) throws NoSuchAlgorithmException;

    Customer getCustomersByCustomerCreatedAt(Date date);

    Customer getCustomersByCustomerLastUpdated(Date date);

    Customer findByCustomerId(Integer customerId);

    void saveImage(byte[] image, Customer customer);

    void deleteCustomerById(Integer customerId);

    List<Order> getOrdersByCustomerId(Integer customerId);

    List<Order> getAckOrdersByCustomerId(Integer customerId);

    List<Order> getDoneOrdersByCustomerId(Integer customerId);
}
