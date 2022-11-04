package rental;
import java.util.*;

public class MainAgency {

	public static void main(String[] args) {
		RentalAgency agency = new RentalAgency();

	 	Vehicle v1 = new Vehicle("brand1", "model1", 2021, 100);
	    Vehicle v2 = new Car("brand2", "model2", 2022, 300, 10);
	    Vehicle v3 = new MotorBike("brand3", "model3", 2023, 200, 300);

	 	Client client1 = new Client("Patricia", 21);
	 	Client client2 = new Client("sarah", 20);

	 	VehicleFilter f1 = new BrandFilter("brand1");
	    VehicleFilter f2 = new MaxPriceFilter(500);

	    AndFilter f = new AndFilter();

	    agency.addVehicle(v1);
	    agency.addVehicle(v2);
	    agency.addVehicle(v3);

	    f.addFilter(f1);
	    f.addFilter(f2);
		
	    System.out.println("Liste des vehicules : "+ agency.getAllVehicles());
	    System.out.println("\n");
	    System.out.println("Vehicules brand1 dont le prix un inferieur a 500 :");
	    agency.displaySelection(f);
	    System.out.println("\n");
	    try{
	        System.out.println(client1.getName()+" a loue un vehicule de "+agency.rentVehicle(client1, v1)+ " euros \n");
	        System.out.println(client2.getName()+" a loue un vehicule de "+agency.rentVehicle(client2, v2)+ " euros \n");
	        System.out.println("Vehicules loues : "+agency.allRentedVehicles()+"\n");
	      }
	      catch(IllegalStateException e){
	      }
	      catch(UnknownVehicleException e){
	      }
	      
	      System.out.println("Retour du vehicules : "+v1);
	      agency.returnVehicle(client1);
	      System.out.println("Les véhicules loué sont : "+agency.allRentedVehicles()+"\n");

		}
}
