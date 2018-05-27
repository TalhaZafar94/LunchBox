package com.example.lunchbox.repository;

import com.example.lunchbox.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order , Integer> {
    
}
