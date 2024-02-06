package com.swiggy.dao;

import java.time.LocalDateTime;
import java.util.List;



import com.swiggy.dto.Bill;

public interface BillDao {
	Bill addBill(Bill bill, int orderDetailsId);
	Bill updateBill(Bill bill);
	Bill removeBill(int billId);
	Bill viewBill(int BillId);
	List<Bill> viewBillsByDate(LocalDateTime startDate, LocalDateTime endDate);
	double calculateTotalCost(int BillId);
	/*List<Bill> viewBillByCustomerId(int customerId);*/
}
	
	
