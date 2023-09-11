package com.example.insurance.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.insurance.entity.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, Integer> {

}
