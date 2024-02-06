package com.swiggy.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.dto.Bill;
import com.swiggy.service.BillServiceImpl;


@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	BillServiceImpl billService;
	
	@PostMapping("/add/{orderDetailsId}")
	Bill addBill(@RequestBody Bill bill,@PathVariable("orderDetailsId") int orderDetailsId) {
		return billService.addBill(bill, orderDetailsId);
	}
	
	@GetMapping("/find/{billId}")
	Bill viewBill(@PathVariable("billId") int billId){
		return billService.viewBill(billId);
	}
	
	@DeleteMapping("/delete/{billId}")
	Bill removeBill(@PathVariable("billId") int billId) {
		return billService.removeBill(billId);
	}
	/*
	Bill updateBill(Bill bill);
	
	
	
	List<Bill> viewBillsByDate(LocalDateTime startDate, LocalDateTime endDate);
	double calculateTotalCost(int BillId);
	*/
}
