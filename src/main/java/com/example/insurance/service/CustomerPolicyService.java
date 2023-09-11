package com.example.insurance.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurance.Dao.AccountDAO;
import com.example.insurance.Dao.CustomerDAO;
import com.example.insurance.Dao.CustomerPolicyDAO;
import com.example.insurance.Dao.PolicyDAO;
import com.example.insurance.entity.Account;
import com.example.insurance.entity.Customer;
import com.example.insurance.entity.CustomerPolicy;
import com.example.insurance.entity.Policy;

@Service
public class CustomerPolicyService {

	@Autowired
	AccountDAO accDao;
	
	@Autowired
	CustomerDAO custDao;

	@Autowired
	CustomerPolicyDAO custPolyDao;
	
	@Autowired
	PolicyDAO polyDao;
	
	public String addAccountDetails(Account account) {
		Optional<Customer> cust = custDao.findById(account.getCustomer().getCustId());
		if(cust.isPresent()) {
			Account a = new Account();
			Customer c1 = cust.get();	
			a.setAccNumber(account.getAccNumber());
			a.setAccType(account.getAccType());
			a.setBankName(account.getBankName());
			a.setIfscCode(account.getIfscCode());
			a.setCustomer(c1);
			accDao.save(a);
			return "Account details added..!";
		}
		return "Account details not added..!";
	}

	public List<Account> getAllAccount() {
		return accDao.findAll();
	}
	
	public String updateAccountDetails(int id, Account account) {
		
		Account a = accDao.findById(id).get();
		if(Optional.ofNullable(a).isPresent()) {
		if(Optional.ofNullable(account.getAccType()).isPresent()){
			
			a.setAccType(account.getAccType());
			a.setAccNumber(account.getAccNumber());
			a.setBankName(account.getBankName());
			a.setIfscCode(account.getIfscCode());
			accDao.save(a);
			return "Account details updated";
		}
		}
		return "Account is not available!";
		}
	

	public String applyPolicy(int custId, int pid, int accid, String paymentDate, int amount, int term,
			String paymentMode) throws ParseException {
		Optional<Customer> cust = custDao.findById(custId);
		if(cust.isPresent()) {
			CustomerPolicy custPolicy = new CustomerPolicy();
			custPolicy.setCustomer(cust.get());
			
			Optional<Policy> poly = polyDao.findById(pid);
			custPolicy.setPolicy(poly.get());
			
			Optional<Account> acc = accDao.findById(accid);
			custPolicy.setAccount(acc.get());
			
			java.sql.Timestamp regDate = new java.sql.Timestamp(new java.util.Date().getTime());
			custPolicy.setRegDate(regDate);
			
			Date d = new SimpleDateFormat("YYYY-MM-DD").parse(paymentDate);
			custPolicy.setPaymentDate(d);
			
			custPolicy.setAmount(amount);
			
			custPolicy.setTerm(term);
			
			custPolicy.setPaymentMode(paymentMode);
			
			final long MILLIS_IN_A_DAY = 1000*60*60*24;
			java.sql.Timestamp nextDueDate;
			
			if(paymentMode.equalsIgnoreCase("Weekly")) {
				nextDueDate = new java.sql.Timestamp(d.getTime() + (MILLIS_IN_A_DAY*7));
				
			}else if(paymentMode.equalsIgnoreCase("Monthly")) {
				nextDueDate = new java.sql.Timestamp(d.getTime() + (MILLIS_IN_A_DAY*30));

			}else if(paymentMode.equalsIgnoreCase("HalfYear")) {
				nextDueDate = new java.sql.Timestamp(d.getTime() + (MILLIS_IN_A_DAY*180));

			}else {
				nextDueDate = new java.sql.Timestamp(d.getTime() + (MILLIS_IN_A_DAY*365));
			}
			custPolicy.setNextDueDate(nextDueDate);
			
			custPolicy.setSumAssured(amount*term*poly.get().getRateOfInterest());
			
			custPolyDao.save(custPolicy);
			return "Applied for policy";
		}
		return "Not applied";
	}

	
	public List<CustomerPolicy> getAllCustomerPolicy() {
		return custPolyDao.findAll();
		}

	public String removeCustomerPolicy(int id) {

		CustomerPolicy cp = custPolyDao.findById(id).get();
		if(cp!=null) {
			custPolyDao.deleteById(id);
			return "Deleted successfully...!";
		}	
		return "Customer Policy doesn't exist!";
	}

	public String removeAccount(int id) {
		Optional<Account> a = accDao.findById(id);
		if(a.isPresent())
		{
			accDao.deleteById(id);
			return "Removed succesfully...!";
		}else {
			return "Invalid ID";
		}	
	}

	public List<Account> getAccountDetailsByCustId(int cid) {
	Customer c = custDao.findById(cid).get();
	
		List<Account> list = accDao.findAll();
		
		List<Account> newList = new ArrayList<Account>();
		for(Account a:list) {
			if(a.getCustomer().getCustId()==cid) {
				newList.add(a);
			}
		}
		return newList;
	}
		
}
