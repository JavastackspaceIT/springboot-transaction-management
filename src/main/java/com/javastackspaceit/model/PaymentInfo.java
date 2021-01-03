package com.javastackspaceit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment_info")
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
	@OneToOne
	@JoinColumn(name = "passanger_info_id")
	private PassangerInfo passangerInfo;

	public PassangerInfo getPassangerInfo() {
		return passangerInfo;
	}

	public void setPassangerInfo(PassangerInfo passangerInfo) {
		this.passangerInfo = passangerInfo;
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

	public PaymentInfo() {
		// Please don't remove this constructor
	}

	public PaymentInfo(int id, String bankName, String paymentType, String accountName, Double amount,
			PassangerInfo passangerInfo) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.paymentType = paymentType;
		this.accountName = accountName;
		this.amount = amount;
		this.passangerInfo = passangerInfo;
	}

	@Override
	public String toString() {
		return "PaymentInfo [id=" + id + ", bankName=" + bankName + ", paymentType=" + paymentType + ", accountName="
				+ accountName + ", amount=" + amount + "]";
	}

}
