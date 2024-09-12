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
public class CustomerDto 
{
	private Long customernumber;
    private String firstname;
    private String lastname;
    private Date dateofbirth;
    private String housename;
    private String housenumber;
    private String postcode;
    private String phonehome;
    private String phonemobile;
    private String emailaddress;

}
