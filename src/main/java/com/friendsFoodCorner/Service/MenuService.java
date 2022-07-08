package com.friendsFoodCorner.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendsFoodCorner.Entity.Cart;
import com.friendsFoodCorner.Entity.Menu;
import com.friendsFoodCorner.Exception.ItemNotFoundException;
import com.friendsFoodCorner.Repo.CartRepo;
import com.friendsFoodCorner.Repo.MenuRepo;

@Service
public class MenuService {
	@Autowired
	MenuRepo menurepo;
	@Autowired
	CartRepo cartrepo;


	public Menu getItemById(int id) {
		if(!menurepo.existsById(id))
			throw new ItemNotFoundException("Item Not Found : " +id);
		return menurepo.findById(id).get();
	}

	public List<Menu> getAllItems() {
		List<Menu> items = new ArrayList<Menu>();
		menurepo.findAll().forEach(item -> items.add(item));
		return items;
	}

	public void save(Menu menu) {

		menurepo.save(menu);
	}

	public void deleteItemById(int id) {
		if(!menurepo.existsById(id))
			throw new ItemNotFoundException("Item Not Found : " +id);
		menurepo.deleteById(id);
	}

	public List<Menu> findAllItem(String category) {
		List<Menu> items = new ArrayList<Menu>();
		menurepo.findByCategory(category).forEach(item -> items.add(item));
		return items;
	}

	public Menu findAllItems(String item) {		
		Menu menu=new Menu();		
		menu=menurepo.findByItem(item);		
		return menu;
		
	}

	public List<Cart> getAllIt() {
		List<Cart> citems = new ArrayList<Cart>();
		cartrepo.findAll().forEach(itm -> citems.add(itm));
		return citems;
	}

	public List<Cart> findAllIt(String name) {
		double Tamt = 0;
		List<Cart> names = new ArrayList<Cart>();		
		cartrepo.findByName(name).forEach(citm -> names.add(citm));
		 Iterator<Cart> it = names.iterator();
		while(it.hasNext()) 
		{	
			double Amount=it.next().total;
			Tamt+=Amount;	
		}
		return names;
	}

	public Menu findCart(Cart cart) {        
	    Menu menu=new Menu();        
	    menu = menurepo.findByItem(cart.item);
	     if(cart.quantity >= 1) {
	    
	    cart.item=menu.item;
	    cart.price=menu.price;
	    cart.image=menu.image;
	    cart.name=cart.getName();
	    cart.quantity=cart.getQuantity();
	    cart.total= cart.price * cart.quantity;
	    cartrepo.save(cart);
	    return menu;
	    }
	     else
{
	        throw new ArithmeticException("you have enter invalid value");
	    }   
	    }

public Cart updatecart(Cart cart) {
	
	if(cart.quantity >= 1) {
	Menu menu=new Menu();		
	menu = menurepo.findByItem(cart.item);
	cart.id=cart.getId();
	cart.price=menu.price;
	cart.total=cart.price*cart.quantity;
	cartrepo.save(cart);
	return cart;
}
	else{
        throw new ArithmeticException("You entered invalid value");
 }	
}
public void deleteItem(int id) {
	if(!cartrepo.existsById(id))
		throw new ItemNotFoundException("Item Not Found : " +id);
		cartrepo.deleteById(id);
}




}