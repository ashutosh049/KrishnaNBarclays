package com.beans;

//Bag Data objects
public class FlightGate
{	
	private String fromGate;
	private String toGate;
	private int travelTime;

	public FlightGate(String fromGate, String toGate, int travelTime)
	{
		this.fromGate = fromGate;
		this.toGate = toGate;
		this.travelTime = travelTime;
	}

	public String getFromGate() {
		return fromGate;
	}

	public void setFromGate(String fromGate) {
		this.fromGate = fromGate;
	}

	public String getToGate() {
		return toGate;
	}

	public void setToGate(String toGate) {
		this.toGate = toGate;
	}

	public int getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(int travelTime) {
		this.travelTime = travelTime;
	}

}
