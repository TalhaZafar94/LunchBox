package com.example.lunchbox.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @Column(name = "customer_id")
    private Integer orderCustomerId;

    @Column(name = "reservation_id")
    private Integer orderReservationId;

    @Column(name = "foodmaker_id")
    private Integer foodmakerId;

    @Column(name = "shipment_address")
    private String orderShipmentAddress;

    @Column(name = "order_date",columnDefinition = "DATETIME")
    private Date orderDate;

    @Column(name = "order_deliver_date",columnDefinition = "DATETIME")
    private Date orderDeliverDate;

    @Column(name = "order_totalamount")
    private Float orderTotalAmount;

    @Column(name = "order_status")
    private Integer orderStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<Orderdishes> orderdishes;

    @OneToOne(fetch = FetchType.LAZY , mappedBy = "order", cascade = {CascadeType.ALL})
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY , mappedBy = "order", cascade = {CascadeType.ALL})
    private Foodmaker foodmaker;

    public Order() {
    }

    public Order(Integer orderCustomerId, Integer orderReservationId, String orderShipmentAddress, Date orderDate, Date orderDeliverDate, Float orderTotalAmount, Integer orderStatus, List<Orderdishes> orderdishes,Integer foodmakerId) {
        this.orderCustomerId = orderCustomerId;
        this.orderReservationId = orderReservationId;
        this.orderShipmentAddress = orderShipmentAddress;
        this.orderDate = orderDate;
        this.orderDeliverDate = orderDeliverDate;
        this.orderTotalAmount = orderTotalAmount;
        this.orderStatus = orderStatus;
        this.orderdishes = orderdishes;
        this.foodmakerId = foodmakerId;
    }

    public Integer getOrderCustomerId() {
        return orderCustomerId;
    }

    public void setOrderCustomerId(Integer orderCustomerId) {
        this.orderCustomerId = orderCustomerId;
    }


    public List<Orderdishes> getOrderdishes() {
        return orderdishes;
    }

    public void setOrderdishes(List<Orderdishes> orderdishes) {
        this.orderdishes = orderdishes;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderReservationId() {
        return orderReservationId;
    }

    public void setOrderReservationId(Integer orderReservationId) {
        this.orderReservationId = orderReservationId;
    }

    public String getOrderShipmentAddress() {
        return orderShipmentAddress;
    }

    public void setOrderShipmentAddress(String orderShipmentAddress) {
        this.orderShipmentAddress = orderShipmentAddress;
    }

    public String getOrderDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(orderDate);
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDeliverDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(orderDeliverDate);
    }

    public void setOrderDeliverDate(Timestamp orderDeliverDate) {
        this.orderDeliverDate = orderDeliverDate;
    }

    public Float getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(Float orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public Integer getFoodmakerId() {
        return foodmakerId;
    }

    public void setFoodmakerId(Integer foodmakerId) {
        this.foodmakerId = foodmakerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Foodmaker getFoodmaker() {
        return foodmaker;
    }

    public void setFoodmaker(Foodmaker foodmaker) {
        this.foodmaker = foodmaker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return Objects.equals(orderId,order.orderId);
    }
}
