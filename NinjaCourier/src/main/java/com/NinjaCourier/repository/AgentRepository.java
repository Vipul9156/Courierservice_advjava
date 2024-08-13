package com.NinjaCourier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NinjaCourier.model.Agent;

public interface AgentRepository extends JpaRepository<Agent,Integer> 
{

}
