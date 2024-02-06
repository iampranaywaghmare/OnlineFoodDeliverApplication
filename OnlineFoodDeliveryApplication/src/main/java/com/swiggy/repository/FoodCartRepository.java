package com.swiggy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swiggy.dto.FoodCart;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Integer>{
	
}
