package com.example.Exception;

public class ResourceNotFoundException  extends RuntimeException{

	public ResourceNotFoundException() {
		super();
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(String string, int productid) {
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFoundException(String string, String valueOf) {
		// TODO Auto-generated constructor stub
	}
}
