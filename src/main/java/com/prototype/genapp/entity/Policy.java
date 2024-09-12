package com.prototype.genapp.entity;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "policy")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policynumber")	
    private int policynumber;

    @Column(name = "customernumber", nullable = false)
    private int customernumber;

    @Column(name = "issuedate")
    private Date issuedate;

    @Column(name = "expirydate")
    private Date expirydate;

    @Column(name = "policytype", length = 10)
    private String policytype;

    @Column(name = "lastchanged")
    private Date lastchanged; // Allow null values

    @Column(name = "brokerid")
    private int brokerid;

    @Column(name = "brokersreference", length = 10)
    private String brokersreference;

    @Column(name = "payment")
    private int payment;

    @Column(name = "commission")
    private int commission;

    @Column(name = "policyperium")
    private int policyperium;

    @ManyToOne
    @JoinColumn(name = "customernumber", referencedColumnName = "customernumber", insertable = false, updatable = false)
    private Customer customer;

    public Policy(int customernumber, Date issuedate, Date expirydate, String policytype, int brokerid, String brokersreference, int payment, int commission) {
        this.customernumber = customernumber;
        this.issuedate = issuedate;
        this.expirydate = expirydate;
        this.policytype = policytype;
        this.brokerid = brokerid;
        this.brokersreference = brokersreference;
        this.payment = payment;
        this.commission = commission;
    }

	public void setCarMake(String make) {
		// TODO Auto-generated method stub
		
	}

	public void setCarModel(String model) {
		// TODO Auto-generated method stub
		
	}
}
