package com.swiggy.service;

import java.util.List;

import com.swiggy.dto.FoodCart;
import com.swiggy.dto.Item;

public interface FoodCartService {
	FoodCart addCart(FoodCart cart);
	FoodCart addItemTocart(int foodCartId, int custId, int itemId);
	FoodCart increaseItemQuantity(int foodCartId,int foodItemId);
	FoodCart reduceItemQuantity(int foodCartId,int foodItemId);
	FoodCart removeItemFromCart(int foodCartId,int foodItemId);
	FoodCart clearCart(int foodCartId);
	FoodCart findCartById(int cartId);
	List<FoodCart> allCart();
}
