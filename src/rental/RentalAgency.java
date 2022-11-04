package rental;

import java.util.*;

/** a rental vehicle agency, client can rent one vehicle at a time */
public class RentalAgency {
    // vehicles of this agency
    private List<Vehicle> theVehicles;

    // maps client to rented vehicle (at most one vehicle by client)
    private Map<Client,Vehicle> rentedVehicles;

    /**
    * builds an agency with no vehicles then none rented
    */
    public RentalAgency() {
    	this.theVehicles = new ArrayList<Vehicle>();
        this.rentedVehicles = new HashMap <Client,Vehicle>();

    }

    /** adds a vehicle to this agency
    * @param v the added vehicle
    */
    public void addVehicle(Vehicle v) {
      this.theVehicles.add(v);
    }


    /** removes vehicle v from this agency
     * @param v the vehicle to remove
     * @throws UnknownVehicleException if vehicle does not belong to this agency
     */
    public void removeVehicle(Vehicle v) throws UnknownVehicleException {
       if (!this.theVehicles.contains(v))
           throw new UnknownVehicleException("voiture inconnue");
       // else
       this.theVehicles.remove(v);
    }

    /** returns the list of vehicles managed by this agency
     * @return the list of vehicles managed by this agency
     */
    public List<Vehicle> getAllVehicles() {
       return this.theVehicles;
    }


    /** provides the list of the vehicles that is accepted by filter
    * @param filter the selection filter
    * @return  the list of the vehicles accepted by filter
    */
    public List<Vehicle> select(VehicleFilter filter) {

       List<Vehicle> result = new ArrayList<>();
       for(Vehicle v : this.theVehicles) {
          if (filter.accept(v)) {
             result.add(v);
          }
       }
       return result;

    }


    /** returns <em>true</em> iff client c is renting a vehicle
     * @param client the client for which we want to know it has rented a vehicle
    * @return <em>true</em> iff client c is renting a vehicle
    */
    public boolean hasRentedAVehicle(Client client) {
    	
    	if (rentedVehicles.containsKey(client)) {
            return true;
        }
        else {
        	return false;
        }
    }

    /** returns <em>true</em> iff vehicle v is rented
     * @param v the vehicle we want to check if it is rented
    * @return <em>true</em> iff vehicle v is rented
    */
    public boolean isRented(Vehicle v){
      
    	if (rentedVehicles.containsValue(v)) {
            return true;
        }
        else {
            return false;
        }
    }

   /** client rents a vehicle
    * @param client the renter
    * @param v the rented vehicle
    * @return the daily rental price for client for vehicle v
    * @exception UnknownVehicleException   if v is not a vehicle of this agency
    * @exception IllegalStateException if v is already rented or client rents already another vehicle
    */
    public float rentVehicle(Client client, Vehicle v) throws UnknownVehicleException, IllegalStateException {
    	
    	if (!theVehicles.contains(v)) {
            throw new UnknownVehicleException("le vehicule existe pas");
          }
        else if (isRented(v) || hasRentedAVehicle(client)) {
            throw new IllegalStateException("le vehicule ne peut pas être loué");
        }
        else {
            rentedVehicles.put(client,v);
            return v.getDailyPrice();
        }
    }


    /** the client returns a rented vehicle. Nothing happens if client didn't have rented a vehicle.
    * @param client the client who returns a vehicle
    */
    public void returnVehicle(Client client){
    	rentedVehicles.remove(client);
    }
    
    
    /** provides the collection of rented vehicles for this agency
    * @return collection of currently rented vehicles
    */
    public Collection<Vehicle> allRentedVehicles(){
    	Collection<Vehicle> result = new ArrayList<Vehicle>();
        for (Vehicle v : this.theVehicles) {
           if (isRented(v)) {
              result.add(v);
           }
        }
        return result;
    }
    
    /** displays the vehicles accepted by the filter
     * @param filter the selection filter
     */
     public void displaySelection(VehicleFilter filter) {
    	 
     	for(Vehicle v : select(filter)) {
             System.out.println(v);
         }
     }

}
