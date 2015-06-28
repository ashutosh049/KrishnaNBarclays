package com.core.util;

import java.util.ArrayList;
import java.util.List;

import com.beans.Departure;
import com.beans.EntryPoint;
import com.beans.FlightGate;
import com.core.Departures;
import com.core.FlightGates;

public class TimeCalculator
{
	private String destinationGate;
	
	private String startGate;
	
	private String bagID;
	
	private int time;
	
	private String pathTaken;
	
	private boolean pathEstablished = false;
	
	
	public String getPathTaken() {
		return pathTaken;
	}


	public void setPathTaken(String pathTaken) {
		this.pathTaken = pathTaken;
	}


	public String getDestinationGate() {
		return destinationGate;
	}


	public void setDestinationGate(String destinationGate) {
		this.destinationGate = destinationGate;
	}


	public String getStartGate() {
		return startGate;
	}


	public void setStartGate(String startGate) {
		this.startGate = startGate;
	}


	public String getBagID() {
		return bagID;
	}


	public void setBagID(String bagID) {
		this.bagID = bagID;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}
	
	/**
	 * This function will return -1 if no path exists btwn the two points.
	 * @param bagID
	 * @param startGate
	 * @param destinationGate
	 * @return
	 */
	
	
	public int returnIfPathExists(String bagID, String startGate,String destinationGate)
	{
		this.destinationGate = destinationGate;
		this.bagID = bagID;
		this.startGate = startGate;
		
		System.out.println("For bag "+bagID+", Starting to find path betweenthe gates "+this.startGate+" and "+this.destinationGate);
		EntryPoint gatePointObject = FlightGates.getFlightGatesObject().getEntryPointObject(this.startGate);
		if (gatePointObject != null)
		{
			setPathTaken(this.startGate);
			String[] values = pathToOtherEntryPoints(gatePointObject);
			//System.out.println("Final time:"+time+":pathTaken:"+pathTaken);
			
			if (time == 0)
			{	
				System.out.println("For bag "+this.bagID+" no path could be found betweenthe gates "+this.startGate+" and "+this.destinationGate);
			}
			else
			{
				System.out.println("For bag "+this.bagID+", path betweenthe gates "+this.startGate+" and "+this.destinationGate +" is "+ pathTaken + "and it will take "+ this.time +"minutes");
				
				return time;
			}
		}
		else
		{
			System.out.println("No entry exists for Flight Gate "+this.startGate+" in the Conveyor System.");
			time = -1;
		}
		
		return time;
	}
	
	private String[] pathToOtherEntryPoints(EntryPoint gatePointObject)
	{
		String[] values = new String[]{"0","false"};
		
		if (gatePointObject!=null)
		{
			List<FlightGate> entries =  gatePointObject.getGatesTravelTimeList();
			
			if (!pathEstablished && entries != null)
			{
				//System.out.println(":entries:"+entries.size());
				for (int index=0;index < entries.size();index++) 
				{
					FlightGate flightGate = entries.get(index);
					//System.out.println("flightGate.getToGate():"+flightGate.getToGate()+":destinationGate:"+destinationGate);
					
					if (flightGate.getToGate().equalsIgnoreCase(destinationGate))
					{	
						time = time + flightGate.getTravelTime();
						values[0] = String.valueOf(time);
						values[1] = "true";
						pathEstablished = true;
						//System.out.println("pathEstablished:"+pathEstablished+":time:"+time+":pathTaken:"+pathTaken+":flightGate.getToGate():"+flightGate.getToGate());
						break;
					}
					
					
				}
			}
			
			if (!pathEstablished && entries!=null)
			{
				for (int index=0;!pathEstablished && index < entries.size();index++) 
				{
					FlightGate flightGate = entries.get(index);
					EntryPoint newGatePointObject = FlightGates.getFlightGatesObject().getEntryPointObject(flightGate.getToGate());
					time = time + flightGate.getTravelTime();
					setPathTaken(getPathTaken()+ ", " +flightGate.getToGate());
					//System.out.println("!pathEstablished:"+pathEstablished+":time:"+time+":pathTaken:"+pathTaken+":flightGate.getToGate():"+flightGate.getToGate());
					pathToOtherEntryPoints(newGatePointObject);
					
				}
			}
		}
		
		return values;
	}
	
	public String getDestinationPoint(String flightID,Departures departuresObj)
	{
		String destination = null;
		List<Departure> departureList = departuresObj.getDeparturesList();
		for (Departure departure: departureList)
		{
			if (departure.getFlightID().equalsIgnoreCase(flightID))
			{
				destination = departure.getFlightGate();
				//System.out.println("!pathEstablished:"+pathEstablished);
				break;
			}
		}
		
		if(destination == null)
		{
			System.out.println("!getDestinationPoint : No destination point found");
		}
		
		return destination;
		
	}

}
