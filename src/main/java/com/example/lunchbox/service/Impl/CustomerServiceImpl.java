package com.example.lunchbox.service.Impl;

import com.example.lunchbox.model.entity.Customer;
import com.example.lunchbox.repository.CustomerRepository;
import com.example.lunchbox.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void customerSignup(Customer customer) {
    if(customer.getCustomerId() == null){
        try {
            customer.setCustomerPassword(getSHA256(customer.getCustomerPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

        customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) { return customerRepository.findOne(id); }

    @Override
    public long countAllCustomers() {
        return customerRepository.count();
    }

    @Override
    public void deleteCustomer(String customerEmail) {
        Customer customer = this.findByCustomerEmail(customerEmail);
        customerRepository.delete(customer.getCustomerId());
    }

    @Override
    public List<Customer> getCustomerByname(String customerName)
    {
        return  customerRepository.findByCustomerName(customerName);
    }

    @Override
    public List<Customer> findAllCustomers() {

       return customerRepository.findAll();
    }

    @Override
    public Customer findByCustomerEmail(String customerEmail) {
        return customerRepository.findByCustomerEmail(customerEmail);
    }

    @Override
    public Customer login(String customerEmail, String customerPassword) {
        Customer customer = this.findByCustomerEmail(customerEmail);
        try {
            if (customer != null && getSHA256(customerPassword).equals(customer.getCustomerPassword())) {
                return customer;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updatePassword(String oldpassword, String newpassword , String customerEmail) {
        Customer customer = this.findByCustomerEmail(customerEmail);
        try {
            if(customer != null && getSHA256(oldpassword).equals(customer.getCustomerPassword()))
            {
                customer.setCustomerPassword(getSHA256(newpassword));
                customerRepository.saveAndFlush(customer);
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getSHA256(String password) throws NoSuchAlgorithmException
    {
        MessageDigest messageDigest=MessageDigest.getInstance("SHA-512");

        messageDigest.update(password.getBytes());
        byte[] digest=messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((int) (b & 0xff)));
        }
        return sb.toString();
    }

    @Override
    public Customer getCustomersByCustomerCreatedAt(Date date) {
        return customerRepository.getCustomersByCustomerCreatedAt(date);
    }

    @Override
    public Customer getCustomersByCustomerLastUpdated(Date date) {
        return customerRepository.getCustomersByCustomerLastUpdated(date);
    }

    @Override
    public Customer findByCustomerId(Integer customerId) {
        return customerRepository.findByCustomerId(customerId);
    }

}
