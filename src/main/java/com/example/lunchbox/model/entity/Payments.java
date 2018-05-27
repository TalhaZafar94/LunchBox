package com.example.lunchbox.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payments {

    @Id
    @Column(name = "payment_id")
    private Integer paymentId;

    @Column(name = "order_id", unique = true)
    private Integer paymentOrderId;

    @Column(name = "payment_cleared")
    private Integer paymentCleared;

    @Column(name = "payment_date")
    private Date paymentDate;

    public Payments() {
    }

    public Payments(Integer paymentOrderId, Integer paymentCleared, Date paymentDate) {
        this.paymentOrderId = paymentOrderId;
        this.paymentCleared = paymentCleared;
        this.paymentDate = paymentDate;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getPaymentOrderId() {
        return paymentOrderId;
    }

    public void setPaymentOrderId(Integer paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }

    public Integer getPaymentCleared() {
        return paymentCleared;
    }

    public void setPaymentCleared(Integer paymentCleared) {
        this.paymentCleared = paymentCleared;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
