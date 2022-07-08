package com.friendsFoodCorner.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.friendsFoodCorner.Entity.Cart;
import com.friendsFoodCorner.Entity.Menu;
import com.friendsFoodCorner.Service.MenuService;

@CrossOrigin(origins = "*")
@RestController
public class FoodControllerPost{
	@Autowired
	MenuService menuService;

	
//===============menu================
	
	@GetMapping("/menu")
	public List<Menu> getAllItems(){
List<Menu> items= menuService.getAllItems();
		return items;
	}

	@GetMapping("/men/{category}")
	public List<Menu> getAllItem_names(@PathVariable String category) throws Exception {
		List<Menu> itemByCat= menuService.findAllItem(category);
		if(itemByCat.isEmpty()){
			throw new Exception("Category Doesn't Exist");
		}else{
			return itemByCat;
		}
	}

	@GetMapping("/mnu/{item}")
	public Menu getAllItem_name(@PathVariable String item) throws Exception {
		Menu itemByName = menuService.findAllItems(item);
		if(itemByName==null)
			throw new Exception("Food Items Doesn't Exist");
		return itemByName;
	}

	@GetMapping("/menus/{id}")
	public Menu getItem(@PathVariable int id) throws Exception {
		Menu itemById= menuService.getItemById(id);
		if(itemById==null)
			throw new Exception("Food Items Doesn't Exist With This Id" + id);
		return itemById;
	}
	@DeleteMapping("/menu/{id}")
	public String deleteItem(@PathVariable("id") int id) {
		menuService.deleteItemById(id);
		return "Product Deleted";
	}
		

	@PostMapping("/addmenu")
	public String addMenu(@RequestBody Menu menu) {
			menuService.save(menu);
			if (menu == null)
				return "values cannot be null";
			return "added successfully";
	}
//	========= Cart=============

	@GetMapping("/cart")
	public List<Cart> getAllIt() throws Exception {
		List<Cart> carts= menuService.getAllIt();
		if(carts.isEmpty())
			throw new Exception("Cart Is Empty");
		return carts;
	}

	@GetMapping("/cart/{name}")
	public List<Cart> findAll(@PathVariable("name") String name) throws Exception {
		List<Cart> cartByName= menuService.findAllIt(name);
		if(cartByName.isEmpty())
			throw new Exception("Cart with this Name is not Exist");
		return cartByName;
		}


	@PostMapping("/addcart")
	public Menu addCart(@RequestBody Cart cart) {
		return menuService.findCart(cart);
	}
	@PutMapping("/cart")
	public Cart update(@RequestBody Cart cart ) {
		return menuService.updatecart(cart);
	}
	@DeleteMapping("/cart/{id}")
	public void delete(@PathVariable("id") int id) {
		menuService.deleteItem(id);
	}
}
