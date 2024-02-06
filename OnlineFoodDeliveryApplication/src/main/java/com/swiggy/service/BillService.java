package com.swiggy.service;

import java.time.LocalDateTime;
import java.util.List;

import com.swiggy.dto.Bill;

public interface BillService {
	Bill addBill(Bill bill, int orderDetailsId);
	Bill updateBill(Bill bill);
	Bill removeBill(int billId);
	Bill viewBill(int BillId);
	List<Bill> viewBillsByDate(LocalDateTime startDate, LocalDateTime endDate);
	double calculateTotalCost(int BillId);
}
