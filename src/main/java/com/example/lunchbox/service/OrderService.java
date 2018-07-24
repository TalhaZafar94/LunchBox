package com.example.lunchbox.service;

import com.example.lunchbox.model.entity.Order;

import java.util.List;

public interface OrderService {

    void saveOrder(Order order);
    void editOrder(Order order);
    Order getOrderById(Integer id);
    long countAllOrders();
    void deleteOrder(Order order);
    List<Order> findAllOrders();
    void updateOrderStatus(Integer statusValue,Integer orderId);


}
