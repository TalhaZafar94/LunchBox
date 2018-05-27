package com.example.lunchbox.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blocked_users")
public class Blockedusers {

    @Id
    @Column(name = "blocked_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer blokedId;

    @Column(name = "customer_id" ,unique = true)
    private Integer blockedCustomerId;

    @Column(name = "foodmaker_id" ,unique = true)
    private Integer blockedFoodmakerId;

    @Column(name = "rider_id" ,unique = true)
    private Integer blockedRiderId;

    @Column(name = "admin_id")
    private Integer blockerAdminId;

    @Column(name = "blocked_date")
    private Date blockedDate;

    public Blockedusers() {
    }

    public Blockedusers(Integer blockedCustomerId, Integer blockedFoodmakerId, Integer blockedRiderId, Integer blockerAdminId, Date blockedDate) {
        this.blockedCustomerId = blockedCustomerId;
        this.blockedFoodmakerId = blockedFoodmakerId;
        this.blockedRiderId = blockedRiderId;
        this.blockerAdminId = blockerAdminId;
        this.blockedDate = blockedDate;
    }

    public Integer getBlokedId() {
        return blokedId;
    }

    public void setBlokedId(Integer blokedId) {
        this.blokedId = blokedId;
    }

    public Integer getBlockedCustomerId() {
        return blockedCustomerId;
    }

    public void setBlockedCustomerId(Integer blockedCustomerId) {
        this.blockedCustomerId = blockedCustomerId;
    }

    public Integer getBlockedFoodmakerId() {
        return blockedFoodmakerId;
    }

    public void setBlockedFoodmakerId(Integer blockedFoodmakerId) {
        this.blockedFoodmakerId = blockedFoodmakerId;
    }

    public Integer getBlockedRiderId() {
        return blockedRiderId;
    }

    public void setBlockedRiderId(Integer blockedRiderId) {
        this.blockedRiderId = blockedRiderId;
    }

    public Integer getBlockerAdminId() {
        return blockerAdminId;
    }

    public void setBlockerAdminId(Integer blockerAdminId) {
        this.blockerAdminId = blockerAdminId;
    }

    public Date getBlockedDate() {
        return blockedDate;
    }

    public void setBlockedDate(Date blockedDate) {
        this.blockedDate = blockedDate;
    }
}
