package com.swiggy.dao;

import java.util.List;

import com.swiggy.dto.OrderDetails;

public interface OrderDao {
	
	OrderDetails addOrder(OrderDetails order,int cartId);
	OrderDetails updateOrder(OrderDetails order);
	OrderDetails removeOrder(int orderId);
	OrderDetails viewOrder(int orderId);
	//List<OrderDetails> viewOrdersByRestaurantName(String restaurantName);
	List<OrderDetails> viewOrdersByCustomer(int customerId);
}
