package com.javastackspaceit.response;

public class FlightTicketBookingGloablErrorMessage {

	private String errorMessage;
	private String errorResson;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorResson() {
		return errorResson;
	}

	public void setErrorResson(String errorResson) {
		this.errorResson = errorResson;
	}

	@Override
	public String toString() {
		return "TicketBookingGloablErrorMessage [errorMessage=" + errorMessage + ", errorResson=" + errorResson + "]";
	}

}
