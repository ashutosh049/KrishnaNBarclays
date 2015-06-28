package com.beans;

//Bag Data objects
public class Bag
{
	private String bagNumber;
	private String entryPoint;
	private String flightID;

	public Bag(String bagNumber, String entryPoint, String flightID)
	{
		this.bagNumber = bagNumber;
		this.entryPoint = entryPoint;
		this.flightID = flightID;
	}

	public String getBagNumber() {
		return bagNumber;
	}

	public void setBagNumber(String bagNumber) {
		this.bagNumber = bagNumber;
	}

	public String getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(String entryPoint) {
		this.entryPoint = entryPoint;
	}

	public String getFlightID() {
		return flightID;
	}

	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}

}
