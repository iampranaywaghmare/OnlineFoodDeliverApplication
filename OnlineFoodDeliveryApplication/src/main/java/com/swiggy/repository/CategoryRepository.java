package com.swiggy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swiggy.dto.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
