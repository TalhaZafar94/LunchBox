package com.example.lunchbox.service.Impl;

import com.example.lunchbox.model.entity.Customer;
import com.example.lunchbox.model.entity.DeleteUsers;
import com.example.lunchbox.model.entity.Order;
import com.example.lunchbox.repository.CustomerRepository;
import com.example.lunchbox.repository.DeleteUserRepository;
import com.example.lunchbox.repository.OrderRepository;
import com.example.lunchbox.service.CustomerService;
import com.example.lunchbox.service.OrderService;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private DeleteUserRepository deleteUserRepository;
    private OrderRepository orderRepository;
    private OrderService orderService;
    @Value("${upload.path}")
    private String uploadPath;
    @Value("${customerKey}")
    private String customerServerKey;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, DeleteUserRepository deleteUserRepository, OrderRepository orderRepository, OrderService orderService) {
        this.customerRepository = customerRepository;
        this.deleteUserRepository = deleteUserRepository;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @Override
    public void customerSignup(Customer customer) {
        if (customer.getCustomerId() == null) {
            try {
                customer.setCustomerPassword(getSHA256(customer.getCustomerPassword()));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.findOne(id);
    }

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
    public List<Customer> getCustomerByname(String customerName) {
        return customerRepository.findByCustomerName(customerName);
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
    public Customer login(String customerEmail, String customerPassword, String token) {
        Customer customer = this.findByCustomerEmail(customerEmail);
        try {
            if (customer != null && getSHA256(customerPassword).equals(customer.getCustomerPassword())) {
                if (customer.getCustomerRegToken() == null || !customer.getCustomerRegToken().equals(token)) {
                    customer.setCustomerRegToken(token);
                    customerRepository.save(customer);
                }
                return customer;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updatePassword(String oldpassword, String newpassword, String customerEmail) {
        Customer customer = this.findByCustomerEmail(customerEmail);
        try {
            if (customer != null && getSHA256(oldpassword).equals(customer.getCustomerPassword())) {
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
    public String getSHA256(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");

        messageDigest.update(password.getBytes());
        byte[] digest = messageDigest.digest();
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

    @Override
    public void saveImage(byte[] image, Customer customer) {

        String final_Path = "localhost:8080/images/";
        Path path = Paths.get(uploadPath + customer.getCustomerName());
        try {
            Files.write(path, image);
            final_Path += customer.getCustomerName();
            customer.setCustomerImagePath(final_Path);
            customerRepository.save(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Cascade(CascadeType.DELETE)
    @Transactional
    @Override
    public void deleteCustomerById(Integer customerId) {
        Customer customer = customerRepository.findOne(customerId);
        DeleteUsers deleteUsers = new DeleteUsers(customer.getCustomerName(), customer.getCustomerEmail(), customer.getCustomerNic(), customer.getCustomerAccessType(),
                customer.getCustomerPassword(), customer.getCustomerAddressId().getAddressId(), customer.getCustomerImagePath(), customer.getCustomerPhoneNumber());

        deleteUserRepository.save(deleteUsers);
        customerRepository.deleteCustomer(customerId);

        //customerRepository.delete(customerId);
    }

    @Override
    public List<Order> getOrdersByCustomerId(Integer customerId) {

        List<Order> allOrders = orderService.findAllOrders();
        List<Order> orderListbyCustomer_id = orderRepository.getAllByOrderCustomerId(customerId);
        List<Order> orderListbystatus_id = orderRepository.getAllByOrderStatus(1);

        if (orderListbyCustomer_id.size() > 0)
            allOrders.retainAll(orderListbyCustomer_id);

        if (orderListbystatus_id.size() > 0)
            allOrders.retainAll(orderListbystatus_id);

        if (allOrders.size() > 0) {
            return allOrders;
        }

        return null;
    }

    @Override
    public List<Order> getAckOrdersByCustomerId(Integer customerId) {
        List<Order> allOrders = orderService.findAllOrders();
        List<Order> orderListbyCustomer_id = orderRepository.getAllByOrderCustomerId(customerId);
        List<Order> orderListbystatus_id = orderRepository.getAllByOrderStatus(2);

        if (orderListbyCustomer_id.size() > 0)
            allOrders.retainAll(orderListbyCustomer_id);

        if (orderListbystatus_id.size() > 0)
            allOrders.retainAll(orderListbystatus_id);

        if (allOrders.size() > 0) {
            return allOrders;
        }

        return null;
    }

    @Override
    public List<Order> getDoneOrdersByCustomerId(Integer customerId) {
        List<Order> allOrders = orderService.findAllOrders();
        List<Order> orderListbyCustomer_id = orderRepository.getAllByOrderCustomerId(customerId);
        List<Order> orderListbystatus_id = orderRepository.getAllByOrderStatus(3);

        if (orderListbyCustomer_id.size() > 0)
            allOrders.retainAll(orderListbyCustomer_id);

        if (orderListbystatus_id.size() > 0)
            allOrders.retainAll(orderListbystatus_id);

        if (allOrders.size() > 0) {
            return allOrders;
        }

        return null;
    }
}
