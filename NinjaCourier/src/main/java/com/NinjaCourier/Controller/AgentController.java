package com.NinjaCourier.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.NinjaCourier.model.Agent;
import com.NinjaCourier.repository.AgentRepository;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AgentController {

	@Autowired
	AgentRepository ar;
	
	@PostMapping("/agent")
	public String createAgent(@RequestBody Agent agent){
		ar.save(agent);
		return "Agent data is saved";
	}
	
	@GetMapping("/agent")
	public ResponseEntity<List<Agent>> getAllAgents(){
		List<Agent> list = new ArrayList<>();
		ar.findAll().forEach(list::add);
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/agent/{id}")
	public ResponseEntity<Agent> getById(@PathVariable int id){
		Optional<Agent> agent = ar.findById(id);
		if(agent.isPresent()) {
			return new ResponseEntity<Agent>(agent.get(),HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Agent>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/agent/{id}")
	public String updateAgent(@PathVariable int id,@RequestBody Agent agent) {
		Optional<Agent> agentinfo = ar.findById(id);
		if(agentinfo.isPresent()) {
			Agent age = agentinfo.get();
			age.setCompanyName(agent.getCompanyName());
			age.setAgentName(agent.getAgentName());
			age.setPhoneNumber(agent.getPhoneNumber());
			age.setAddress(agent.getAddress());
			age.setUsername(agent.getUsername());
			age.setPassword(agent.getPassword());
			age.setEmail(agent.getEmail());
			age.setRatings(agent.getRatings());
			age.setOtp(agent.getOtp());
			ar.save(age);
			return "Agent data is updated for id: "+id;
		}
		else
		{
			return "Agent id is not found";
		}
	}
	
	@DeleteMapping("/agent")
	public String deleteAll() {
		ar.deleteAll();
		return "All agents has been removed";
	}
	
	@DeleteMapping("/agent/{id}")
	public String deleteById(@PathVariable int id) {
			ar.deleteById(id);
			return "Agent is deleted with id: "+id;
	}
}
