package com.friendsFoodCorner.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.friendsFoodCorner.Entity.Cart;
@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>, CrudRepository<Cart, Integer> {
	List<Cart> findByName(String name);

	Cart findByItem(String item);
	Cart deleteById(int id);
	
}