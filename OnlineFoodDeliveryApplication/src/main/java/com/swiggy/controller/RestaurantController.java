package com.swiggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.dto.Restaurant;
import com.swiggy.service.RestaurantServiceImpl;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/restaurant")

public class RestaurantController {

	@Autowired
	RestaurantServiceImpl restaurantService;
	
	@PostMapping("/add")
	Restaurant addRestaurant(@RequestBody Restaurant restuatant) {
		return restaurantService.addRestaurant(restuatant);
	}
	@PutMapping("/update")
	Restaurant updateRestaurant(@RequestBody Restaurant restuatant) {
		return restaurantService.updateRestaurant(restuatant);
	}
	
	@DeleteMapping("/delete/{restuatantId}")
	Restaurant removeRestaurant(@PathVariable("restuatantId") int restuatantId) {
		return restaurantService.removeRestaurant(restuatantId);
	}
	
	@GetMapping("/findByCity/{location}")
	List<Restaurant> searchNearByRestaurant(@PathVariable("location") String location){
		return restaurantService.searchNearByRestaurant(location);
	}
	
	@GetMapping("/findByRestaurant/{restaurant}")
	List<Restaurant> searchRestaurantByItemName(@PathVariable("restaurant") String restaurant){
		return restaurantService.searchRestaurantByItemName(restaurant);
	}
	
	@GetMapping("/all")
	List<Restaurant> allRestaurant(){
		return restaurantService.allRestaurant();
	}
	
}
