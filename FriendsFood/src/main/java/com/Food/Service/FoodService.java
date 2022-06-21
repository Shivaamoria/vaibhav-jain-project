package com.Food.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Food.Entities.Customer;
import com.Food.Entities.Product;

@Service
public class FoodService {
	@Autowired
FoodRepo foodrepo;
	@Autowired
	CustRepo custrepo;
	public List<Product> getAllProductDetails(){
		return foodrepo.findAll();
	}
	
	public List<Product> getAllProductByCategory(String category){
		return foodrepo.findByCategory(category);
	}

	public Customer save(Customer c) {
		
		return custrepo.save(c);
	}


}
