package com.Food.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Food.Entities.Customer;
import com.Food.Entities.Product;

public interface FoodRepo extends JpaRepository<Product ,Integer>{
	public List<Product> findByCategory(String category);

	
	
	
	}