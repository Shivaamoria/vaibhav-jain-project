package com.Food.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Food.Entities.Customer;
import com.Food.Service.FoodService;

@Controller
public class CustomerController 
{
  @Autowired
  FoodService manager;
   
  @RequestMapping("/contact")
  public String customer(HttpServletRequest req) {
	  Customer c=new Customer();
	  c.setCname(req.getParameter("myName"));
	  c.setEmail(req.getParameter("myEmail"));
	  c.setEnquiry(req.getParameter("mesg"));
	  c.setPhone(req.getParameter("myPhone"));
	  
	  c.setTquery(req.getParameter("myQuery"));
	  manager.save(c);
	  return "contact.jsp";
  }
   
 
}
