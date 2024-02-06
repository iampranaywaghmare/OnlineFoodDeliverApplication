package com.swiggy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiggy.dao.ItemDaoImpl;
import com.swiggy.dto.Item;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemDaoImpl itemDao;
	
	@Override
	public Item addItem(Item item,int categoryId, int restaurantId) {
		return itemDao.addItem(item,categoryId,restaurantId);
	}

	@Override
	public Item updateItem(Item item) {
		return itemDao.updateItem(item);
	}

	@Override
	public Item removeItem(int categoryId) {
		return itemDao.removeItem(categoryId);
	}

	@Override
	public Item viewItemById(int itemId) {
		return itemDao.viewItemById(itemId);
	}

	@Override
	public List<Item> viewItemByRestaurant(String restauranatName) {
		return itemDao.viewItemByRestaurant(restauranatName);
	}

	@Override
	public List<Item> viewItemByName(String itemName) {
		return itemDao.viewItemByName(itemName);
	}

	@Override
	public List<Item> allItems() {
		return itemDao.allItems();
	}

	@Override
	public Item addRestaurants(int itemId, int restaurantId) {
		return itemDao.addRestaurants(itemId, restaurantId);
	}

	@Override
	public Item addCategory(int itemId, int categoryId) {
		return itemDao.addCategory(itemId, categoryId);
	}

	

}
