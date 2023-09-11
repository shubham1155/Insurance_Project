package com.example.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurance.Dao.CustomerDAO;
import com.example.insurance.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerDAO custDao;

	public String registerCustomer(Customer customer) {
		Customer c = custDao.save(customer);
		if(c.equals(null)) {
			return "Registration failed!"; 
		}
		return "Successfully Registered...!";
	}

	public List<Customer> getAllCustomer() {
		return custDao.findAll();
	}

	public String loginCustomer(String email, String password) {

		List<Customer> list = custDao.findAll();
		for(Customer c:list) {
			if(c.getCustEmail().equals(email)&&c.getCustPassword().equals(password)) {
				return "Logged In";
			}
		}
		return "Wrong Crendential";
	}

	public String removeCustomer(int id) {
		Customer c = custDao.findById(id).get();
		
		if(c.getCustId()==id) {
			custDao.deleteById(id);
			return "Deleted successfully...!";
		}else {
		return "Customer is not present!";
	}
	}

	public String updateCustomerDetail(Customer customer, int id) {

		List<Customer> list = custDao.findAll();
		for(Customer c:list) {
			if(c.getCustId()==id) {
				Customer newCust = new Customer();
				
				newCust.setCustName(c.getCustName());
				newCust.setAddress(c.getAddress());
				newCust.setCustDOB(c.getCustDOB());
				newCust.setCustEmail(c.getCustEmail());
				newCust.setCustPassword(c.getCustPassword());
				newCust.setMobno(c.getMobno());
				
				custDao.save(customer);
				return "Updated successfully...!";
			}
		}
		return "Customer is not present!";
	}
}
