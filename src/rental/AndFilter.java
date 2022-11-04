package rental;

import java.util.*;

/**
 * An AndFilter performs the intersection of filters. It accepts a vehicle if
 * each of its filter accepts it.
 */
public class AndFilter implements VehicleFilter {

   private List<VehicleFilter> theFilters;

   /** creates an InterFilter with no filter */
   public AndFilter() {
	   this.theFilters = new ArrayList<VehicleFilter>();
   }
   
   /**
    * 
    * 
    * @return the filters
    */
   public List<VehicleFilter> getFilters(){
	     return this.theFilters;
	   }

   /**
    * adds a new filter
    * 
    * @param f the added filter
    */
   public void addFilter(VehicleFilter f) {
	   this.theFilters.add(f);
   }

   /**
    * Accept the vehicle if each of its filters accepts it
    * 
    * @see VehicleFilter#accept(Vehicle)
    */
   public boolean accept(Vehicle v) {
	   
	   boolean result;
	   int i = 0;
	   while (result=true && i < theFilters.size()) {
	        result = this.theFilters.get(i).accept(v);
	        i = i + 1;
	   }
	      return result;
   }
}
