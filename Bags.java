package com.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.beans.Bag;

//singleton to add new and remove Bags from the Bags Array List 
class Bags
{

private List<Bag> bagsList = Collections.synchronizedList(new ArrayList<Bag>());

private static Bags bags = null;
protected Bags()
{
	bagsList.add(new Bag("0001","Concourse_A_Ticketing","UA12"));
  	bagsList.add(new Bag("0002","A5","UA17"));
  	bagsList.add(new Bag("0003","A2","UA10"));
  	bagsList.add(new Bag("0004","A8","UA18"));
  	bagsList.add(new Bag("0005","A7","ARRIVAL"));
}

public static Bags getBagsObject()
{
	if (bags == null)
	{
		synchronized(Bags.class)
		{
			bags = new Bags();
		}
		
	}
	return bags;
	
}
// To add a new bag 
public void addBagToList(Bag bag)
{
  bagsList.add(bag);
}

 //get List of all bags 
 public List getBagsList()
 {
   return bagsList;
 }
 
 public void setBagsList(ArrayList bagsList)
 {
   this.bagsList = bagsList;
 }
 

}
