package rental;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class RentalAgencyTest {

	private RentalAgency agency;
	private Vehicle v1;
	private Vehicle v2;
	private Client client1;
	private Client client2;
	private Client client3;
	private VehicleFilter f1;

	@Before
	public void before() {

		this.agency = new RentalAgency();
		this.v1 = new Vehicle("brand1", "model1", 1990, 100);
		this.v2 = new Vehicle("brand2", "model2", 2000, 200);
		this.client1 = new Client("Patricia", 21);
		this.client2 = new Client("Sarah", 20);
		this.client3 = new Client("Elsa", 30);
		this.f1 = new BrandFilter("brand1");
	}

	@Test
	public void addVehicleTest() {
		assertEquals(0, this.agency.getAllVehicles().size());
		this.agency.addVehicle(this.v1);
		assertEquals(1, this.agency.getAllVehicles().size());
	}

	@Test
	public void removeVehicleTest() throws UnknownVehicleException {
		this.agency.addVehicle(this.v1);
		assertEquals(1, this.agency.getAllVehicles().size());
		this.agency.removeVehicle(this.v1);
		assertEquals(0, this.agency.getAllVehicles().size());
	}

	@Test(expected = UnknownVehicleException.class)
	public void removeVehiclethrowsexceptionTest() throws UnknownVehicleException {
		this.agency.removeVehicle(this.v1);
	}

	@Test
	public void getAllVehiclesTest() {
		assertEquals(0 , this.agency.getAllVehicles().size());
		this.agency.addVehicle(this.v1);
		assertEquals(1 , this.agency.getAllVehicles().size());
		this.agency.addVehicle(this.v2);
		assertEquals(2 , this.agency.getAllVehicles().size());
	}

	@Test
	public void selectTest() {
		this.agency.addVehicle(this.v1);
		this.agency.addVehicle(this.v2);
		assertEquals(1, this.agency.select(f1).size());
	}

	@Test
	public void hasRentedAVehicleTest() throws IllegalStateException, UnknownVehicleException {
		this.agency.addVehicle(this.v1);
		assertEquals(100.0, this.agency.rentVehicle(this.client1, this.v1), 0.0001);
		assertTrue(this.agency.hasRentedAVehicle(this.client1));
		assertFalse(this.agency.hasRentedAVehicle(this.client3));
	}

	@Test
	public void isRentedTest() throws IllegalStateException, UnknownVehicleException {
		this.agency.addVehicle(this.v1);
		this.agency.addVehicle(this.v2);
		assertEquals(100.0, this.agency.rentVehicle(this.client1, this.v1), 0.0001);
		assertTrue(this.agency.isRented(this.v1));
		assertFalse(this.agency.isRented(this.v2));
	}

	@Test
	public void twoClientObjectsWithSameNameCorrespondsToSameClient()
			throws IllegalStateException, UnknownVehicleException {
		this.agency.addVehicle(this.v1);
		assertEquals(100.0, this.agency.rentVehicle(this.client1, this.v1), 0.0001);
		assertTrue(this.agency.hasRentedAVehicle(this.client1));
		// then test should succeed
		assertTrue(this.agency.hasRentedAVehicle(this.client2));
	}

	@Test(expected = UnknownVehicleException.class)
	public void rentVehiclethrowsexceptionUnknownVehicleException() throws IllegalStateException, UnknownVehicleException {
		this.agency.addVehicle(this.v1);
		this.agency.rentVehicle(this.client1, this.v2);
	}

	@Test(expected = IllegalStateException.class)
	public void rentVehiclethrowsexceptionIllegalStateException() throws IllegalStateException, UnknownVehicleException {
		this.agency.addVehicle(this.v1);
		assertEquals(100.0, this.agency.rentVehicle(this.client1, this.v1), 0.0001);
		this.agency.rentVehicle(this.client3, this.v1);
	}

	@Test
	public void returnVehicleTest() throws IllegalStateException, UnknownVehicleException {
		this.agency.addVehicle(this.v1);
		assertEquals(100.0, this.agency.rentVehicle(this.client1, this.v1), 0.0001);
		assertTrue(this.agency.isRented(this.v1));
		this.agency.returnVehicle(client1);
		assertFalse(this.agency.isRented(this.v1));
	}

	@Test
	public void allRentedVehiclesTest() throws IllegalStateException, UnknownVehicleException {
		this.agency.addVehicle(this.v1);
		assertEquals(100.0, this.agency.rentVehicle(this.client1, this.v1), 0.0001);
		assertEquals(1, this.agency.allRentedVehicles().size());
		this.agency.addVehicle(this.v2);
		assertEquals(200.0, this.agency.rentVehicle(this.client3, this.v2), 0.0001);
		assertEquals(2, this.agency.allRentedVehicles().size());
	}

	// ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(rental.RentalAgencyTest.class);
	}

}
