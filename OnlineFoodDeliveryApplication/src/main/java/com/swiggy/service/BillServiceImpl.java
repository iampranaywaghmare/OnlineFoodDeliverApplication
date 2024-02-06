package com.swiggy.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiggy.dao.BillDaoImpl;
import com.swiggy.dto.Bill;

@Service
public class BillServiceImpl implements BillService{

	@Autowired
	BillDaoImpl billDao;
	
	@Override
	public Bill addBill(Bill bill, int orderDetailsId) {
		return billDao.addBill(bill, orderDetailsId);
	}

	@Override
	public Bill updateBill(Bill bill) {
		return billDao.updateBill(bill);
	}

	@Override
	public Bill removeBill(int billId) {
		return billDao.removeBill(billId);
	}

	@Override
	public Bill viewBill(int BillId) {
		return billDao.viewBill(BillId);
	}

	@Override
	public List<Bill> viewBillsByDate(LocalDateTime startDate, LocalDateTime endDate) {
		return billDao.viewBillsByDate(startDate, endDate);
	}

	@Override
	public double calculateTotalCost(int BillId) {
		return billDao.calculateTotalCost(BillId);
	}

}
