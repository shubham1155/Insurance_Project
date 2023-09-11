package com.example.insurance.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.insurance.entity.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer>{

}
