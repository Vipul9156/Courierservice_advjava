package com.NinjaCourier.model;

import jakarta.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

//CREATE TABLE agent (
//	    agentId INT AUTO_INCREMENT PRIMARY KEY,
//	    companyName VARCHAR(255) NOT NULL,
//	    agentName VARCHAR(255) NOT NULL,
//	    phoneNumber VARCHAR(15) NOT NULL,
//	    address VARCHAR(500) NOT NULL,
//	    username VARCHAR(255) NOT NULL UNIQUE,
//	    password VARCHAR(20) NOT NULL,
//	    email VARCHAR(255) NOT NULL UNIQUE,
//	    ratings VARCHAR(1) CHECK (ratings IN ('1', '2', '3', '4', '5')),
//	    otp INT NOT NULL
//	);


@Entity
@Table(name="agent")
public class Agent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int agentId;
	
	@NotBlank(message="CompanyName is mandatory")
	@JsonProperty("companyName")
	@Size(max=25,message="Company name should be less than 25 characters")
	@Column(nullable=false)
	private String companyName;
	
	@NotBlank(message="Agent Name is mandatory")
	@JsonProperty("agentName")
	@Size(max=25,message="Agent name should be less than 25 characters")
	@Column(nullable = false)
	private String agentName;
	
	@NotBlank(message = "Phone Number is mandatory")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    @Column(nullable = false)
    private String phoneNumber;
	
	@NotBlank(message="Address is mandatory")
	@JsonProperty("address")
	@Size(max=30,message="Address name should be less than 30 characters")
	@Column(nullable=false)
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
	
    @NotBlank(message="Email is mandatory")
    @JsonProperty("email")
    @Size(max=30,message="email should be less than 30 characters")
    @Email(message="Enter a valid email address")
    @Column(nullable=false)
    @Pattern(regexp = "^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,7}$", message = "Enter a valid email address")
	private String email;
	
	@JsonProperty("ratings")
	@Pattern(regexp="^[1-5]{1}$",message="Rating must be between 1 to 5")
    private String ratings;
	
	@JsonProperty("otp")
	@Column(nullable = false)
	private int otp;
	
	public Agent() {}

	public Agent(int agentId,
			@NotBlank(message = "CompanyName is mandatory") @Size(max = 25, message = "Company name should be less than 25 characters") String companyName,
			@NotBlank(message = "Agent Name is mandatory") @Size(max = 25, message = "Agent name should be less than 25 characters") String agentName,
			@NotBlank(message = "Phone Number is mandatory") @Pattern(regexp = "^//+[0-9]{2}[0-9]{10}", message = "Phone number must be 10 digits") String phoneNumber,
			@NotBlank(message = "Address is mandatory") @Size(max = 30, message = "Address name should be less than 30 characters") String address,
			@NotBlank(message = "Username is mandatory") @Size(max = 15, message = "Username should be less than 15 characters") String username,
			@NotBlank(message = "Password is mandatory") @Size(min = 8, max = 20, message = "Password should be between 8 and 20 characters") String password,
			@NotBlank(message = "Email is mandatory") @Size(max = 30, message = "email should be less than 30 characters") @Email(message = "Enter a valid email address") @Pattern(regexp = "^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,7}$", message = "Enter a valid email address") String email,
			@Pattern(regexp = "^[1-5]{1}$", message = "Rating must be between 1 to 5") String ratings, int otp) {
		super();
		this.agentId = agentId;
		this.companyName = companyName;
		this.agentName = agentName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.username = username;
		this.password = password;
		this.email = email;
		this.ratings = ratings;
		this.otp = otp;
	}

	
	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
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

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "Agent [agentId=" + agentId + ", companyName=" + companyName + ", agentName=" + agentName
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", username=" + username + ", password="
				+ password + ", email=" + email + ", ratings=" + ratings + ", otp=" + otp + "]";
	};
	
	
	
}
