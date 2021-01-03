package com.javastackspaceit.util;

import java.util.HashMap;
import java.util.Map;

public class PaymentVerfiyUtil {

	private static Map<String, Double> paymentVerifyMap = new HashMap<String, Double>();

	static {
		paymentVerifyMap.put("account1", 90000d);
		paymentVerifyMap.put("account2", 12000d);
		paymentVerifyMap.put("account3", 10000d);
	}

	public static boolean getPaymentVerifyMap(String accountType, Double amount) {

		Double mapAmount = paymentVerifyMap.get(accountType);
		if(amount > mapAmount) {
			return false;
		} else {
			return true;
		}
	}

}
