package com.prototype.genapp.service;

import java.util.List;
import java.util.Optional;

import com.prototype.genapp.dto.MotorPolicyDto;
import com.prototype.genapp.entity.Policy;

public interface MotorPolicyService 
{
	
	MotorPolicyDto addMotorPolicy(MotorPolicyDto motorPolicyDto);

	List<Policy> getAllPolicies();

	Optional<Policy> getPolicyById(int policyId);
	
	int getPolicyCountByCustomerId(int customerId);

	void updateMotorPolicy(int customerNumber, int policyNumber, MotorPolicyDto motorPolicyDto);

	void deletePoliciesByCustomer(int customerNumber);

	
}