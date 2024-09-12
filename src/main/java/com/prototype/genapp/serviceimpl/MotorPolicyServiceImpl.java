package com.prototype.genapp.serviceimpl;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.genapp.dto.MotorPolicyDto;
import com.prototype.genapp.entity.Motor;
import com.prototype.genapp.entity.Policy;
import com.prototype.genapp.repository.MotorRepository;
import com.prototype.genapp.repository.PolicyRepository;
import com.prototype.genapp.service.MotorPolicyService;

import jakarta.transaction.Transactional;

@Service
public class MotorPolicyServiceImpl implements MotorPolicyService 
{
	
	 private final PolicyRepository policyRepository;
	 private final MotorRepository motorRepository;
	 
	 @Autowired
	    public MotorPolicyServiceImpl(PolicyRepository policyRepository, MotorRepository motorRepository) {
	        this.policyRepository = policyRepository;
	        this.motorRepository = motorRepository;
	    }
	 
	   @Transactional
	    public MotorPolicyDto addMotorPolicy(MotorPolicyDto motorPolicyDto)
	   {
		// Create and save policy entity
		   Policy policy = new Policy();
		    policy.setCustomernumber(motorPolicyDto.getCustomerNumber());
		    policy.setIssuedate(motorPolicyDto.getIssueDate());
		    policy.setExpirydate(motorPolicyDto.getExpiryDate());
		    policy.setLastchanged(new Date()); // Set lastchanged to current timestamp

		    // Set other policy attributes...
		    policyRepository.save(policy);
	        
		 // Create and save motor entity
		    Motor motor = new Motor();
		    motor.setPolicynumber(policy.getPolicynumber());
		    motor.setMake(motorPolicyDto.getMake());
		    motor.setModel(motorPolicyDto.getModel());
		    motor.setValue(motorPolicyDto.getValue());
		    // Set other motor attributes...
		    motorRepository.save(motor);

		    // Return the saved MotorPolicyDto or any necessary response
		    return motorPolicyDto;
		   
	   }

	@Override
	public List<Policy> getAllPolicies() {
		 return policyRepository.findAll();
	}

	 @Override
	    public Optional<Policy> getPolicyById(int policyId) {
	        return policyRepository.findById(policyId);
	    }
	 
	  @Override
	    public int getPolicyCountByCustomerId(int customerId) {
	        return policyRepository.countByCustomernumber(customerId);
	    }
	  
	  @Override
	  public void updateMotorPolicy(int customerNumber, int policyNumber, MotorPolicyDto motorPolicyDto) {
	      // Find the policy by both customer number and policy number
	      Policy existingPolicy = policyRepository.findByCustomernumberAndPolicynumber(customerNumber, policyNumber)
	              .orElseThrow(() -> new IllegalArgumentException("Policy not found with customer number: " + customerNumber + " and policy number: " + policyNumber));

	      // Update the attributes of the existing policy with the values from the DTO
	      existingPolicy.setIssuedate(motorPolicyDto.getIssueDate());
	      existingPolicy.setExpirydate(motorPolicyDto.getExpiryDate());
	      existingPolicy.setCarMake(motorPolicyDto.getMake());
	      existingPolicy.setCarModel(motorPolicyDto.getModel());
	      // Update other attributes as needed

	      // Save the updated policy
	      try {
	          policyRepository.save(existingPolicy);
	      } catch (Exception e) {
	          // Handle any exceptions, you can log the error or throw a custom exception
	          throw new RuntimeException("Failed to update policy: " + e.getMessage(), e);
	      }
	  }

	  public void deletePoliciesByCustomer(int customerNumber) {
	        // Find all policies associated with the customer
	        List<Policy> policiesToDelete = policyRepository.findByCustomernumber(customerNumber);
	        
	        if (policiesToDelete.isEmpty()) {
	            throw new IllegalArgumentException("No policies found for customer: " + customerNumber);
	        }

	        // Delete all policies associated with the customer
	        try {
	            policyRepository.deleteAll(policiesToDelete);
	        } catch (Exception e) {
	            // Handle any exceptions, you can log the error or throw a custom exception
	            throw new RuntimeException("Failed to delete policies: " + e.getMessage(), e);
	        }
	    }

	public MotorPolicyDto addMotorPolicy1(MotorPolicyDto motorPolicyDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateMotorPolicy1(int customerNumber, int policyNumber, MotorPolicyDto motorPolicyDto) {
		// TODO Auto-generated method stub
		
	}


}
