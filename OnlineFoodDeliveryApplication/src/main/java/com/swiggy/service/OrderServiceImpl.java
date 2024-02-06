package com.swiggy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiggy.dao.OrderDaoImpl;
import com.swiggy.dto.OrderDetails;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDaoImpl orderDao;
	
	@Override
	public OrderDetails addOrder(OrderDetails order,int cartId) {
		return orderDao.addOrder(order,cartId);
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		return orderDao.updateOrder(order);
	}

	@Override
	public OrderDetails removeOrder(int orderId) {
		return orderDao.removeOrder(orderId);
	}

	@Override
	public OrderDetails viewOrder(int orderId) {
		return orderDao.viewOrder(orderId);
	}

	@Override
	public List<OrderDetails> viewOrdersByCustomer(int customerId) {
		return orderDao.viewOrdersByCustomer(customerId);
	}

}
