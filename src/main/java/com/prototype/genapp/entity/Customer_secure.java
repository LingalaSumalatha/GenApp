package com.prototype.genapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
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
@Table(name = "customer_secure")
public class Customer_secure 
{
	@NotNull
	@Id
    @Column(name = "customernumber")
	private int customernumber;//pk & fk to customer
	
	@Column(name = "customerPass", length = 32)
	private String customerpassword;
	
	@Column(name = "state_indicator", length = 1)
	private String state_indicate;
	
	@Column(name = "pass_changes")
	private int pass_change;
	
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "customernumber")
	private Customer customer;
	
	
	

}
