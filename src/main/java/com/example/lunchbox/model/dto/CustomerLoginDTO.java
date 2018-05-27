package com.example.lunchbox.model.dto;

public class CustomerLoginDTO {

    private String customerEmail;
    private String customerPassword;
    private Integer customerAccessType;

    public CustomerLoginDTO(String customerEmail, String customerPassword , Integer customerAccessType) {
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerAccessType = customerAccessType;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }


    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Integer getCustomerAccessType() {
        return customerAccessType;
    }

    public void setCustomerAccessType(Integer customerAccessType) {
        this.customerAccessType = customerAccessType;
    }
}
