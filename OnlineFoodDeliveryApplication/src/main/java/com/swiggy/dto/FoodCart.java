package com.swiggy.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="food_cart")
public class FoodCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_id")
	int cartId;
	@OneToOne
	@JoinColumn(name="customer")
	Customer cutomer;
	@OneToMany
	@JoinColumn(name="list_of_items")
	List<Item> itemsList;
	
	public FoodCart() {
	}
	
	public FoodCart(int cartId, Customer cutomer, List<Item> itemsList) {
		super();
		this.cartId = cartId;
		this.cutomer = cutomer;
		this.itemsList = itemsList;
	}
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Customer getCutomer() {
		return cutomer;
	}
	public void setCutomer(Customer cutomer) {
		this.cutomer = cutomer;
	}
	public List<Item> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<Item> itemsList) {
		this.itemsList = itemsList;
	}
	@Override
	public String toString() {
		return "FoodCart [cartId=" + cartId + ", cutomer=" + cutomer + ", itemsList=" + itemsList + "]";
	}
	
	
}
