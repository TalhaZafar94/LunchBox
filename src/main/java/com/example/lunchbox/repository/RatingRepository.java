package com.example.lunchbox.repository;

import com.example.lunchbox.model.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Ratings, Integer> {

    @Query(value = "select avg(stars) as avergae from lunchbox.ratings where foodmaker_id = ?1 ", nativeQuery = true)
    Double getAverage(Integer foodmakerId);

    List<Ratings> getRatingsByFoodmakerId(Integer foodmakerId);
}
