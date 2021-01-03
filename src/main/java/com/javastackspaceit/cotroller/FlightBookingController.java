package com.javastackspaceit.cotroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javastackspaceit.dto.FlightBookingAcknowladgement;
import com.javastackspaceit.dto.PassangerBookingRequest;
import com.javastackspaceit.dto.PassangerTikcketBookingDetailsDTO;
import com.javastackspaceit.service.FlightBookingService;

@RestController
@RequestMapping(value = "api/flight/booking")
public class FlightBookingController {

	@Autowired
	private FlightBookingService flightBookingService;
	
	@PostMapping
	public FlightBookingAcknowladgement flightBooking(@RequestBody PassangerBookingRequest request) {

		FlightBookingAcknowladgement acknowladge = null;
		acknowladge = flightBookingService.flightBook(request);
		return acknowladge;
	}

	@GetMapping
	public List<PassangerTikcketBookingDetailsDTO> paymentInfoWithPasssangerInfo() {
		return flightBookingService.passangerPaymentInfo();
	}
	
	
	@PutMapping
	public FlightBookingAcknowladgement updateFlightBooking(@RequestBody PassangerBookingRequest request) {

		FlightBookingAcknowladgement acknowladge=null;
		acknowladge = flightBookingService.updateFlightBook(request);
		return acknowladge;
	}
	
	@GetMapping(value="/findByEamilId/{emailId}")
	public PassangerTikcketBookingDetailsDTO findPassangerDetailsById(@PathVariable(value="emailId") String emailId) {
		return flightBookingService.findPassangerDetailsByEmailId(Optional.of(emailId));
	}
}
