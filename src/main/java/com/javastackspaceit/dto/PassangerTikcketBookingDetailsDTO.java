package com.javastackspaceit.dto;

import java.io.Serializable;

public class PassangerTikcketBookingDetailsDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String emailId;
	private String accountName;
	private String amount;
	private String bankName;

	public PassangerTikcketBookingDetailsDTO() {
		// TODO Auto-generated constructor stub
	}
	public PassangerTikcketBookingDetailsDTO(String firstName, String lastName, String mobileNo, String emailId,
			String accountName, String amount, String bankName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.accountName = accountName;
		this.amount = amount;
		this.bankName = bankName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "PassangerTikcketBookingDetailsDTO [firstName=" + firstName + ", lastName=" + lastName + ", mobileNo="
				+ mobileNo + ", emailId=" + emailId + ", accountName=" + accountName + ", amount=" + amount
				+ ", bankName=" + bankName + "]";
	}

}
