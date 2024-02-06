package com.swiggy.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swiggy.dto.Item;
import com.swiggy.dto.Restaurant;
import com.swiggy.repository.RestaurantRepository;

@Repository
public class RestaurantDaoImpl implements RestaurantDao{
	
	@Autowired
	RestaurantRepository restaurantRepo;

	@Override
	public Restaurant addRestaurant(Restaurant restuatant) {
		return restaurantRepo.save(restuatant);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restuatant) {
		return restaurantRepo.save(restuatant);
	}

	@Override
	public Restaurant removeRestaurant(int restuatantId) {
		Restaurant restaurant = restaurantRepo.findById(restuatantId).orElse(null);
		if(restaurant != null) {
			restaurantRepo.delete(restaurant);
			//restaurantRepo.deleteById(restuatantId);
		}
		return restaurant;
	}

	@Override
	public List<Restaurant> searchNearByRestaurant(String location) {
		return restaurantRepo.searchNearByRestaurant(location);
	}

	@Override
	public List<Restaurant> searchRestaurantByItemName(String itemName) {
		List<Restaurant> restaurants = restaurantRepo.findAll();
		Iterator<Restaurant> itr = restaurants.iterator();
		while(itr.hasNext()) {
			List<Item> items = new ArrayList<>();
			Restaurant res = itr.next();
			items.addAll(res.getItemsList());
			for(int i =0 ; i< items.size()-1; i++) {
				boolean flag = false;
				Item item = items.get(i);
				if(item.getItemName().equals(itemName)) {
					flag = true;
				}
				if(flag==true) {
					restaurants.remove(res);
				}
			}
		}
		
		
		return restaurants;
	}

	@Override
	public List<Restaurant> allRestaurant() {
		return restaurantRepo.findAll();
	}

}
