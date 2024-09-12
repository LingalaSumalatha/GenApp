package com.prototype.genapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.genapp.entity.Customer_secure;

@Repository
public interface Customer_secureRepository extends JpaRepository<Customer_secure, Integer> {

}
