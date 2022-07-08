package com.friendsFoodCorner.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.friendsFoodCorner.Entity.Menu;



@Repository
public interface MenuRepo extends JpaRepository<Menu, Integer>{
	List<Menu> findByCategory(String category);
	Menu findByItem(String item);
	Menu save(String item);
}
