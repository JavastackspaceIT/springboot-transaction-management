package com.javastackspaceit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.javastackspaceit.dto.PassangerBookingRequest;
import com.javastackspaceit.model.PassangerInfo;
import com.javastackspaceit.model.PaymentInfo;
import com.javastackspaceit.repository.PassangerRepository;
import com.javastackspaceit.repository.PaymentRepository;
import com.javastackspaceit.service.FlightBookingService;

@SpringBootTest
@RunWith(SpringRunner.class)
class springbootFlightBookingTest {

	@Autowired
	FlightBookingService service;

	@MockBean
	private PassangerRepository passangerRepository;

	@MockBean
	PaymentRepository paymentRepository;

	@Test
	void passangerPaymentInfoTest() {
		Object[] obj1 = { "Rakesh", "Kumar", "8507734789", "r@gmail.com", "acc1", 9090, "SBI" };
		Object[] obj2 = { "Rajesh", "Kumar", "850773400", "raj@gmail.com", "acc2", 100, "RBI" };
		List<Object[]> listObject = new ArrayList<Object[]>();
		listObject.add(obj1);
		listObject.add(obj2);
		when(passangerRepository.listOfPassangerInf()).thenReturn(listObject);
		assertEquals(2, service.passangerPaymentInfo().size());
	}

	@Test
	void findPassangerDetailsByEmailIdTest() {
		String emailId = "rakesh@gmail.com";
		Object[] userDeatil = { "Rakesh", "Kumar", "8507734789", "rakesh@gmail.com", "account1", 9090, "SBI" };
		List<Object[]> userDetailList = new ArrayList<>();
		userDetailList.add(userDeatil);
		when(passangerRepository.findPassangerByEmailId(emailId)).thenReturn(userDetailList);
		assertEquals(emailId, service.findPassangerDetailsByEmailId(Optional.of(emailId)).getEmailId().toString());
	}

	@Test
	void flightBookTest() {
		PassangerInfo passangerInfo = new PassangerInfo(1, "rakesh", "kumar", "8507734789", "r@gmail.com", "Patna", "New Delhi",  null, null);
		PaymentInfo paymentInfo = new PaymentInfo(2, "sbi","online", "account1", 1002d, passangerInfo);
		PassangerBookingRequest request = new PassangerBookingRequest();
		request.setPassangerInfo(passangerInfo);
		request.setPaymentInfo(paymentInfo);
		when(passangerRepository.save(passangerInfo)).thenReturn(passangerInfo);
		when(paymentRepository.save(paymentInfo)).thenReturn(paymentInfo);
		assertEquals("rakesh", service.flightBook(request).getPassangerInfo().getFirstName().toString());
		assertEquals("r@gmail.com", service.flightBook(request).getPassangerInfo().getEmaliId().toString());
	}
}
