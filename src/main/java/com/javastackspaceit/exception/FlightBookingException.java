package com.javastackspaceit.exception;

public class FlightBookingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FlightBookingException(String msg) {
		super(msg);
	}
}
