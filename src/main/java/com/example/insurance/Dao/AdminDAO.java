package com.example.insurance.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.insurance.entity.Admin;

@Repository 
public interface AdminDAO extends JpaRepository<Admin, Integer>{

}
