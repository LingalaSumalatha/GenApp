package com.prototype.genapp.exceptions;

import java.util.Date;


public class ErrorDetails {

	private Date date;
	private String message;
	private String description;

	public ErrorDetails(Date date, String message, String description) {
		super();
		this.date = date;
		this.message = message;
		this.description = description;
	}

}
