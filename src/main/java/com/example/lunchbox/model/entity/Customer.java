package com.example.lunchbox.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "customers", indexes = {@Index(name = "EMAIL_INDEX", columnList = "customer_email,customer_nic")})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_nic", unique = true)
    private String customerNic;

    @Column(name = "customer_email", unique = true)
    private String customerEmail;

    @Column(name = "customer_accesstype")
    private Integer customerAccessType;

    @Column(name = "customer_password")
    private String customerPassword;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private Address customerAddressId;

    @Column(name = "customer_imagepath")
    private String customerImagePath;

    @Column(name = "customer_phonenumber")
    private String customerPhoneNumber;

    @Column(name = "customer_createdat", columnDefinition = "DATETIME")
    private Date customerCreatedAt;

    @Column(name = "customer_lastupdated", columnDefinition = "DATETIME")
    private Date customerLastUpdated;

    @Column(name = "location_id", unique = true)
    private Integer customerLocationId;

    @Column(name = "customer_reg_token")
    private String customerRegToken;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Order order;

    public Customer() {
    }

    public Customer(Integer customerId, String customerName, String customerNic, String customerEmail, Integer customerAccessType, String customerPassword, Address customerAddressId, String customerImagePath, String customerPhoneNumber, Date customerCreatedAt, Date customerLastUpdated, Integer customerLocationId, String customerRegToken) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerNic = customerNic;
        this.customerEmail = customerEmail;
        this.customerAccessType = customerAccessType;
        this.customerPassword = customerPassword;
        this.customerAddressId = customerAddressId;
        this.customerImagePath = customerImagePath;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerCreatedAt = customerCreatedAt;
        this.customerLastUpdated = customerLastUpdated;
        this.customerLocationId = customerLocationId;
        this.customerRegToken = customerRegToken;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNic() {
        return customerNic;
    }

    public void setCustomerNic(String customerNic) {
        this.customerNic = customerNic;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Integer getCustomerAccessType() {
        return customerAccessType;
    }

    public void setCustomerAccessType(Integer customerAccessType) {
        this.customerAccessType = customerAccessType;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Address getCustomerAddressId() {
        return customerAddressId;
    }

    public void setCustomerAddressId(Address customerAddressId) {
        this.customerAddressId = customerAddressId;
    }

    public String getCustomerImagePath() {
        return customerImagePath;
    }

    public void setCustomerImagePath(String customerImagePath) {
        this.customerImagePath = customerImagePath;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerCreatedAt() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(customerCreatedAt);
    }

    public void setCustomerCreatedAt(Date customerCreatedAt) {
        this.customerCreatedAt = customerCreatedAt;
    }

    public String getCustomerLastUpdated() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(customerLastUpdated);
    }

    public void setCustomerLastUpdated(Date customerLastUpdated) {
        this.customerLastUpdated = customerLastUpdated;
    }

    public Integer getCustomerLocationId() {
        return customerLocationId;
    }

    public void setCustomerLocationId(Integer customerLocationId) {
        this.customerLocationId = customerLocationId;
    }

    public String getCustomerRegToken() {
        return customerRegToken;
    }

    public void setCustomerRegToken(String customerRegToken) {
        this.customerRegToken = customerRegToken;
    }
}
