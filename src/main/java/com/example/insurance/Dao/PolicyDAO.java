package com.example.insurance.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.insurance.entity.Policy;

@Repository
public interface PolicyDAO extends JpaRepository<Policy, Integer> {

}
