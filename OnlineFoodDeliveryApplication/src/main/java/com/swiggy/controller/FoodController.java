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

import com.swiggy.dto.FoodCart;
import com.swiggy.service.FoodCartServiceImpl;


@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	FoodCartServiceImpl foodService;
	
	
	
	@PostMapping("/addCart")
	FoodCart addCart(@RequestBody FoodCart cart) {
		return foodService.addCart(cart);
	}
	
	@PostMapping("/addItem/{foodCartId}/{custId}/{itemId}")
	public FoodCart addItemTocart(@PathVariable("foodCartId") int foodCartId,@PathVariable("custId") int custId,@PathVariable("itemId") int itemId) {
		return foodService.addItemTocart(foodCartId, custId,itemId);
	}
	
	@PutMapping("/increaseItemQuantity/{foodCartId}/{foodItemId}")
	FoodCart increaseItemQuantity(@PathVariable("foodCartId") int foodCartId,@PathVariable("foodItemId") int foodItemId) {
		return foodService.increaseItemQuantity(foodCartId, foodItemId);
	}
	
	@PutMapping("/reduceQuantity/{foodCartId}/{foodItemId}")
	FoodCart reduceItemQuantity(@PathVariable("foodCartId") int foodCartId,@PathVariable("foodItemId") int foodItemId) {
		return foodService.reduceItemQuantity(foodCartId, foodItemId);
	}
	
	@PutMapping("/deleteItem/{foodCartId}/{foodItemId}")
	FoodCart removeItemFromCart(@PathVariable("foodCartId") int foodCartId,@PathVariable("foodItemId") int foodItemId) {
		return foodService.removeItemFromCart(foodCartId, foodItemId);
	}
	
	@DeleteMapping("/deleteCart/{foodCartId}")
	FoodCart clearCart(@PathVariable("foodCartId") int foodCartId) {
		return foodService.clearCart(foodCartId);
	}
	@GetMapping("/cartbyId/{cartId}")
	FoodCart findCartById(@PathVariable("cartId") int cartId) {
		return foodService.findCartById(cartId);
	}
	@GetMapping("/all")
	List<FoodCart> allCart(){
		return foodService.allCart();
	}
}
