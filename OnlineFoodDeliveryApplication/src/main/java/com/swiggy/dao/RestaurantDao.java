package com.swiggy.dao;

import java.util.List;


import com.swiggy.dto.Restaurant;

public interface RestaurantDao {
	Restaurant addRestaurant(Restaurant restuatant);
	Restaurant updateRestaurant(Restaurant restuatant);
	Restaurant removeRestaurant(int restuatantId);
	List<Restaurant> searchNearByRestaurant(String location);
	List<Restaurant> searchRestaurantByItemName(String itemName);
	List<Restaurant> allRestaurant();
}
