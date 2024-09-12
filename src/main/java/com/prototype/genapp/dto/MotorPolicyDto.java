package com.prototype.genapp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MotorPolicyDto {
    private int policyNumber;
    private int customerNumber;
    private Date issueDate;
    private Date expiryDate;
    private String carMake;
    private String carModel;
    private int carValue;
    private String registration;
    private String carColour;
    private int cc;
    private Date manufactureDate;
    private int numberOfAccidents;
    private int policyPremium;
    
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMake() {
		// TODO Auto-generated method stub
		return null;
	}

}


