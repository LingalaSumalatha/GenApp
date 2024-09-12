package com.prototype.genapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.genapp.entity.Motor;

@Repository
public interface MotorRepository extends JpaRepository<Motor, Integer> {

	Motor findByPolicynumber(Long policynumber);

}
