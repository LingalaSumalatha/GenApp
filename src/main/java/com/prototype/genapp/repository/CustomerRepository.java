package com.prototype.genapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.genapp.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> 
{
    Customer findByEmailaddress(String email);
	Customer findByCustomernumber(int customernumber);
	boolean existsByCustomernumber(int customernumber);
}

