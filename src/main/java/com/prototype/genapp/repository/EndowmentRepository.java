package com.prototype.genapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.genapp.entity.Endowment;

@Repository
public interface EndowmentRepository extends JpaRepository<Endowment, Integer> {

}
