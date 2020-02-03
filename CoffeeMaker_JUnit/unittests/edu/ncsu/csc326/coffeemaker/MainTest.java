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
public class MainTest extends TestCase {

	protected void setUp() throws Exception {
		
	}
	
	public void testAddInventory() {
		try {
			// success
		} catch (InventoryException e) {
			// fail
		}
	}
	
	public void testAddInventoryException() {
		try {
			//fail
		} catch (InventoryException e) {
			//success
		}
	}

}
