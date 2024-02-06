package com.swiggy.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swiggy.dto.Category;
import com.swiggy.dto.Item;
import com.swiggy.dto.Restaurant;
import com.swiggy.repository.CategoryRepository;
import com.swiggy.repository.ItemRepository;
import com.swiggy.repository.RestaurantRepository;

@Repository
public class ItemDaoImpl implements ItemDao{

	@Autowired
	ItemRepository itemRepo;
	@Autowired
	RestaurantRepository restaurantRepo;
	@Autowired
	CategoryRepository categoryRepo;
	
	@Override
	public Item addItem(Item item, int categoryId, int restaurantId) {
		Item i = itemRepo.findById(item.getItemId()).orElse(item);
		if(i != null) {
		Category category = categoryRepo.findById(categoryId).orElse(null);
		if(category != null) {
			i.setCategory(category);
		}
		
		Restaurant restaurant =  restaurantRepo.findById(restaurantId).orElse(null);
		//Item item = itemRepo.findById(itemId).orElse(null);
		if(restaurant != null) {
		List<Restaurant> restaurants = new ArrayList<>();
		restaurants.add(restaurant);
		i.setRestaurants(restaurants);
		}
		}
		
		return itemRepo.save(i);
		
		//return item;
	}

	@Override
	public Item updateItem(Item item) {
		return itemRepo.save(item);
	}

	@Override
	public Item removeItem(int itemId) {
		Item item = itemRepo.findById(itemId).orElse(null);
		if(item != null) {
			itemRepo.deleteById(itemId);
		}
		return item;
	}

	@Override
	public Item viewItemById(int itemId) {
		return itemRepo.findById(itemId).orElse(null);
	}

	@Override
	public List<Item> viewItemByRestaurant(String restauranatName) {
		Restaurant restaurant = restaurantRepo.searchRestaurantByName(restauranatName);
		List<Item> items = restaurant.getItemsList();
		return items;
	}

	@Override
	public List<Item> viewItemByName(String itemName) {
		return itemRepo.viewItemByName(itemName);
	}

	@Override
	public List<Item> allItems() {
		return itemRepo.findAll();
	}

	@Override
	public Item addRestaurants(int itemId, int restaurantId) {
		Restaurant restaurant =  restaurantRepo.findById(restaurantId).orElse(null);
		Item item = itemRepo.findById(itemId).orElse(null);
		List<Restaurant> restaurants = item.getRestaurants();
		restaurants.add(restaurant);
		item.setRestaurants(restaurants);
		if(item != null) {
			itemRepo.save(item);
		}
		return item;
	}

	@Override
	public Item addCategory(int itemId, int categoryId) {
		Item item = itemRepo.findById(itemId).orElse(null);
		if(item != null) {
			Category category = categoryRepo.findById(categoryId).orElse(null);
			if(category != null) {
				item.setCategory(category);
			}
			itemRepo.save(item);
		}
		return item;
	}
	
	
	

}
