package com.prototype.genapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.genapp.entity.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer> {

	Policy findByPolicynumber(Long policynumber);

	int countByCustomernumber(int customerId);

	Optional<Policy> findByCustomernumberAndPolicynumber(int customerNumber, int policyNumber);

	List<Policy> findByCustomernumber(int customerNumber);

}
