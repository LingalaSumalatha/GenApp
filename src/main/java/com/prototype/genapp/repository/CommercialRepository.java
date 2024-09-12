package com.prototype.genapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.genapp.entity.Commercial;


@Repository
public interface CommercialRepository extends JpaRepository<Commercial, Integer> {

}
