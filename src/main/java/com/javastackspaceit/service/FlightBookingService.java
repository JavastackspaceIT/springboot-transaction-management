package com.javastackspaceit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javastackspaceit.dto.FlightBookingAcknowladgement;
import com.javastackspaceit.dto.PassangerBookingRequest;
import com.javastackspaceit.exception.FlightBookingException;
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

	PaymentInfo paymentInfo;

	PassangerInfo passangerInfo;
	//@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.MANDATORY,readOnly=true)
	@Transactional(isolation=Isolation.READ_COMMITTED,readOnly=false) //propagation=Propagation.MANDATORY,readOnly=true)
	public FlightBookingAcknowladgement flightBook(PassangerBookingRequest request) {

		FlightBookingAcknowladgement acknowladge = new FlightBookingAcknowladgement();

		passangerInfo = request.getPassangerInfo();
		passangerInfo = passangerRepository.save(passangerInfo);

		if (PaymentVerfiyUtil.getPaymentVerifyMap(request.getPaymentInfo().getAccountName(),
				request.getPaymentInfo().getAmount())) {
			paymentInfo = request.getPaymentInfo();
			paymentInfo.setPassengerInfoId(passangerInfo.getId());
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
}
