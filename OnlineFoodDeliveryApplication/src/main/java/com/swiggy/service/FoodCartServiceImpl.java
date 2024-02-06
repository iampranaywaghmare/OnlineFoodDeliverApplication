package com.swiggy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiggy.dao.FoodCartDaoImpl;
import com.swiggy.dto.FoodCart;
import com.swiggy.dto.Item;

@Service
public class FoodCartServiceImpl implements FoodCartService{

	@Autowired
	FoodCartDaoImpl foodCartDaoImpl;
	
	@Override
	public FoodCart addCart(FoodCart cart) {
		return foodCartDaoImpl.addCart(cart);
	}
	
	@Override
	public FoodCart addItemTocart(int foodCartId, int custId, int itemId) {
		return foodCartDaoImpl.addItemTocart(foodCartId,custId, itemId);
	}

	@Override
	public FoodCart increaseItemQuantity(int foodCartId, int foodItemId) {
		return foodCartDaoImpl.increaseItemQuantity(foodCartId, foodItemId);
	}

	@Override
	public FoodCart reduceItemQuantity(int foodCartId, int foodItemId) {
		return foodCartDaoImpl.reduceItemQuantity(foodCartId, foodItemId);
	}

	@Override
	public FoodCart removeItemFromCart(int foodCartId, int foodItemId) {
		return foodCartDaoImpl.removeItemFromCart(foodCartId, foodItemId);
	}

	@Override
	public FoodCart clearCart(int foodCartId) {
		return foodCartDaoImpl.clearCart(foodCartId);
	}

	@Override
	public FoodCart findCartById(int cartId) {
		return foodCartDaoImpl.findCartById(cartId);
	}

	@Override
	public List<FoodCart> allCart() {
		return foodCartDaoImpl.allCart();
	}

	

}
