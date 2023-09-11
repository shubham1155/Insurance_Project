package com.example.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.insurance.entity.Customer;
import com.example.insurance.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService custService;
	
	@PostMapping("/registerCustomer")
	public String registerCustomer(@RequestBody Customer customer) {
		return custService.registerCustomer(customer);
		
	}
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer(){
		return custService.getAllCustomer();
		
	}
	
	@GetMapping("/loginCustomer")
	public String loginCustomer(@RequestParam String email,@RequestParam String password) {
		return custService.loginCustomer(email,password);
		
	}
	
	@DeleteMapping("/removeCustomer/{id}")
	public String removeCustomer(@PathVariable int id) {
		return custService.removeCustomer(id);
		
	}
	
	@PutMapping("/updateCustomerDetail/{id}")
	public String updateCustomerDetail(@RequestBody Customer customer,@PathVariable int id) {
		return custService.updateCustomerDetail(customer,id);
		
	}
}
