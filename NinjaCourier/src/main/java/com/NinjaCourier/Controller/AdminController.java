package com.NinjaCourier.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NinjaCourier.model.Admin;
import com.NinjaCourier.repository.AdminRepository;
import com.mysql.cj.protocol.x.Ok;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired
	AdminRepository adminrepository;
	
	@PostMapping("/admin")
	public String createAdmin(@RequestBody Admin admin)
	{
		adminrepository.save(admin);
		return "Admin data is saved";
	}
	
	
	@GetMapping("/admin")
	public ResponseEntity<List<Admin>> getAll(){
		List<Admin> adminList = new ArrayList<>();
		adminrepository.findAll().forEach(adminList::add);
		return ResponseEntity.ok(adminList);
	}
	
	@GetMapping("/admin/{id}")
	public ResponseEntity<Admin> getById(@PathVariable int id){
		Optional<Admin> admin = adminrepository.findById(id);
		if(admin.isPresent()) {
			return new ResponseEntity<Admin>(admin.get(), HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/admin/{id}")
	public String update(@PathVariable int id,@RequestBody Admin admin) {
		Optional<Admin> adm = adminrepository.findById(id);
		if(adm.isPresent()) {
			Admin admindetails = adm.get();
			admindetails.setName(admin.getName());
			admindetails.setPassword(admin.getPassword());
			admindetails.setEmail(admin.getEmail());
			admindetails.setUsername(admin.getUsername());
			adminrepository.save(admindetails);
			return "Data is updated for "+id;
		}
		else {
			return "there exist some problem";
		}
	}
	
	@DeleteMapping("/admin")
	public String deleteAll() {
		adminrepository.deleteAll();
		return "Admin deleted succesfully";
	}
	
	@DeleteMapping("/admin/{id}")
	public String deleteById(@PathVariable int id) {
		adminrepository.deleteById(id);
		return "Admin with id= "+id+"is deleted";
	}
	
	@GetMapping("admin/username/{username}")
	public ResponseEntity<Admin> getByUsername(@PathVariable String username){
		Optional<Admin> admin = adminrepository.findByUsername(username);
		if(admin.isPresent()) {
			Admin adm = admin.get();
			return new ResponseEntity<Admin>(adm,HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/admin/email/{email}")
	public ResponseEntity<Admin> getByEmail(@PathVariable String email){
		Optional<Admin> adm = adminrepository.findByEmail(email);
		if(adm.isPresent()){
			Admin admindetails = adm.get();
			return new ResponseEntity<Admin>(admindetails,HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("admin/username/{username}")
	public String updateByUsername(@PathVariable String username,@RequestBody Admin admin) {
		Optional<Admin> adm = adminrepository.findByUsername(username);
		if(adm.isPresent()) {
			Admin admindetails = adm.get();
			admindetails.setName(admin.getName());
			admindetails.setPassword(admin.getPassword());
			admindetails.setEmail(admin.getEmail());
			admindetails.setUsername(admin.getUsername());
			return "User with username: "+username+"updated successfully";
		}
		else {
			return "Failed to update the user";
		}
	}
}
