package edu.ncsu.csc326.coffeemaker;

//import JUNIT 5
import org.junit.*;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import java.util.*;

/**
 * 
 * @author Emanuel Dellsén
 * @author Niklas Möller
 * @author Karl Westgårdh
 *
 *         Unit tests for Main Functionality
 */
public class InventoryTest{

	private Inventory inv;

	@BeforeEach
	protected void setUp() throws Exception {

		//inventory is initalized with 15 units of each property (milk, choc etc...)
		inv = new Inventory();

		super.setUp();
	}

	@Test
	public void testAddChocolate() {
		try {
			String increment = "1";
			inv.addChocolate(increment);

			int expected = 16;

			//Oracle: Check if chocolate value has increased by 1 (from 15)
			assertEquals(expected, inv.getChocolate());			
		} catch (InventoryException e) {
			fail("Exception should not be thrown.");
		}

	}

	@Test
	public void testAddCoffee() {

	}

	@Test
	public void testAddMilk() {

	}

	@Test
	public void testAddSugar() {

	}

	@Test
	public void testEnoughIngredients() {

	}

	@Test
	public void testUseIngredients() {

	}

	
	@AfterEach
	public void tearDown() throws Exception {
		cm = null;
	}

}
