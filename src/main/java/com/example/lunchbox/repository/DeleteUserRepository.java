package com.example.lunchbox.repository;

import com.example.lunchbox.model.entity.DeleteUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeleteUserRepository extends JpaRepository<DeleteUsers,Integer> {
}
