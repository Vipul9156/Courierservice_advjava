package com.NinjaCourier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NinjaCourier.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
