package com.javastackspaceit.dto;

import com.javastackspaceit.model.PassangerInfo;
import com.javastackspaceit.model.PaymentInfo;

public class PassangerBookingRequest {

	private PassangerInfo passangerInfo;
	private PaymentInfo paymentInfo;

	public PassangerInfo getPassangerInfo() {
		return passangerInfo;
	}

	public void setPassangerInfo(PassangerInfo passangerInfo) {
		this.passangerInfo = passangerInfo;
	}

	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	@Override
	public String toString() {
		return "PassangerBookingRequest [passangerInfo=" + passangerInfo + ", paymentInfo=" + paymentInfo + "]";
	}

}
