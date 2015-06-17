public interface ConveyorInterface
{
  public int addTravelTimeBtwnNodes(String node1, String node2,int time);
  public void addDepartureList(int flightID, String flightGate, String destination,String flightTime);
  public void addBagList(String bagNumber, String entryPoint,String flightID);
  public int calculateTotalTravelTime();
}
