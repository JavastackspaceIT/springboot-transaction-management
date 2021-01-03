package com.javastackspaceit.cotroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.javastackspaceit.exception.FlightBookingException;
import com.javastackspaceit.exception.FlightSearchPassangerDetailsException;
import com.javastackspaceit.response.FlightTicketBookingGloablErrorMessage;

@ControllerAdvice
public class FlightBookingControllerAdvise {

	@ExceptionHandler(FlightBookingException.class)
	public ResponseEntity<FlightTicketBookingGloablErrorMessage> flightTicketBookingHandler(FlightBookingException flightBookingException){
		
		FlightTicketBookingGloablErrorMessage message=new FlightTicketBookingGloablErrorMessage();
		message.setErrorMessage(flightBookingException.getMessage());
		message.setErrorResson(HttpStatus.EXPECTATION_FAILED.toString());
		
		return new ResponseEntity<>(message, HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(FlightSearchPassangerDetailsException.class)
	public ResponseEntity<FlightTicketBookingGloablErrorMessage> passangerSearchException(FlightSearchPassangerDetailsException exception){
		FlightTicketBookingGloablErrorMessage message=new FlightTicketBookingGloablErrorMessage();
		message.setErrorMessage(exception.getMessage());
		message.setErrorResson(HttpStatus.NO_CONTENT.toString());
		return new ResponseEntity<FlightTicketBookingGloablErrorMessage>(message, HttpStatus.NO_CONTENT);
		
	}
}
