//package com.NinjaCourier.Controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.*;
//
//import com.NinjaCourier.model.Order;
//import com.NinjaCourier.repository.OrderRepository;
//
//@RestController
//@RequestMapping("/api")
//public class OrderController 
//{
//	OrderRepository or;
//	
//	@PostMapping("/order")
//	public String makeOrder(@RequestBody Order order) {
//		or.save(order);
//		return "Your order is successful";
//	}
//	
////	@GetMapping("/order")
////	public ResponseEntity<List<Order>> getAllOrders(){
////		List<Order> Orderlist = new ArrayList<>();
////		or.findAll().forEach(Orderlist::add)
////		return ResponseEntity<>(Orderlist);
////	}
//}
