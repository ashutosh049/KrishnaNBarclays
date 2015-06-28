package com.core;

import java.util.List;

import com.beans.Bag;
import com.core.util.TimeCalculator;

public class ConveyorSystem
{
	
	public static void main(String args[])
	{
	
		FlightGates flightGates = FlightGates.getFlightGatesObject();
		flightGates.addFlightGatesEntriesNow();
		
		Departures departures = Departures.getDeparturesObject();
		System.out.print("Departures List:"+departures.getDeparturesList().size());
		Bags bags = Bags.getBagsObject();
		System.out.print("Bags List:"+bags.getBagsList().size());
		
		TimeCalculator calculator = null;
		List<Bag> bagsList = bags.getBagsList(); 
		for (Bag bag:bagsList)
		{	
			calculator = new TimeCalculator();
			calculator.returnIfPathExists(bag.getBagNumber(), bag.getEntryPoint(), calculator.getDestinationPoint(bag.getFlightID(),departures));
		}
		
	}
	
}
