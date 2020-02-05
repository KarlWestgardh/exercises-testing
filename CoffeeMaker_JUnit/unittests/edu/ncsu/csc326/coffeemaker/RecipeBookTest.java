package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import junit.framework.TestCase;

/**
 * 
 * @author Emanuel Dellsén
 * @author Niklas Möller
 * @author Karl Westgårdh
 *
 * Unit tests for Main Functionality
 */
public class RecipeBookTest extends TestCase {

	private CoffeeMaker cm;

	@BeforeEach
	public void setUp() {
		cm = new CoffeeMaker();

		

		super.setUp();		
	}
	
	@Test
	public void testAddRecipe() {
		try {
			// success
		} catch (InventoryException e) {
			// fail
		}
	}
	
	@AfterEach
	public void tearDown() {

	}

}
