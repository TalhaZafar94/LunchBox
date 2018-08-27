package com.example.lunchbox.service.Impl;

import com.example.lunchbox.model.entity.Admin;
import com.example.lunchbox.model.entity.DeleteUsers;
import com.example.lunchbox.repository.AddressRepository;
import com.example.lunchbox.repository.AdminRepository;
import com.example.lunchbox.repository.DeleteUserRepository;
import com.example.lunchbox.service.AdminService;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;
    private DeleteUserRepository deleteUserRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, EntityManager entityManager, DeleteUserRepository deleteUserRepository) {
        this.adminRepository = adminRepository;
        this.entityManager = entityManager;
        this.deleteUserRepository = deleteUserRepository;
    }

    @Override
    public void adminSignup(Admin admin) {

        if (admin.getAdminPassword() != null) {
            try {
                admin.setAdminPassword(getSHA256(admin.getAdminPassword()));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            adminRepository.saveAndFlush(admin);
        }
    }



/*
    @Override
    public void adminSignup(Admin admin) {
        if (admin.getAdminPassword() != null)
        {
            adminRepository.saveAndFlush(admin);
        }
    }
*/

    public byte[] readImageOldWay(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        // Get the size of the file
        long length = file.length();
        // You cannot create an array using a long type.
        // It needs to be an int type.
        // Before converting to an int type, check
        // to ensure that file is not larger than Integer.MAX_VALUE.
        if (length > Integer.MAX_VALUE) {
            // File is too large
            throw new IOException("Could not completely read file " + file.getName());
        }
        // Create the byte array to hold the data
        byte[] bytes = new byte[(int) length];
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }
        // Close the input stream and return bytes
        is.close();
        return bytes;
    }

    @Override
    public void updateAdmin(Admin admin) {
        Admin admin1 = entityManager.find(admin.getClass(), admin);
        entityManager.merge(admin1);
    }

    @Override
    public Admin getAdminById(Integer id) {
        return adminRepository.findOne(id);
    }

    @Override
    public long countAllAdmins() {
        return adminRepository.count();
    }

    @Override
    public void deleteAdmin(String adminEmail) {
        Admin admin = this.findByAdminEmail(adminEmail);
        adminRepository.delete(admin.getAdminId());
    }

    @Override
    public List<Admin> getAdminByname(String adminName) {
        return adminRepository.findAdminByAdminNameContaining(adminName);
    }

    @Override
    public List<Admin> findAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public Admin findByAdminEmail(String adminEmail) {
        return adminRepository.findByAdminEmail(adminEmail);
    }

    @Override
    public Admin login(String adminEmail, String adminPassword) {
        Admin admin = this.findByAdminEmail(adminEmail);
        try {
            if (admin != null && getSHA256(adminPassword).equals(admin.getAdminPassword())) {
                return admin;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updatePassword(String oldpassword, String newpassword, String adminEmail) {
        Admin admin = this.findByAdminEmail(adminEmail);
        try {
            if (admin != null && getSHA256(oldpassword).equals(admin.getAdminPassword())) {
                admin.setAdminPassword(getSHA256(newpassword));
                adminRepository.saveAndFlush(admin);
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getSHA256(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");

        messageDigest.update(password.getBytes());
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((int) (b & 0xff)));
        }
        return sb.toString();
    }

    @Override
    public Admin getAdminByAdminLastUpdated(Date date) {
        return adminRepository.getAdminByAdminLastUpdated(date);
    }

    @Override
    public Admin getAdminByAdminCreatedAt(Date date) {
        return adminRepository.getAdminByAdminCreatedAt(date);
    }

    @Override
    public void deleteAdminById(Integer adminId) {
        Admin admin = adminRepository.findOne(adminId);
        DeleteUsers deleteUser = new DeleteUsers(admin.getAdminName(), admin.getAdminEmail(), admin.getAdminNic(), admin.getAdminAccessType(),
                admin.getAdminPassword(), admin.getAdminAddressId().getAddressId(), admin.getAdminImage(), admin.getAdminPhoneNumber());

        deleteUserRepository.save(deleteUser);
        adminRepository.delete(adminId);
    }

}