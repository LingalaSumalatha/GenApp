package com.prototype.genapp.entity;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "commercial")
public class Commercial {
	@NotNull
	@Id
    @Column(name = "policynumber")
	private int policynumber;// pk fk for policy table
	
	@Column(name = "requestdate")
	private Timestamp requestdate;
	
	@Column(name = "startdate")
	private Date startdate;
	
	@Column(name = "renewaldate")
	private Date renewaldate;
	
	@Column(name = "address",length = 255)
	private String address;
	
	@Column(name = "zipcode",length = 8)
	private String zipcode;
	
	@Column(name = "latituden",length = 11)
	private String latituden;
	
	@Column(name = "longituden",length = 11)
	private String longituden;
	
	@Column(name = "customer",length = 255)
	private String customer;
	
	@Column(name = "propertytype",length = 255)
	private String propertytype;
	
	@Column(name = "fireperil")
	private int fireperil;
	
	@Column(name = "firepremium")
	private int firepremium;
	
	@Column(name = "crimeperil")
	private int crimeperil;
	
	@Column(name = "crimepremium")
	private int crimepremium;
	
	@Column(name = "floodperil")
	private int floodperil;
	
	@Column(name = "floodpremium")
	private int floodpremium;
	
	@Column(name = "weatherperil")
	private int weatherperil;
	
	@Column(name = "weatherpremium")
	private int weatherpremium;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "rejectionreason",length = 255)
	private String rejectionreason;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "policynumber", referencedColumnName = "policynumber", insertable = false, updatable = false)
	private Policy policy;
}
