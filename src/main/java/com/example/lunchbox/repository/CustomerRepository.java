package com.example.lunchbox.repository;

import com.example.lunchbox.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

   Customer findByCustomerEmail(String customerEmail);
   Customer findByCustomerId(Integer customerId);
   List<Customer> findByCustomerName(String customerName);
   Customer getCustomersByCustomerCreatedAt(Date date);
   Customer getCustomersByCustomerLastUpdated(Date date);
}
