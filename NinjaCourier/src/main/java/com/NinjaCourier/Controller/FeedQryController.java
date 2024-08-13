package com.NinjaCourier.Controller;

import java.util.ArrayList;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NinjaCourier.model.FeedQry;
import com.NinjaCourier.repository.FeedQryRepository;

@RestController
@RequestMapping("/api")
public class FeedQryController 
{
	
	@Autowired
	FeedQryRepository fqr;
	
	@PostMapping("/feedqry")
	public String createFeedback(@RequestBody FeedQry feed)
	{
		fqr.save(feed);
		return "Feedback is saved";
	}
	
	@GetMapping("/feedqry")
	public ResponseEntity<List<FeedQry>> getAllFeedback(){
		List<FeedQry> feedlist = new ArrayList<>();
		fqr.findAll().forEach(feedlist::add);
		return ResponseEntity.ok(feedlist);
	}
	
	@GetMapping("/feedqry/{id}")
	public ResponseEntity<FeedQry> getById(@PathVariable int id){
		Optional<FeedQry> feedback = fqr.findById(id);
		if(feedback.isPresent()) {
			FeedQry feed = feedback.get();
			return new ResponseEntity<>(feed,HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/feedqry/{id}")
	public String updateById(@PathVariable int id,@RequestBody FeedQry feed)
	{
		Optional<FeedQry> feedqry = fqr.findById(id);
		if(feedqry.isPresent()) {
			FeedQry fq = feedqry.get();
			fq.setCategory(feed.getCategory());
			fq.setDate(feed.getDate());
			fq.setEmail(feed.getEmail());
			fq.setQuery(feed.getQuery());
			fq.setRatings(feed.getRatings());
			fq.setUsername(feed.getUsername());
			fqr.save(fq);
			return "Feedback has been updated for "+id;
		}
		else {
			return "No id found";
		}
	}
	
	@DeleteMapping("/feedqry/{id}")
	public String deleteById(@PathVariable int id) {
		fqr.deleteById(id);
		return "Feed has been deleted for id: "+id;
	}
	
	@DeleteMapping("/feedqry")
	public String deleteAll() {
		fqr.deleteAll();
		return "All feedbacks has been removed";
	}
	
}
