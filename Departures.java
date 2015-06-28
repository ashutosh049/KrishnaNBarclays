package com.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.beans.Departure;

//singleton to add new and remove Departure from the Departures Array List
public class Departures
{
 private List<Departure> departuresList = Collections.synchronizedList(new ArrayList<Departure>());
 public static Departures departures = null;
 protected Departures()
 {
	 	departuresList.add(new Departure("UA10","A1","MIA","08:00"));
		departuresList.add(new Departure("UA11","A1","LAX","09:00"));
		departuresList.add(new Departure("UA12","A1","JFK","09:45"));
		departuresList.add(new Departure("UA13","A2","JFK","08:30"));
		departuresList.add(new Departure("UA14","A2","JFK","09:45"));
		departuresList.add(new Departure("UA15","A2","JFK","10:00"));
		departuresList.add(new Departure("UA16","A3","JFK","09:00"));
		departuresList.add(new Departure("UA17","A4","MHT","09:15"));
		departuresList.add(new Departure("UA18","A5","LAX","10:15"));
 }
 
 public static Departures getDeparturesObject()
 {
 	if (departures == null)
 	{
 		synchronized(Departures.class)
 		{
 			departures = new Departures();
 		}
 		
 	}
 	
 	return departures;
 }
 
 // add a new Departure whenever required
  public void addDepartureToList(Departure departure)
  {
    departuresList.add(departure);
  }
  public void clearDeparturesList()
  {
    departuresList.clear();
  }
   
   public List getDeparturesList()
   {
     return departuresList;
   }
   
   public void setDeparturesList(ArrayList departuresList)
   {
     this.departuresList = departuresList;
   }
   
   public boolean removeDeparture(Departure departure)
   {
	   boolean removed = false;
	   try{
		   departuresList.remove(departure);
		   removed = true;
	   }
	   catch(Exception e)
	   {
		   removed = false;
		   //TODO logging exception
	   }
	   
	   return removed;
	   
   }
 }
