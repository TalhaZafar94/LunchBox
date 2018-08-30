package com.example.lunchbox.model.entity;

import javax.persistence.*;

@Entity
@Table
public class RiderRequest {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "rider_id")
    private Integer riderId;

    @Column(name = "status")
    private Integer status;

    public RiderRequest(Integer orderId, Integer riderId, Integer status) {
        this.orderId = orderId;
        this.riderId = riderId;
        this.status = status;
    }

    public RiderRequest() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getRiderId() {
        return riderId;
    }

    public void setRiderId(Integer riderId) {
        this.riderId = riderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
