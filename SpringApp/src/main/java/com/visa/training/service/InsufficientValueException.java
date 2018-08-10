package com.visa.training.service;

public class InsufficientValueException extends RuntimeException {

	public InsufficientValueException(String message) {
		super(message);
	}

}
