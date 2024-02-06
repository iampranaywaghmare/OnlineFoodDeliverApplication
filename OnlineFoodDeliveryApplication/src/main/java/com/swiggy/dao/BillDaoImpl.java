package com.swiggy.dao;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swiggy.dto.Bill;
import com.swiggy.dto.FoodCart;
import com.swiggy.dto.Item;
import com.swiggy.dto.OrderDetails;
import com.swiggy.repository.BillRepository;
import com.swiggy.repository.OrderDetailsRepository;

@Repository
public class BillDaoImpl implements BillDao{

	@Autowired
	BillRepository billRepo;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepo;
	
	
	@Override
	public Bill addBill(Bill bill, int orderDetailsId) {
		OrderDetails orderDetails = orderDetailsRepo.findById(orderDetailsId).orElse(null);
		int totalItems=0;
		double totalCost =0;
		if(orderDetails != null) {
			bill.setOrderDetails(orderDetails);
			List<Item> items = orderDetails.getCart().getItemsList();
			totalItems = items.size();
			bill.setTotalItems(totalItems);
			Iterator<Item> itr = items.iterator();
			while(itr.hasNext()) {
				Item item = itr.next();
				totalCost = totalCost + item.getCost();
			}
			bill.setTotalCost(totalCost);
			billRepo.save(bill);
		}
		
		return bill;
	}

	@Override
	public Bill updateBill(Bill bill) {
		return billRepo.save(bill);
	}

	@Override
	public Bill removeBill(int billId) {
		Bill bill = billRepo.findById(billId).orElse(null);
		if(bill != null) {
			billRepo.deleteById(billId);
		}
		
		return bill;
	}

	@Override
	public Bill viewBill(int billId) {
		return billRepo.findById(billId).orElse(null);
	}

	@Override
	public List<Bill> viewBillsByDate(LocalDateTime startDate, LocalDateTime endDate) {
		return billRepo.viewBillsByDate(startDate, endDate);
	}

	/*
	 * @Override public List<Bill> viewBillByCustomerId(int customerId) {
	 * 
	 * }
	 */

	@Override
	public double calculateTotalCost(int BillId) {
		Bill bill = billRepo.findById(BillId).orElse(null);
		double totalPrice = 0;
		if(bill != null) {
			OrderDetails order = bill.getOrderDetails();
			FoodCart cart = order.getCart();
			List<Item> items =  cart.getItemsList();
			
			Iterator<Item> itr = items.iterator();
			while(itr.hasNext()) {
				Item itm = itr.next();
				totalPrice = totalPrice + itm.getCost();
			}
			
		}
		return totalPrice;
	}
	
	
	

}
