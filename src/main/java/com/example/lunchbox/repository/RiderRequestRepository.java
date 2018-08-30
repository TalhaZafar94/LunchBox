package com.example.lunchbox.repository;

import com.example.lunchbox.model.entity.RiderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RiderRequestRepository extends JpaRepository<RiderRequest, Integer> {
    List<RiderRequest> getAllByRiderId(Integer riderId);

    @Transactional
    @Modifying
    @Query("Update RiderRequest s SET s.status=:status WHERE s.riderId=:riderId")
    public void updateRiderRequestStatus(@Param("status") Integer status, @Param("riderId") Integer riderId);
}
