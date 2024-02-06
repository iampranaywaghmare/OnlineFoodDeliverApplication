package com.swiggy.service;

import java.util.List;

import com.swiggy.dto.OrderDetails;

public interface OrderService {
	
	OrderDetails addOrder(OrderDetails order,int cartId);
	OrderDetails updateOrder(OrderDetails order);
	OrderDetails removeOrder(int orderId);
	OrderDetails viewOrder(int orderId);
	//List<OrderDetails> viewOrdersByRestaurantName(String restaurantName);
	List<OrderDetails> viewOrdersByCustomer(int customerId);
}
