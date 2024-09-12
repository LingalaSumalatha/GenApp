package com.prototype.genapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.genapp.dto.MotorPolicyDto;
import com.prototype.genapp.entity.Policy;
import com.prototype.genapp.service.MotorPolicyService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;




@RestController
@RequestMapping("/motor-policy")
@Tag(name = "Motor Rest Api's")
//@Api(value = "Motor Policy Management System", description = "Operations pertaining to motor policies in the Motor Policy Management System")
public class MotorPolicyController {

    private final MotorPolicyService motorPolicyService;

    @Autowired
    public MotorPolicyController(MotorPolicyService motorPolicyService) {
        this.motorPolicyService = motorPolicyService;
    }
    

    @PostMapping("/add")
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")  
    public ResponseEntity<String> addMotorPolicy(@RequestBody MotorPolicyDto motorPolicyDto) {
        // Call the service method to add the motor policy
        try {
            motorPolicyService.addMotorPolicy(motorPolicyDto);
            return ResponseEntity.ok("Motor policy added successfully");
        } catch (Exception e) {
            // Handle any exceptions and return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add motor policy: " + e.getMessage());
        }
    }
    
    

    @GetMapping("/all")
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    public ResponseEntity<List<Policy>> getAllPolicies() {
        try {
            // Call the appropriate service method to get all policies
            List<Policy> policies = motorPolicyService.getAllPolicies();
            return ResponseEntity.ok(policies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
 
    @GetMapping("/{policyId}")
 
    public ResponseEntity<?> getPolicyById(@PathVariable int policyId) {
        try {
            // Call service method to retrieve policy by ID
            Optional<Policy> policy = motorPolicyService.getPolicyById(policyId);
            
            // Check if policy exists
            if (policy.isPresent()) {
                // Return policy if found
                return ResponseEntity.ok(policy.get());
            } else {
                // Return not found status if policy does not exist
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Handle any exceptions and return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve policy: " + e.getMessage());
        }
    }
    
 //   @ApiOperation(value = "Get policy count by customer ID")
    @GetMapping("/customer/{customerId}/policy-count")
    public ResponseEntity<Integer> getPolicyCountByCustomerId(@PathVariable int customerId) {
        try {
            int policyCount = motorPolicyService.getPolicyCountByCustomerId(customerId);
            return ResponseEntity.ok(policyCount);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
 //   @ApiOperation(value = "Update motor policy")
    @PutMapping("/update/{customerNumber}/{policyNumber}")
    public ResponseEntity<String> updateMotorPolicy(@PathVariable int customerNumber, @PathVariable int policyNumber, @RequestBody MotorPolicyDto motorPolicyDto) {
        try {
            // Call the service method to update the motor policy
            motorPolicyService.updateMotorPolicy(customerNumber, policyNumber, motorPolicyDto);
            return ResponseEntity.ok("Motor policy updated successfully");
        } catch (Exception e) {
            // Handle any exceptions and return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update motor policy: " + e.getMessage());
        }
    }

  //  @ApiOperation(value = "Delete policies by customer number")
    @DeleteMapping("/delete/customer/{customerNumber}")
    public ResponseEntity<String> deletePoliciesByCustomer(@PathVariable int customerNumber) {
        try {
            // Call the service method to delete all policies associated with the customer
            motorPolicyService.deletePoliciesByCustomer(customerNumber);
            return ResponseEntity.ok("Policies deleted successfully for customer: " + customerNumber);
        } catch (Exception e) {
            // Handle any exceptions and return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete policies: " + e.getMessage());
        }
    }
}