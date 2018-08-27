package com.example.lunchbox.service;

import com.example.lunchbox.model.entity.Admin;
import org.springframework.web.multipart.MultipartFile;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

public interface AdminService {

    void adminSignup(Admin admin);

    Admin getAdminById(Integer id);

    long countAllAdmins();

    void deleteAdmin(String adminEmail);

    List<Admin> getAdminByname(String adminName);

    List<Admin> findAllAdmin();

    Admin login(String adminEmail, String adminPassword);

    Admin findByAdminEmail(String adminEmail);

    boolean updatePassword(String oldpassword, String newpassword, String adminEmail);

    String getSHA256(String password) throws NoSuchAlgorithmException;

    Admin getAdminByAdminLastUpdated(Date date);

    Admin getAdminByAdminCreatedAt(Date date);

    void deleteAdminById(Integer adminId);

    void updateAdmin(Admin admin);


}
