package com.database.exceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException() {
		super("Resources Not found Exception!!");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
