

package com.Food.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Food.Entities.Customer;
import com.Food.Service.FoodService;

@Controller
public class FoodController {
	@Autowired
	FoodService foodservice;
	@RequestMapping("/")
	public String index()	{
		return "FPage.jsp";
	}
	@RequestMapping("/Chinese")
	public String FindChinese(String category, Model m) {
		category="chinese";
		m.addAttribute("product",foodservice.getAllProductByCategory(category));
		return"chinese.jsp";
	}
	@RequestMapping("/South_Indian")
	public String FindSouth(String category, Model m) {
		category="South Indian";
		m.addAttribute("product",foodservice.getAllProductByCategory(category));
		System.out.println("product");
		
		return"southindian.jsp";
	}
	@RequestMapping("/North_Indian")
	public String FindNorth(String category, Model m) {
		category="North Indian";
		m.addAttribute("product",foodservice.getAllProductByCategory(category));
		return"northindian.jsp";
	}
	@RequestMapping("/cart")
	public String cart( Model m) {
	return"cart.jsp";
	}
	

}