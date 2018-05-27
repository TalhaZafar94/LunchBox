package com.example.lunchbox.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "updatedishes")
public class Updatedishes {

    @Id
    @Column(name = "updatedishes_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer updateDishesId;

    @Column(name = "foodmaker_id")
    private Integer updateDishesFoodmakerId;

    @Column(name = "dish_id")
    private Integer updateDishesDishId;

    @Column(name = "dish_amount")
    private Double updateDishesDishAmount;

    public Updatedishes() {
    }

    public Updatedishes(Integer updateDishesFoodmakerId, Integer updateDishesDishId, Double updateDishesDishAmount) {
        this.updateDishesFoodmakerId = updateDishesFoodmakerId;
        this.updateDishesDishId = updateDishesDishId;
        this.updateDishesDishAmount = updateDishesDishAmount;
    }

    public Integer getUpdateDishesId() {
        return updateDishesId;
    }

    public void setUpdateDishesId(Integer updateDishesId) {
        this.updateDishesId = updateDishesId;
    }

    public Integer getUpdateDishesFoodmakerId() {
        return updateDishesFoodmakerId;
    }

    public void setUpdateDishesFoodmakerId(Integer updateDishesFoodmakerId) {
        this.updateDishesFoodmakerId = updateDishesFoodmakerId;
    }

    public Integer getUpdateDishesDishId() {
        return updateDishesDishId;
    }

    public void setUpdateDishesDishId(Integer updateDishesDishId) {
        this.updateDishesDishId = updateDishesDishId;
    }

    public Double getUpdateDishesDishAmount() {
        return updateDishesDishAmount;
    }

    public void setUpdateDishesDishAmount(Double updateDishesDishAmount) {
        this.updateDishesDishAmount = updateDishesDishAmount;
    }
}
