package com.swiggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.dto.OrderDetails;
import com.swiggy.repository.FoodCartRepository;
import com.swiggy.service.OrderServiceImpl;


@RestController
@RequestMapping("/order")
public class OrderDetailsController {
	
	@Autowired
	OrderServiceImpl orderService;
	
	@Autowired
	FoodCartRepository foodCart;
	
	@PostMapping("/add/{cartId}")
	OrderDetails addOrder(@RequestBody OrderDetails order,@PathVariable("cartId") int cartId) {
		return orderService.addOrder(order, cartId);
		
	}
	
	@PutMapping("/update")
	OrderDetails updateOrder(@RequestBody OrderDetails order) {
		return orderService.updateOrder(order);
	}
	
	@DeleteMapping("/delete/{orderId}")
	OrderDetails removeOrder(@PathVariable("orderId") int orderId) {
		return orderService.removeOrder(orderId);
	}
	
	@GetMapping("/find/{orderId}")
	OrderDetails viewOrder(@PathVariable("orderId") int orderId) {
		return orderService.viewOrder(orderId);
	}
	//List<OrderDetails> viewOrdersByRestaurantName(String restaurantName);
	
	@GetMapping("/findByCustomer/{customerId}")
	List<OrderDetails> viewOrdersByCustomer(@PathVariable("customerId") int customerId){
		return orderService.viewOrdersByCustomer(customerId);
	}
}
