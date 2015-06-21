public ConveyorSystem implements ConveyorInterface
{


}

//Bag Data objects
class Bag
{
  private bagNumber;
  private entryPoint;
  private flightID;
  
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


// Make this class singleton if required
class Bags
{
  
  private ArrayList<Bag> bagsList = new ArrayList<Bag>();
  
  // add a new bag whenever required
   public static void addBagToList(Bag bag)
   {
     bagsList.add(bag);
   }
    //add bags on instantiation
    public Bags()
    {
      bagsList.add(new Bag("0001","Concourse_A_Ticketing","UA12"));
      bagsList.add(new Bag("0002","A5","UA17"));
      bagsList.add(new Bag("0003","A2","UA10"));
      bagsList.add(new Bag("0004","A8","UA18"));
      bagsList.add(new Bag("0005","A7","ARRIVAL"));
    }
    
    public ArrayList getBagsList()
    {
      return bagsList;
    }
    
    public ArrayList setBagsList(ArrayList<String,String,String> bagsList)
    {
      this.bagsList = bagsList;
    }

}

class Departure
{
	private String flightID;
	private String flightGate;
	private String destination;
	private String flightTime;
	
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

class Departures
{
		
}
}
