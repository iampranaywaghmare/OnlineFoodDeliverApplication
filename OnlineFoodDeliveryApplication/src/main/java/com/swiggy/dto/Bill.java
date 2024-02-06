package com.swiggy.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bill_tbl")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bill_id")
	int billId;
	@Column(name="date")
	LocalDateTime date;
	@OneToOne
	@JoinColumn(name="order_details")
	OrderDetails orderDetails;
	@Column(name="total_items")
	int totalItems;
	@Column(name="total_cost")
	double totalCost;
	
	public Bill() {
		
	}
	
	public Bill(int billId, LocalDateTime date, OrderDetails orderDetails, int totalItems, double totalCost) {
		super();
		this.billId = billId;
		this.date = date;
		this.orderDetails = orderDetails;
		this.totalItems = totalItems;
		this.totalCost = totalCost;
	}
	
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", date=" + date + ", orderDetails=" + orderDetails + ", totalItems="
				+ totalItems + ", totalCost=" + totalCost + "]";
	}
	
	
}
