package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;
import java.util.Arrays;
import java.util.*;

/**
 * 
 * @author Emanuel Dellsén
 * @author Niklas Möller
 * @author Karl Westgårdh
 *
 *         Unit tests for Main Functionality
 */
public class InventoryTest extends TestCase {

	private CoffeeMaker cm;

	@BeforeEach
	protected void setUp() throws Exception {
		cm = new CoffeeMaker();

		super.setUp();
	}

	@Test
	public void testAddChocolate() {

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
