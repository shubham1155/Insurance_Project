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

import com.example.insurance.entity.Admin;
import com.example.insurance.entity.Category;
import com.example.insurance.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	AdminService serviceAdmin;
	
	@PostMapping("/registerAdmin")
	public String registerAdmin(@RequestBody Admin admin) {
		return serviceAdmin.registerAdmin(admin);
	}
	
	@GetMapping("/loginAdmin")
	public String loginAdmin(@RequestParam String email,@RequestParam String password) {
		return serviceAdmin.loginAdmin(email,password);
	}
	
	@GetMapping("/getAllUsers")
	public List<Admin> getAllUsers(){
		return serviceAdmin.getAllUsers();
		}
	
	@DeleteMapping("/removeAdmin/{id}")
	public String removeAdmin(@PathVariable int id) {
		return serviceAdmin.removeAdmin(id);
	}
	
	@PutMapping("/updateAdminDetails/{id}")
	public String updateAdminDetails(@PathVariable int id,@RequestBody Admin admin) {
		return serviceAdmin.updateAdminDetails(id,admin);
	}
	
	@PostMapping("/addCategory")
	public String addCategory(@RequestBody Category category) {
		return serviceAdmin.addCategory(category);
	}
	
	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory(){
		return serviceAdmin.getAllCategory();
		
	}
	
	
	@GetMapping("/getCategoryByName")
	public List<Category> getCategoryByName(@RequestParam String name){
		return serviceAdmin.getCategoryByName(name);
	}
	
	@DeleteMapping("/removeCategory/{id}")
	public String removeCategory(@PathVariable int id) {
		 serviceAdmin.removeCategory(id);
		 return "Deleted successfully...!";
	}
	
	
	@PutMapping("/updateCategory/{id}")
	public String updateCategory(@RequestBody Category category,@PathVariable int id) {
		return serviceAdmin.updateCategory(category,id);
		
	}
}
