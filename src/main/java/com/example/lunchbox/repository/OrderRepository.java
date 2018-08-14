package com.example.lunchbox.repository;

import com.example.lunchbox.model.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order , Integer> {

    List<Order> getAllByFoodmakerId(Integer foodmakerId);
    List<Order> getAllByOrderCustomerId(Integer customerId);
    List<Order> getAllByOrderStatus(Integer status);

    @Transactional
    @Modifying
    @Query("Update Order orde SET orde.orderStatus=:orderStatus WHERE orde.orderId=:orderId")
    public void updateOrderStatus(@Param("orderStatus") Integer orderStatus, @Param("orderId") Integer orderId);

    @Transactional
    @Modifying
    @Query("Update Order orde SET orde.orderRating=:orderRating WHERE orde.orderId=:orderId")
    public void updateOrderRating(@Param("orderRating") Integer orderRating, @Param("orderId") Integer orderId);

}


