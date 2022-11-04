package rental;

public class MotorBike extends Vehicle {
	private int cylindree;

	public MotorBike(String brand, String model, int productionYear, float dailyRentalPrice, int cylindree) {
	    super(brand, model, productionYear, dailyRentalPrice);
	    this.cylindree = cylindree;
	  }

	  public int getNbCylindree(){
	    return this.cylindree;
	  }

	  public void setNbCylindree(int c){
	    this.cylindree = c;
	  }

	  public String toString() {
			return " marque : " + super.getBrand() + "annee : " + super.getProductionYear() + " prix : " + super.getDailyPrice() + " model : " + super.getModel() + " cylindree : " + this.cylindree;
		}
}
