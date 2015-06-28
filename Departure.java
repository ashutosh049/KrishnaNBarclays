package com.beans;

public class Departure
{
	private String flightID;
	private String flightGate;
	private String destination;
	private String flightTime;
	
	public Departure(String flightID, String flightGate, String destination, String flightTime)
	{
			this.flightGate = flightGate;
			this.flightID = flightID;
			this.destination = destination;
			this.flightTime = flightTime;
	}
	
	public String getFlightID() {
		return flightID;
	}

	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}

	public String getFlightGate() {
		return flightGate;
	}

	public void setFlightGate(String flightGate) {
		this.flightGate = flightGate;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}  

}
