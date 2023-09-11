package com.example.insurance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurance.Dao.PolicyDAO;
import com.example.insurance.entity.Policy;

@Service
public class PolicyService {

	@Autowired
	PolicyDAO polyDao;

	public String addPolicy(Policy policy) {
	   Policy p = polyDao.save(policy);
	   
	  if(p.equals(null)) {
		return "Policy not added...!";
	}else {
		return "Policy added...!";
	}
	}

	public List<Policy> getAllPolicy() {
		return polyDao.findAll();
	}

	
	public List<Policy> getPolicyByCategory(String cname) {

		List<Policy> list = polyDao.findAll();
		
		List<Policy> newList = new ArrayList<Policy>();
		for(Policy p:list) {
			if(p.getCategory().getCname().equals(cname)) {
				newList.add(p);
			}
		}
		return newList;
	}
	
	public String removePolicy(int id) {
	       Policy p = polyDao.findById(id).get();
			if(p.getPid()==id) {
				polyDao.deleteById(id);
				return "Policy removed successfully...!";
			}else {
			return "Id is not present";
			}
		}


	public String updatePolicy(Policy policy, int id) {
		Optional<Policy> p = polyDao.findById(id);
			if(p.isPresent()) {
				Policy newP = p.get();
				
				newP.setPid(policy.getPid());
				newP.setPname(policy.getPname());
				newP.setReqDoc(policy.getReqDoc());
				newP.setTerm(policy.getTerm());
				newP.setCategory(policy.getCategory());
				
				polyDao.save(newP);
				return "Updated successfully...!";
			}else {
		return "Id is not found!";
	}
}
	
	
}
