package com.prototype.genapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.genapp.entity.Ksdspoly;

@Repository
public interface KsdspolyRepository extends JpaRepository<Ksdspoly, Integer> {

}
