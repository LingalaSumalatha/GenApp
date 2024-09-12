package com.prototype.genapp.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {
	private String message;
	private int status;
	private long timestamp;
	
	 public ErrorResponse(String message, int status, long timestamp) {
	        this.message = message;
	        this.status = status;
	        this.timestamp = timestamp;
	    }

}
