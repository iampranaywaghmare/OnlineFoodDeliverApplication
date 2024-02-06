package com.swiggy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swiggy.dto.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
	
	@Query("select r from Restaurant r where r.address.city = :location")
	List<Restaurant> searchNearByRestaurant(@Param("location") String location);
	
	@Query("select r from Restaurant r where r.restaurantName = :restaurantName")
	Restaurant searchRestaurantByName(@Param("restaurantName") String restaurantName);
	
	
	//@Query("select r from Restaurant r where r.itemsList.itemName = :itemName")
	//List<Restaurant> searchRestaurantByItemName(@Param("itemName") String itemName);
}
