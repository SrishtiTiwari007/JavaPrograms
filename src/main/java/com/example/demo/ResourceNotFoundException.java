package com.example.demo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID=1L;
	public ResourceNotFoundException() {
		super();
			// TODO Auto-generated constructor stub
		}
public ResourceNotFoundException(String message) {
	super(message);
		// TODO Auto-generated constructor stub
	}
public ResourceNotFoundException(String message,Throwable cause) {
	super(message,cause);
		// TODO Auto-generated constructor stub
	}

	
}
