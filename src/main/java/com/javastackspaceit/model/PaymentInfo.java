package com.javastackspaceit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PaymentInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "bank_name")
	private String bankName;
	@Column(name = "payment_type")
	private String paymentType;
	@Column(name = "account_name")
	private String accountName;
	@Column(name = "amount")
	private Double amount;
	@Column(name = "passenger_info_id")
	private int passengerInfoId;

	
	public int getPassengerInfoId() {
		return passengerInfoId;
	}

	public void setPassengerInfoId(int passengerInfoId) {
		this.passengerInfoId = passengerInfoId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PaymentInfo [id=" + id + ", bankName=" + bankName + ", paymentType=" + paymentType + ", accountName="
				+ accountName + ", amount=" + amount + "]";
	}

}
