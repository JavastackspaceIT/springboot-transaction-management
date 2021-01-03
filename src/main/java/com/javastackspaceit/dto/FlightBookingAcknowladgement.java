package com.javastackspaceit.dto;

import com.javastackspaceit.model.PassangerInfo;

public class FlightBookingAcknowladgement {

	private String status;
	private double totalFare;
	private String pnr;
	private PassangerInfo passangerInfo;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public PassangerInfo getPassangerInfo() {
		return passangerInfo;
	}

	public void setPassangerInfo(PassangerInfo passangerInfo) {
		this.passangerInfo = passangerInfo;
	}

	@Override
	public String toString() {
		return "FlightBookingAcknowladgement [status=" + status + ", totalFare=" + totalFare + ", pnr=" + pnr
				+ ", passangerInfo=" + passangerInfo + "]";
	}

}
