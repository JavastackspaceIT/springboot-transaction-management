package com.javastackspaceit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javastackspaceit.dto.FlightBookingAcknowladgement;
import com.javastackspaceit.dto.PassangerBookingRequest;
import com.javastackspaceit.dto.PassangerTikcketBookingDetailsDTO;
import com.javastackspaceit.model.PassangerInfo;
import com.javastackspaceit.model.PaymentInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightBookingControllerTest {

	MockMvc mockMvc;
	@Autowired
	WebApplicationContext context;

	ObjectMapper objectMapper = new ObjectMapper();

	@Before
	public void setup() {
		System.err.print("setup");
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	//@Test
	void flightBookingTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		System.err.println(mockMvc.toString());
		PassangerInfo passangerInfo = new PassangerInfo(1, "rakesh", "kumar", "8507734789", "r@gmail.com", "noida",
				"patna", null, null);
		PaymentInfo paymentInfo = new PaymentInfo(1, "SBI", "NetBanking", "account1", 12d, passangerInfo);
		PassangerBookingRequest request = new PassangerBookingRequest();
		request.setPassangerInfo(passangerInfo);
		request.setPaymentInfo(paymentInfo);
		String URI = "/api/flight/booking";

		String jsonRequest = objectMapper.writeValueAsString(request);
		System.err.println(jsonRequest);
		MvcResult result = mockMvc.perform(post(URI).contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonRequest))
				.andReturn();

		String resultContent = result.getResponse().getContentAsString();
		System.err.println("resutl" + resultContent);
		FlightBookingAcknowladgement responseObject = objectMapper.readValue(resultContent,
				FlightBookingAcknowladgement.class);
		// Success
		assertEquals("Success", responseObject.getStatus());

	}
	@Test
	void updateFlightBookingTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		System.err.println(mockMvc.toString());
		PassangerInfo passangerInfo = new PassangerInfo(1, "rakesh", "singh", "9934036205", "r@gmail.com", "noida",
				"patna", null, null);
		PaymentInfo paymentInfo = new PaymentInfo(1, "SBI", "NetBanking", "account1", 12d, passangerInfo);
		PassangerBookingRequest request = new PassangerBookingRequest();
		request.setPassangerInfo(passangerInfo);
		request.setPaymentInfo(paymentInfo);
		String URI = "/api/flight/booking";

		String jsonRequest = objectMapper.writeValueAsString(request);
		System.err.println(jsonRequest);
		MvcResult result = mockMvc.perform(put(URI).contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonRequest))
				.andReturn();

		String resultContent = result.getResponse().getContentAsString();
		System.err.println("resutl" + resultContent);
		FlightBookingAcknowladgement responseObject = objectMapper.readValue(resultContent,
				FlightBookingAcknowladgement.class);
		// Success
		assertEquals("Success", responseObject.getStatus());

	}

	//@Test
	void paymentInfoWithPasssangerInfoTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		String URI = "/api/flight/booking";
		MvcResult result = mockMvc.perform(get(URI).contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		String response = result.getResponse().getContentAsString();
		// PassangerTikcketBookingDetailsDTO dto= objectMapper.readValue(response,
		// List<PassangerTikcketBookingDetailsDTO>);
		List<PassangerTikcketBookingDetailsDTO> passangerDto = new ArrayList<PassangerTikcketBookingDetailsDTO>();
		JSONArray jsonArray = new JSONArray(response);
		for (int i=0; i<jsonArray.length(); i++) {
			Object obj= jsonArray.get(i);
			PassangerTikcketBookingDetailsDTO dto=new PassangerTikcketBookingDetailsDTO();
			dto.setFirstName(jsonArray.getString(i));
			passangerDto.add(dto);
			//  data.setAppName(jsonArray.getString("appName"));
		}
		System.err.println(passangerDto);
		assertTrue(passangerDto.size()>0);
	}
	
	
	@Test
	void findPassangerDetailsByIdTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		String URI = "/api/flight/booking/findByEamilId/r@gmail.com";
		MvcResult result = mockMvc.perform(get(URI).contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		String response = result.getResponse().getContentAsString();
		PassangerTikcketBookingDetailsDTO ptbdDTO =objectMapper.readValue(response,PassangerTikcketBookingDetailsDTO.class );
		assertEquals("r@gmail.com", ptbdDTO.getEmailId());
		
	}
}
