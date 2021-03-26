package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ProductRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
	
	@Autowired
	public OrderRepository orderRepository;
	
	@GetMapping(value = "/orders")
	public List<Order> getAllOrder(){
		return orderRepository.findAll();
	}
	@PostMapping(value = "/order/create")
	public String createOrder(@RequestBody Order order) {
		Order insertedOrder = orderRepository.insert(order);
		System.out.print(insertedOrder.getUserId());
		return "OK";
	}
	@PutMapping(value = "/order/update")
	public String updateOrder(@RequestBody Order order) {
		Order updatedOrder = orderRepository.save(order);
		return "OK";
	}
	@GetMapping(value = "/order/{id}")
	public Optional<Order> detail_order(@PathVariable("id") String id) {
		return orderRepository.findById(id);
	}
	
	@DeleteMapping(value = "/order/delete/{id}")
	public void deleteOrder(@PathVariable("id") String id) {
		orderRepository.deleteById(id);
		
	}
	
	@GetMapping(value = "/order/of/{userId}")
	public List<Order> getMyOrders(@PathVariable("userId") String userId) {
		List<Order> orders = orderRepository.findAll();
		List<Order> myOrders = new ArrayList<Order>();
		for(int i=0; i<orders.size(); i++)
			if(orders.get(i).getUserId().equals(userId)) {
				myOrders.add(orders.get(i));
			}
		return myOrders;
	}
}
