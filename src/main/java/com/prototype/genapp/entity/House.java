package com.prototype.genapp.entity;

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
@Getter
@Setter
@Entity
@Table(name = "House")
public class House {
	@NotNull
	@Id
	@Column(name = "policynumber")
	private int policynumber;// pk fk for policy table
	
	@Column(name = "propertytype" ,length = 15)
	private String propertytype;
	
	@Column(name = "propertyvalue")
	private int bedrooms;
	
	@Column(name = "value",length = 20)
	private int value;
	
	@Column(name = "housename",length = 4)
	private String housename;
	
	@Column(name = "postcode",length = 8)
	private String postcode;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "policynumber", referencedColumnName = "policynumber", insertable = false, updatable = false)
	private Policy policy;

}
