package com.example.lunchbox.repository;

import com.example.lunchbox.model.entity.Orderdishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDishesRepository extends JpaRepository<Orderdishes, Integer> {
}
