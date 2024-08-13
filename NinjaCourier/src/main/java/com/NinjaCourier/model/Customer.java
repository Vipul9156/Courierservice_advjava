package com.NinjaCourier.model;

import jakarta.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    
    @NotBlank(message = "Name is mandatory")
    @JsonProperty("name")
    @Size(max = 25, message = "Name should be less than 25 characters")
    @Column(nullable = false)
    private String name;
    
    @NotBlank(message = "Phone Number is mandatory")
    @JsonProperty("phoneNumber")
    @Pattern(regexp = "^\\+\\d{2}\\d{10}$", message = "Phone number must start with country code and be followed by 10 digits")
    @Column(nullable = false)
    private String phoneNumber;
    
    @NotBlank(message = "Address is mandatory")
    @JsonProperty("address")
    @Size(max = 50, message = "Address should be less than 50 characters")
    @Column(nullable = false)
    private String address;
    
    @NotBlank(message = "Username is mandatory")
    @JsonProperty("username")
    @Size(max = 15, message = "Username should be less than 15 characters")
    @Column(nullable = false, unique = true)
    private String username;
    
    @NotBlank(message = "Password is mandatory")
    @JsonProperty("password")
    @Size(min = 8, max = 20, message = "Password should be between 8 and 20 characters")
    @Column(nullable = false)
    private String password;
    
    @NotBlank(message = "Email is mandatory")
    @JsonProperty("email")
    @Pattern(regexp = "^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,7}$", message = "Enter a valid email address")
    @Size(max = 30, message = "Email should be less than 30 characters")
    @Email(message = "Enter a valid email address")
    @Column(nullable = false, unique = true)
    private String email;
    
    @NotNull(message = "OTP is mandatory")
    @JsonProperty("otp")
    @Column(nullable = false)
    private int otp;

    public Customer() {}

    public Customer(int customerId, @NotBlank(message = "Name is mandatory") @Size(max = 255, message = "Name should be less than 255 characters") String name,
            @NotBlank(message = "Phone Number is mandatory") @Pattern(regexp = "^\\+\\d{2}\\d{10}$", message = "Phone number must start with country code and be followed by 10 digits") String phoneNumber,
            @NotBlank(message = "Address is mandatory") @Size(max = 500, message = "Address should be less than 500 characters") String address,
            @NotBlank(message = "Username is mandatory") @Size(max = 255, message = "Username should be less than 255 characters") String username,
            @NotBlank(message = "Password is mandatory") @Size(min = 8, max = 20, message = "Password should be between 8 and 20 characters") String password,
            @NotBlank(message = "Email is mandatory") @Size(max = 255, message = "Email should be less than 255 characters") @Email(message = "Enter a valid email address") String email,
            @NotNull(message = "OTP is mandatory") int otp) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.password = password;
        this.email = email;
        this.otp = otp;
    }

    // Getters and Setters

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + ", username=" + username + ", password=" + password + ", email=" + email + ", otp=" + otp + "]";
    }
}
