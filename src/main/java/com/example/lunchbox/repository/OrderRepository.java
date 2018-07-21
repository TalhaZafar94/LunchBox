package com.example.lunchbox.repository;

import com.example.lunchbox.model.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order , Integer> {

    List<Order> getAllByFoodmakerId(Integer foodmakerId);
}
