package com.swiggy.dao;

import java.util.List;


import com.swiggy.dto.Item;

public interface ItemDao {
	Item addItem(Item item,int categoryId, int restaurantId);
	Item updateItem(Item item);
	Item removeItem(int categoryId);
	Item addRestaurants(int itemId, int restaurantId);
	Item addCategory(int itemId, int categoryId);
	Item viewItemById(int itemId);
	List<Item> viewItemByRestaurant(String restauranatName);
	List<Item> viewItemByName(String itemName);
	List<Item> allItems();
}
