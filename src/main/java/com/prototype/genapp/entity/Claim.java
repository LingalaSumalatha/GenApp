package com.prototype.genapp.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "claim")
public class Claim {
	//@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "claimnumber")
	private int claimnumber;// pk
	
	//@NotNull
	@Column(name = "policynumber",nullable = false)
	private int policynumber;// fk for the policy table
	
	@Column(name = "claimdate")
	private Date claimdate;
	
	@Column(name = "paid")
	private int paid;
	
	@Column(name = "value")
	private int value;
	
	@Column(name = "cause",length = 255)
	private String cause;
	
	@Column(name = "observations",length = 255)
	private String observations;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "policynumber", referencedColumnName = "policynumber", insertable = false, updatable = false)
	private Policy policy;

}
