package com.example.insurance.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.insurance.entity.Account;
import com.example.insurance.entity.CustomerPolicy;
import com.example.insurance.service.CustomerPolicyService;

@RestController
public class CustomerPolicyController {

	@Autowired
	CustomerPolicyService custPolicyService;
	
	@PostMapping("/addAccountDetails")
	public String addAccountDetails(@RequestBody Account account) {
		return custPolicyService.addAccountDetails(account);
	}

	@GetMapping("/getAllAccount")
	public List<Account> getAllAccount(){
		return custPolicyService.getAllAccount();
		
	}

	@PatchMapping("/updateAccountDetail/{id}")
	public String updateAccountDetails(@PathVariable int id,@RequestBody Account account) {
		return custPolicyService.updateAccountDetails(id,account);
		
	}
	
	@DeleteMapping("/removeAccount/{id}")
	public String removeAccount(@PathVariable int id) {
		return custPolicyService.removeAccount(id);
		
	}
	
	@GetMapping("/getAccountByCustId")
	public List<Account> getAccountDetailsByCustId(@RequestParam int cid){
		return custPolicyService.getAccountDetailsByCustId(cid);
		
	}
	
	//Customer Policy Related Operations
	
	@PostMapping("/applyPolicy")
	public String applyPolicy(@RequestParam int custId ,@RequestParam int pid,
			@RequestParam int accid, @RequestParam String paymentDate, 
			@RequestParam int amount, @RequestParam int term,
			@RequestParam String paymentMode) throws ParseException {
		return custPolicyService.applyPolicy(custId,pid,accid,paymentDate,amount,term,paymentMode);
		
	}
	
    @GetMapping("/getAllCustomerPolicy")
    public List<CustomerPolicy> getAllCustomerPolicy(){
		return custPolicyService.getAllCustomerPolicy();
    	
    }
    
    @DeleteMapping("/removeCustomerPolicy/{id}")
    public String removeCustomerPolicy(@PathVariable int id) {
		return custPolicyService.removeCustomerPolicy(id);
    	
    }
    
}
