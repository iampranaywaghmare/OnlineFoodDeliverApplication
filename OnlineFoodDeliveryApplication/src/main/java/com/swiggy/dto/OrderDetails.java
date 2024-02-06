package com.swiggy.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	int orderId;
	@Column(name="date")
	LocalDateTime localDateTime;
	@OneToOne
	FoodCart cart;
	@Column(name="order_status")
	String orderStatus;
	
	public OrderDetails() {
	
	}
	
	public OrderDetails(int orderId, LocalDateTime localDateTime, FoodCart cart, String orderStatus) {
		super();
		this.orderId = orderId;
		this.localDateTime = localDateTime;
		this.cart = cart;
		this.orderStatus = orderStatus;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public FoodCart getCart() {
		return cart;
	}
	public void setCart(FoodCart cart) {
		this.cart = cart;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", localDateTime=" + localDateTime + ", cart=" + cart
				+ ", orderStatus=" + orderStatus + "]";
	}
	
	
}
