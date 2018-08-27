package com.example.lunchbox.repository;

import com.example.lunchbox.model.entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Integer> {
    Rider findByRiderEmail(String riderEmail);

    List<Rider> findByRiderName(String riderName);

    Rider getRiderByRiderLastUpdated(Date date);

    Rider getRiderByRiderCreatedAt(Date date);

}
