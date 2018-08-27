package com.example.lunchbox.repository;

import com.example.lunchbox.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByAdminEmail(String adminEmail);

    List<Admin> findByAdminName(String adminName);

    List<Admin> findAdminByAdminNameContaining(String adminName);

    Admin getAdminByAdminLastUpdated(Date date);

    Admin getAdminByAdminCreatedAt(Date date);

}
