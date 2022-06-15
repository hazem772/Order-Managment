package com.hazem.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hazem.models.LoginModel;
import com.hazem.models.OrderModel;
import com.hazem.services.OrdersBusinessServiceInterface;

@Controller
@RequestMapping("/login")
public class LoginController {

	OrdersBusinessServiceInterface service;
	
	@Autowired
	public LoginController(OrdersBusinessServiceInterface service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/")
	public String displayLoginForm(Model model) {
		
		model.addAttribute("loginModel", new LoginModel());
		
		return "loginForm.html";
	}
	
	@PostMapping("/processLogin")
	public String processLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("loginModel", loginModel);
			return "loginForm.html";
		}
		
        List<OrderModel> orders = service.getOrders();
		
		model.addAttribute("title", "Here is what I want to do this summer");
		model.addAttribute("orders", orders);
		
		return "orders.html";
	}
	
}
