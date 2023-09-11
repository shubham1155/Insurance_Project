package com.example.insurance.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.insurance.entity.CustomerPolicy;

@Repository
public interface CustomerPolicyDAO extends JpaRepository<CustomerPolicy, Integer> {

}
