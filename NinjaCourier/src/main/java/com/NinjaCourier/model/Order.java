//package com.NinjaCourier.model;
//
//import jakarta.persistence.Entity;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;
//
//import java.sql.Date;
//
//import com.fasterxml.jackson.annotation.*;
//
//import jakarta.persistence.*;
//
////CREATE TABLE `Order` (
////	    `Id` INT AUTO_INCREMENT PRIMARY KEY,
////	    `Name` VARCHAR(255) NOT NULL,
////	    `PhoneNumber` VARCHAR(15) NOT NULL,
////	    `Email` VARCHAR(255) NOT NULL,
////	    `Pickup` VARCHAR(255) NOT NULL,
////	    `Destination` VARCHAR(255) NOT NULL,
////	    `ODate` DATE NOT NULL,
////	    `DDate` DATE NOT NULL,
////	    `TrackingID` VARCHAR(255) NOT NULL,
////	    `CustomerId` INT NOT NULL,
////	    `AgentId` INT NOT NULL,
////	    FOREIGN KEY (`CustomerId`) REFERENCES `Customer`(`CustomerId`),
////	    FOREIGN KEY (`AgentId`) REFERENCES `Agent`(`AgentId`)
////	);
//
//@Entity
//@Table(name="order")
//public class Order {
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int id;
//	
//	@NotBlank(message="Name is mandatory")
//	@JsonProperty("name")
//	@Size(max=25,message="Name should be less than 25 characters")
//	@Column(nullable = false)
//	private String name;
//	
//	@NotBlank(message="Phone Number is mandatory")
//	@JsonProperty("phoneNumber")
//    @Pattern(regexp = "^\\+\\d{2}\\d{10}$", message = "Phone number must start with country code and be followed by 10 digits")
//	@Column(nullable = false)
//	private String phoneNumber;
//	
//	@NotBlank(message="Email is mandatory")
//	@JsonProperty("email")
//	@Email(message="Enter a valid email address")
//    @Pattern(regexp = "^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,7}$", message = "Enter a valid email address")
//	@Size(max=30,message="Email should be less than 30 characters")
//	@Column(nullable = false)
//	private String email;
//	
//	@NotBlank(message="Enter a pickup location")
//	@JsonProperty("pickup")
//	@Size(max=30,message="Pickup Location must be less than 30 characters")
//	@Column(nullable = false)
//	private String pickup;
//	
//	@NotBlank(message="Enter the delivery location")
//	@JsonProperty("destination")
//	@Size(max=30,message="Delivery location must be less than 30 characters")
//	@Column(nullable = false)
//	private String destination;
//
//	@NotBlank(message="Menation a Order Date")
//	@JsonProperty("odate")
//	@Column(nullable = false)
//	private Date odate;
//	
//	@NotBlank(message="Mention o order destination")
//	@JsonProperty("ddate")
//	@Column(nullable=false)
//	private Date ddate;
//	
//	@NotBlank(message="Tracking ID is mandatory")
//	@JsonProperty("trackingId")
//	@Size(max=10,message="Tracking is must be 10 digits")
//	@Column(nullable=false)
//	private String trackingId;
//	
//	@ManyToOne
//    @JoinColumn(name = "customerId", nullable = false)
//    private Customer customer;
//
//    @ManyToOne
//    @JoinColumn(name = "agentId", nullable = false)
//    private Agent agent;
//
//	
//}
