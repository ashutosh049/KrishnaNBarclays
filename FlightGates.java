package com.core;

import java.util.HashMap;
import java.util.Map;

import com.beans.EntryPoint;
import com.beans.FlightGate;

//singleton to add new and remove FlightGate from the FlightGates Array List 
public class FlightGates
{

	private Map<String,EntryPoint> flightGatesMap = new HashMap<String,EntryPoint>();
	
	private static FlightGates flightGates = null;
	protected FlightGates()
	{
	  	
	}
	
	public static FlightGates getFlightGatesObject()
	{
		if (flightGates == null)
		{
			synchronized(FlightGates.class)
			{
				flightGates = new FlightGates();
			}
			
		}
		return flightGates;
		
	}
	
	public Map<String, EntryPoint> getFlightGatesMap() {
		return flightGatesMap;
	}
	
	public void setFlightGatesMap(Map<String, EntryPoint> flightGatesMap) {
		this.flightGatesMap = flightGatesMap;
	}
	 
	public boolean addEntryPoint(String gateID)
	{
		try{
			if(flightGatesMap.get(gateID) == null)
			{
				EntryPoint entryPoint = new EntryPoint(gateID);
				flightGatesMap.put(gateID, entryPoint);
				return true;
			}
		}
		catch(Exception e)
		{
			//TODO logging
		}
		
		return false;
	}
	
	public EntryPoint getEntryPointObject(String gateID)
	{
		return flightGatesMap.get(gateID);
	}
	
	public void addFlightGateEntries(String fromGate,String toGate ,int timeVal)
	{
		addEntryPoint(fromGate);
		getEntryPointObject(fromGate).addEntryForGate(new FlightGate(fromGate,toGate,timeVal));
		
		System.out.println("getEntryPointObject(fromGate)"+ fromGate +":"+getEntryPointObject(fromGate).getGatesTravelTimeList().size());
	}
	
	public void addFlightGatesEntriesNow()
	{
		addFlightGateEntries("Concourse_A_Ticketing","A5",5);
		addFlightGateEntries("A5","BaggageClaim",5);
		addFlightGateEntries("A5","A10",4);
		addFlightGateEntries("A5","A1",6);
		addFlightGateEntries("A1","A2",1);
		
		addFlightGateEntries("A2","A3",1);
		addFlightGateEntries("A3","A4",1);
		addFlightGateEntries("A10","A9",1);
		addFlightGateEntries("A9","A8",1);
		addFlightGateEntries("A8","A7",1);
		addFlightGateEntries("A7","A6",1);
		
	}

}
