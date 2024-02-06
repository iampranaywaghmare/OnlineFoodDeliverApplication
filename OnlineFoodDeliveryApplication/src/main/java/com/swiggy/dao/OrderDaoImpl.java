package com.swiggy.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swiggy.dto.FoodCart;
import com.swiggy.dto.OrderDetails;
import com.swiggy.repository.CustomerRepository;
import com.swiggy.repository.FoodCartRepository;
import com.swiggy.repository.OrderDetailsRepository;

@Repository
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	OrderDetailsRepository orderDetailsRepo;
	
	@Autowired
	FoodCartRepository foodCart;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	public OrderDetails addOrder(OrderDetails order,int cartId) {
		FoodCart food =  foodCart.findById(cartId).orElse(null);
		order.setCart(food);
		return orderDetailsRepo.save(order);
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		return orderDetailsRepo.save(order);
	}

	@Override
	public OrderDetails removeOrder(int orderId) {
		OrderDetails order = orderDetailsRepo.findById(orderId).orElse(null);
		if(order != null) {
			orderDetailsRepo.deleteById(orderId);
		}
		return order;
	}

	@Override
	public OrderDetails viewOrder(int orderId) {
		return orderDetailsRepo.findById(orderId).orElse(null);
	}

	/*
	 * @Override public List<OrderDetails> viewOrdersByRestaurantName(String
	 * restaurantName) {
	 * 
	 * }
	 */

	@Override
	public List<OrderDetails> viewOrdersByCustomer(int customerId) {
		List<OrderDetails> orders = orderDetailsRepo.findAll();
		Iterator<OrderDetails> itr = orders.iterator();
		
		while(itr.hasNext()) {
			OrderDetails od = itr.next();
			if(od.getCart().getCutomer().getCustomerId() != customerId) {
				orders.remove(od);
			}
		}
		
		return orders;
	}

}
