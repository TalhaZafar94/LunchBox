package com.example.lunchbox.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reservationId;

    @Column(name = "foodmaker_id")
    private Integer reservationFoodmakerid;

    @Column(name = "rider_id")
    private Integer reservationRiderId;

    @Column(name = "reservation_date")
    private Date reservationDate;

    @Column(name = "reservation_status")
    private Integer reservationStatus;

    public Reservation() {
    }

    public Reservation(Integer reservationFoodmakerid, Integer reservationRiderId, Date reservationDate, Integer reservationStatus) {
        this.reservationFoodmakerid = reservationFoodmakerid;
        this.reservationRiderId = reservationRiderId;
        this.reservationDate = reservationDate;
        this.reservationStatus = reservationStatus;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getReservationFoodmakerid() {
        return reservationFoodmakerid;
    }

    public void setReservationFoodmakerid(Integer reservationFoodmakerid) {
        this.reservationFoodmakerid = reservationFoodmakerid;
    }

    public Integer getReservationRiderId() {
        return reservationRiderId;
    }

    public void setReservationRiderId(Integer reservationRiderId) {
        this.reservationRiderId = reservationRiderId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Integer getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(Integer reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
