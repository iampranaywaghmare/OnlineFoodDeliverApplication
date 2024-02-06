 package com.swiggy.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swiggy.dto.Customer;
import com.swiggy.dto.FoodCart;
import com.swiggy.dto.Item;
import com.swiggy.repository.CustomerRepository;
import com.swiggy.repository.FoodCartRepository;
import com.swiggy.repository.ItemRepository;

@Repository
public class FoodCartDaoImpl implements FoodCartDao{

	@Autowired
	FoodCartRepository foodCartRepo;
	@Autowired
	CustomerRepository custRepo;
	@Autowired 
	ItemRepository itemRepo;
	
	@Override
	public FoodCart addCart(FoodCart cart) {
		return foodCartRepo.save(cart);
	}
	
	@Override
	
	public FoodCart addItemTocart(int foodCartId, int custId, int itemId) {
		FoodCart cart = foodCartRepo.findById(foodCartId).orElse(null);
		if(cart != null) {
		Customer cust = custRepo.findById(custId).orElse(null);
		
		cart.setCutomer(cust);
		Item item = itemRepo.findById(itemId).orElse(null);
		if(item!=null) {
		List<Item> items = new ArrayList<>();
		
		items.add(item);
		cart.setItemsList(items);
		}
		
		foodCartRepo.save(cart);
		}
		
		return cart;
		
		//FoodCart foodCart = new FoodCart(cart.getCartId(),cart.getCutomer() , cart.getItemsList());
		//return foodCartRepo.save(foodCart);
	}

	@Override
	public FoodCart increaseItemQuantity(int foodCartId, int foodItemId) {
		FoodCart cart = foodCartRepo.findById(foodCartId).orElse(null);
		if(cart != null) {
			for(int i=0; i< cart.getItemsList().size()-1; i++) {
				Item item = cart.getItemsList().get(i);
				if(item.getItemId()==foodItemId) {
					item.setQuantity(item.getQuantity()+1);
	
				}
			}
		}
		return cart;
	}

	@Override
	public FoodCart reduceItemQuantity(int foodCartId, int foodItemId) {
		FoodCart cart = foodCartRepo.findById(foodCartId).orElse(null);
		if(cart != null) {
			for(int i=0; i< cart.getItemsList().size()-1; i++) {
				Item item = cart.getItemsList().get(i);
				if(item.getItemId()==foodItemId) {
					item.setQuantity(item.getQuantity()-1);
	
				}
			}
		}
		return cart;
	}

	@Override
	public FoodCart removeItemFromCart(int foodCartId, int foodItemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart clearCart(int foodCartId) {
		FoodCart cart = foodCartRepo.findById(foodCartId).orElse(null);
		 
		if(cart != null) {
			foodCartRepo.deleteById(foodCartId);
		
		}
		return cart;
	}

	@Override
	public FoodCart findCartById(int cartId) {
		return foodCartRepo.findById(cartId).orElse(null);
	}

	@Override
	public List<FoodCart> allCart() {
		return foodCartRepo.findAll();
	}

	

}
