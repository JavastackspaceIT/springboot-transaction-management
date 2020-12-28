package com.javastackspaceit.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javastackspaceit.dto.FlightBookingAcknowladgement;
import com.javastackspaceit.dto.PassangerBookingRequest;
import com.javastackspaceit.service.FlightBookingService;

@RestController
@RequestMapping(value = "api/flight/booking")
public class FlightBookingController {

	@Autowired
	private FlightBookingService flightBookingService;

	@PostMapping
	public FlightBookingAcknowladgement flightBooking(@RequestBody PassangerBookingRequest request) {

		FlightBookingAcknowladgement acknowladge = new FlightBookingAcknowladgement();
		acknowladge = flightBookingService.flightBook(request);
		return acknowladge;
	}
}
