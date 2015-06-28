package com.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Bag Data objects
public class EntryPoint
{
	private String gateID;
	private List<FlightGate> gatesTravelTimeList = null;
	
	public EntryPoint(String gateID)
	{
		this.gateID = gateID;
		this.gatesTravelTimeList = Collections.synchronizedList(new ArrayList<FlightGate>());
	}

	public String getGateID() {
		return gateID;
	}

	public void setGateID(String gateID) {
		this.gateID = gateID;
	}

	public List getGatesTravelTimeList() {
		return gatesTravelTimeList;
	}

	public void setGatesTravelTimeList(ArrayList gatesTravelTimeList) {
		this.gatesTravelTimeList = gatesTravelTimeList;
	}
	
	public boolean addEntryForGate(FlightGate flightGate)
	{
		if (!this.gatesTravelTimeList.contains(flightGate))
		{
			this.gatesTravelTimeList.add(flightGate);
			return true;
		}
		
		return false;
	}
	

}
