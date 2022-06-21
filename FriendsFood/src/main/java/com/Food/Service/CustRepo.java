package com.Food.Service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Food.Entities.Customer;

public interface CustRepo extends JpaRepository<Customer , Integer>  {

	

	

}
