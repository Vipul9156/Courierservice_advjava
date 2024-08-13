package com.NinjaCourier.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.NinjaCourier.model.Customer;
import com.NinjaCourier.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/customer")
    public String createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return "Customer data is saved";
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        customerRepository.findAll().forEach(customerList::add);
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return new ResponseEntity<Customer>(customer.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/customer/{id}")
    public String updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        Optional<Customer> cust = customerRepository.findById(id);
        if (cust.isPresent()) {
            Customer customerDetails = cust.get();
            customerDetails.setName(customer.getName());
            customerDetails.setEmail(customer.getEmail());
            customerDetails.setUsername(customer.getUsername());
            customerDetails.setPassword(customer.getPassword());
            customerDetails.setPhoneNumber(customer.getPhoneNumber());
            customerDetails.setAddress(customer.getAddress());
            customerRepository.save(customerDetails);
            return "Customer data is updated for id: " + id;
        } else {
            return "Customer id is not found";
        }
    }

    @DeleteMapping("/customer")
    public String deleteAllCustomers() {
        customerRepository.deleteAll();
        return "All customers have been removed";
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomerById(@PathVariable int id) {
        customerRepository.deleteById(id);
        return "Customer with id= " + id + " is deleted";
    }

//    @GetMapping("/customer/username/{username}")
//    public ResponseEntity<Customer> getCustomerByUsername(@PathVariable String username) {
//        Optional<Customer> customer = customerRepository.findByUsername(username);
//        if (customer.isPresent()) {
//            return new ResponseEntity<Customer>(customer.get(), HttpStatus.FOUND);
//        } else {
//            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping("/customer/email/{email}")
//    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
//        Optional<Customer> customer = customerRepository.findByEmail(email);
//        if (customer.isPresent()) {
//            return new ResponseEntity<Customer>(customer.get(), HttpStatus.FOUND);
//        } else {
//            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PutMapping("/customer/username/{username}")
//    public String updateCustomerByUsername(@PathVariable String username, @RequestBody Customer customer) {
//        Optional<Customer> cust = customerRepository.findByUsername(username);
//        if (cust.isPresent()) {
//            Customer customerDetails = cust.get();
//            customerDetails.setName(customer.getName());
//            customerDetails.setEmail(customer.getEmail());
//            customerDetails.setUsername(customer.getUsername());
//            customerDetails.setPassword(customer.getPassword());
//            customerDetails.setPhoneNumber(customer.getPhoneNumber());
//            customerDetails.setAddress(customer.getAddress());
//            customerRepository.save(customerDetails);
//            return "Customer with username: " + username + " updated successfully";
//        } else {
//            return "Failed to update the customer";
//        }
//    }
}

