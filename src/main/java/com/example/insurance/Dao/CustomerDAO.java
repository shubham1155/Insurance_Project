package com.example.insurance.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.insurance.entity.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {

}
