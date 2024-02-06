package com.swiggy.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swiggy.dto.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{
	
	@Query("SELECT b from Bill b WHERE b.date BETWEEN :startDate AND :endDate")
	List<Bill> viewBillsByDate(@Param("startDate") LocalDateTime startDate,@Param("endDate") LocalDateTime endDate);
}
