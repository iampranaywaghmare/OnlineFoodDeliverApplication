package com.swiggy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swiggy.dto.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	
	
	@Query("Select i from Item i where i.itemName = :itemName")
	List<Item> viewItemByName(@Param("itemName") String itemName);
}
