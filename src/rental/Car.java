package rental;

public class Car extends Vehicle {
	
	private int nbPassengers;

	  public Car(String brand, String model, int productionYear, float dailyRentalPrice, int nbPassengers) {
	    super(brand, model, productionYear, dailyRentalPrice);
	    this.nbPassengers = nbPassengers;
	  }

	  public int getNbPassengers(){
	    return this.nbPassengers;
	  }

	  public void setNbPassengers(int n){
	    this.nbPassengers = n;
	  }

	  public String toString() {
			return " marque : " + super.getBrand() + "annee : " + super.getProductionYear() + " prix : " + super.getDailyPrice() + " model : " + super.getModel() + " places : " + this.nbPassengers;
		}

}
