package com.javastackspaceit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.javastackspaceit.dto.FlightBookingAcknowladgement;
import com.javastackspaceit.dto.PassangerBookingRequest;
import com.javastackspaceit.dto.PassangerTikcketBookingDetailsDTO;
import com.javastackspaceit.exception.FlightBookingException;
import com.javastackspaceit.exception.FlightSearchPassangerDetailsException;
import com.javastackspaceit.model.PassangerInfo;
import com.javastackspaceit.model.PaymentInfo;
import com.javastackspaceit.repository.PassangerRepository;
import com.javastackspaceit.repository.PaymentRepository;
import com.javastackspaceit.util.PaymentVerfiyUtil;

@Service
public class FlightBookingService {

	@Autowired
	private PassangerRepository passangerRepository;
	@Autowired
	private PaymentRepository paymentRepository;

	private PaymentInfo paymentInfo;

	PassangerInfo passangerInfo;

	// @Transactional(isolation=Isolation.READ_COMMITTED,
	// propagation=Propagation.MANDATORY,readOnly=true)
	@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = false) // propagation=Propagation.MANDATORY,readOnly=true)
	public FlightBookingAcknowladgement flightBook(PassangerBookingRequest request) {
		System.err.println("flightBook method is called");
		FlightBookingAcknowladgement acknowladge = new FlightBookingAcknowladgement();

		passangerInfo = request.getPassangerInfo();
		passangerInfo = passangerRepository.save(passangerInfo);

		if (PaymentVerfiyUtil.getPaymentVerifyMap(request.getPaymentInfo().getAccountName(),
				request.getPaymentInfo().getAmount())) {
			paymentInfo = request.getPaymentInfo();
			paymentInfo.setPassangerInfo(passangerInfo);
			paymentRepository.save(paymentInfo);
		} else {
			throw new FlightBookingException("Invalide amount .");
		}

		acknowladge.setPnr(Math.random() + "");
		acknowladge.setStatus("Success");
		acknowladge.setTotalFare(paymentInfo.getAmount());
		acknowladge.setPassangerInfo(request.getPassangerInfo());
		System.err.println("flightBook method is called ending");
		return acknowladge;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = false) // propagation=Propagation.MANDATORY,readOnly=true)
	public FlightBookingAcknowladgement updateFlightBook(PassangerBookingRequest request) {
		FlightBookingAcknowladgement acknowladge = new FlightBookingAcknowladgement();

		passangerInfo = request.getPassangerInfo();
		/*
		 * Optional<PassangerInfo> passangerOption=
		 * passangerRepository.findById(passangerInfo.getId()); PassangerInfo pInfo =
		 * null; if(passangerOption.isPresent()) { pInfo= passangerOption.get();
		 * pInfo.setEmaliId(passangerInfo.getEmaliId()); }
		 */
		passangerInfo = passangerRepository.save(passangerInfo);

		if (PaymentVerfiyUtil.getPaymentVerifyMap(request.getPaymentInfo().getAccountName(),
				request.getPaymentInfo().getAmount())) {
			paymentInfo = request.getPaymentInfo();
			paymentInfo.setPassangerInfo(passangerInfo);
			paymentRepository.save(paymentInfo);
		} else {
			throw new FlightBookingException("Invalide amount .");
		}

		acknowladge.setPnr(Math.random() + "");
		acknowladge.setStatus("Success");
		acknowladge.setTotalFare(paymentInfo.getAmount());
		acknowladge.setPassangerInfo(request.getPassangerInfo());

		return acknowladge;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
	public List<PassangerTikcketBookingDetailsDTO> passangerPaymentInfo() {
		List<PassangerTikcketBookingDetailsDTO> passangerTicketDetails = new ArrayList<>();
		PassangerTikcketBookingDetailsDTO passangerDTO = null;
		List<Object[]> records = passangerRepository.listOfPassangerInf();

		for (Object[] row : records) {
			passangerDTO = new PassangerTikcketBookingDetailsDTO(row[0].toString(), row[1].toString(),
					row[2].toString(), row[3].toString(), row[4].toString(), row[5].toString(), row[6].toString());

			passangerTicketDetails.add(passangerDTO);
		}
		return passangerTicketDetails;
	}

	@Transactional(readOnly = true)
	public PassangerTikcketBookingDetailsDTO findPassangerDetailsByEmailId(Optional<String> passangerId) {
		String passId = null;
		if (passangerId.isPresent()) {
			passId = passangerId.get();
		} else {
			passId = "rakesh@gmail.com";
		}
		List<Object[]> array = passangerRepository.findPassangerByEmailId(passId);
		PassangerTikcketBookingDetailsDTO passangerDTO = null;
		if (array.size() != 0) {
			for (Object[] row : array) {
				passangerDTO = new PassangerTikcketBookingDetailsDTO(row[0].toString(), row[1].toString(),
						row[2].toString(), row[3].toString(), row[4].toString(), row[5].toString(), row[6].toString());

			}
		} else {
			throw new FlightSearchPassangerDetailsException("Passanger is not found of this " + passangerId);
		}
		for (Object[] row : array) {
			passangerDTO = new PassangerTikcketBookingDetailsDTO(row[0].toString(), row[1].toString(),
					row[2].toString(), row[3].toString(), row[4].toString(), row[5].toString(), row[6].toString());

		}
		return passangerDTO;
	}
}
