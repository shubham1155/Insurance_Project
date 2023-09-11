package com.example.insurance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurance.Dao.AdminDAO;
import com.example.insurance.Dao.CategoryDAO;
import com.example.insurance.entity.Admin;
import com.example.insurance.entity.Category;
@Service
public class AdminService {

	@Autowired
	AdminDAO AdminDao;
	
	@Autowired
	CategoryDAO cateDao;
	
	public String registerAdmin(Admin admin) {
		Admin a = AdminDao.save(admin);
		if(a.equals(null)) {
			return "Registeration failed";
		}
		return "Successfully registered";
	}

	public String loginAdmin(String email, String password) {
       List<Admin> list = AdminDao.findAll();
       for(Admin a1:list) {
    	   if(a1.getEmail().equals(email)&&a1.getPassword().equals(password)) {
    		   return "Logged In";
    	   }
       }
		return "Wrong Credential";
	}

	public List<Admin> getAllUsers() {
		return AdminDao.findAll();
	}

	public String removeAdmin(int id) {
		List<Admin> list = AdminDao.findAll();
	      for(Admin a:list) {
	    	  if(a.getAid()==id) {
	    		  AdminDao.delete(a);
	    		  return "Deleted successfully...!";
	    	  }
	      }
			return "Invalid data!";
}

	public String updateAdminDetails(int id, Admin admin) {
	  List<Admin>  list = AdminDao.findAll();
	  for(Admin a1:list ) {
		  if(a1.getAid()==id) {
			  Admin newAd = new Admin();
			  
			  newAd.setName(a1.getName());
			  newAd.setDob(a1.getDob());
			  newAd.setEmail(a1.getEmail());
			  newAd.setMobno(a1.getMobno());
			  newAd.setPassword(a1.getPassword());
			  
			  AdminDao.save(admin);
			  return "Updated successfully...!";
		  }
	  }
		return  "Id not found!";
	}

	public String addCategory(Category category) {
		Category c = cateDao.save(category);
		
		if(c.equals(null)) {
			return "Category is not added";
		}else {
		return "Category added successfully...!";
	}
	}

	public List<Category> getAllCategory() {
		return cateDao.findAll();
	}

	
	public List<Category> getCategoryByName(String name) {
      List<Category> list = cateDao.findAll();
      
      List<Category> newCate = new ArrayList<>();
      for(Category c:list) {
    	  if(c.getCname().equals(name)) {
    		  newCate.add(c);
    	  }
      }
		return newCate;
	}
	
	
	public String removeCategory(int id) {
		Optional<Category> c = cateDao.findById(id);
		if(c.isPresent()) {
			cateDao.deleteById(id);
			return "Category removed successfully...!";
		} else {
			return "Id is not present";
		}
		
	} 


	public String updateCategory(Category category, int id) {
         Optional<Category> c = cateDao.findById(id);
		if(c.isPresent()) {
			
			Category newCate = c.get();
			newCate.setCname(category.getCname());
			
			cateDao.save(newCate);
			return "Category details updated...!";
		}else {
		return "Category is not present";
	}
	}

}
