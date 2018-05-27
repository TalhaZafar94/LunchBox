package com.example.lunchbox.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "order_dishes")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Orderdishes {

    @Id
    @Column(name = "orderdishes_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderDishesId;

//    @Column(name = "order_id", insertable = false, updatable = false)
//    private Integer orderId;

    @Column(name = "dish_id")
    private Integer dishId;

    @OneToOne(fetch = FetchType.LAZY , mappedBy = "orderDishes", cascade = {CascadeType.ALL})
    private Dishes dishes;

    @Column(name = "quantity")
    private Double quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnore
    private Order order;

    public Orderdishes() {
    }

    public Orderdishes(Order order, Dishes dishes, Double quantity) {
        this.order = order;
        this.dishes = dishes;
        this.quantity = quantity;

    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    //    public Integer getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(Integer orderId) {
//        this.orderId = orderId;
//    }

    public Integer getOrderDishesId() {
        return orderDishesId;
    }

    public void setOrderDishesId(Integer orderDishesId) {
        this.orderDishesId = orderDishesId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {

        this.order = order;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderdishes that = (Orderdishes) o;

        if (!order.equals(that.order)) return false;
        return dishes.equals(that.dishes);
    }

    @Override
    public int hashCode() {
        int result = order.hashCode();
        result = 31 * result + dishes.hashCode();
        return result;
    }
}
