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

import com.example.insurance.entity.Policy;
import com.example.insurance.service.PolicyService;


@RestController
public class PolicyController {

	@Autowired
	PolicyService polyService;
	
	@PostMapping("/addPolicy")
	public String addPolicy(@RequestBody Policy policy) {
		return polyService.addPolicy(policy);
		
	}
	
	@GetMapping("/getAllPolicy")
	public List<Policy> getAllPolicy(){
		return polyService.getAllPolicy();
	}
	
	@GetMapping("/getPolicybyCategory")
	public List<Policy> getPolicyByCategory(@RequestParam String cname){
		return polyService.getPolicyByCategory(cname);
		
	}
	
	@DeleteMapping("/removePolicy/{id}")
	public String removePolicy(@PathVariable int id) {
		return polyService.removePolicy(id);
		
	}
	@PutMapping("/updatePolicy/{id}")
	public String updatePolicy(@RequestBody Policy policy,@PathVariable int id) {
		return polyService.updatePolicy(policy,id);
		
	}
}
