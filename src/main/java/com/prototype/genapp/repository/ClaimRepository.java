package com.prototype.genapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.genapp.entity.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {

}
