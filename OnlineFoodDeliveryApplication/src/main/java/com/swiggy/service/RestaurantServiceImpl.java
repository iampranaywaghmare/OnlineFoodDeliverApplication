package com.swiggy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiggy.dao.RestaurantDaoImpl;
import com.swiggy.dto.Restaurant;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	RestaurantDaoImpl restaurantDoa;
	
	@Override
	public Restaurant addRestaurant(Restaurant restuatant) {
		return restaurantDoa.addRestaurant(restuatant);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restuatant) {
		return restaurantDoa.updateRestaurant(restuatant);
	}

	@Override
	public Restaurant removeRestaurant(int restuatantId) {
		return restaurantDoa.removeRestaurant(restuatantId);
	}

	@Override
	public List<Restaurant> searchNearByRestaurant(String location) {
		return restaurantDoa.searchNearByRestaurant(location);
	}

	@Override
	public List<Restaurant> searchRestaurantByItemName(String itemName) {
		return restaurantDoa.searchRestaurantByItemName(itemName);
	}

	@Override
	public List<Restaurant> allRestaurant() {
		return restaurantDoa.allRestaurant();
	}

}
