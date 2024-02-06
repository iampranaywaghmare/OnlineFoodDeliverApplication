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

import com.swiggy.dto.Item;
import com.swiggy.service.ItemServiceImpl;

@RestController
@RequestMapping("/item")
@CrossOrigin("http://localhost:3000")
public class ItemController {
	
	@Autowired
	ItemServiceImpl itemService;
	
	@PostMapping("/add/{categoryId}/{restaurantId}")
	Item addItem(@RequestBody Item item,@PathVariable("categoryId") int categoryId,@PathVariable("restaurantId") int restaurantId) {
		return itemService.addItem(item,categoryId,restaurantId);
	}
	
	//Item updateItem(Item item);
	
	@PutMapping("/addRestaurant/{itemId}/{restaurantId}")
	Item addRestaurants(@PathVariable("itemId") int itemId,@PathVariable("restaurantId") int restaurantId) {
		return itemService.addRestaurants(itemId, restaurantId);
	}
	
	@PutMapping("/addCategory/{itemId}/{categoryId}")
	Item addCategory(@PathVariable("itemId") int itemId,@PathVariable("categoryId") int categoryId) {
		return itemService.addCategory(itemId, categoryId);
	}
	
	@DeleteMapping("/delete/{categoryId}")
	Item removeItem(@PathVariable("categoryId") int categoryId) {
		return itemService.removeItem(categoryId);
	}
	
	@GetMapping("/findById/{itemId}")
	Item viewItemById(@PathVariable("itemId") int itemId) {
		return itemService.viewItemById(itemId);
	}
	
	@GetMapping("/findByRestaurant/{restauranatName}")
	List<Item> viewItemByRestaurant(@PathVariable("restauranatName") String restauranatName){
		return itemService.viewItemByRestaurant(restauranatName);
	}
	
	@GetMapping("/findBYName/{itemName}")
	List<Item> viewItemByName(@PathVariable("itemName") String itemName){
		return itemService.viewItemByRestaurant(itemName);
	}
	
	@GetMapping("/all")
	List<Item> allItems(){
		return itemService.allItems();
	}


}
