package rental;

public class SuspiciousRentalAgency extends RentalAgency {

	    public SuspiciousRentalAgency() {
	    	super();
	    }

	   /** 
	    * @param client the client
	    * @param v rented vehicle
	    * @return daily rental price
	    * @exception UnknownVehicleException if v is not a vehicle of this agency
	    * @exception IllegalStateException if client rents another vehicle or v is already rented 
	    */
	    public float rentVehicle(Client client, Vehicle v) throws UnknownVehicleException, IllegalStateException {
	      float result = super.rentVehicle(client, v);
	      if(client.getAge()<25){
	        return (result/10)*11;
	      }
	      else{
	        return result;
	      }
	    }

}
