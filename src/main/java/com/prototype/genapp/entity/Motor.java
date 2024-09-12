package com.prototype.genapp.entity;

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
@Getter
@Setter
@Entity
@Table(name = "motor")
public class Motor {
	@NotNull
	@Id
	@Column(name = "policynumber")
	private int policynumber;// pk fk for policy table
	
	@Column(name = "make",length = 15)
	private String make;
	
	@Column(name = "model",length = 15)
	private String model;
	
	@Column(name = "value")
	private int value;
	
	@Column(name = "regnumber", length = 7)
    private String regnumber;
	
	@Column(name = "colour",length = 8)
	private String colour;
	
	@Column(name = "cc")
	private int cc;
	
	@Column(name = "yearofmanufacture")
	private Date yearofmanufacture;
	
	@Column(name = "premium")
	private int premium;
	
	@Column(name = "accidents")
	private int accidents;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "policynumber", referencedColumnName = "policynumber", insertable = false, updatable = false)
	private Policy policy;

	   public void setRegistration(String registration) {
	        this.regnumber = registration;
	    }

	    public String getRegistration() {
	        return this.regnumber;
	    }

}
