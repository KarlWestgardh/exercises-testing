package edu.ncsu.csc326.coffeemaker;

//import JUNIT 5
import org.junit.*;
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
public class RecipeBookTest {

	private CoffeeMaker cm;
	private Recipe r1;
	private Recipe r2;
	private Recipe[] recipeBook;
	HashSet<Recipe> h;

	@BeforeEach
	protected void setUp() throws Exception {
		cm = new CoffeeMaker();

		// Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");

		// set up access to recipe book
		recipeBook = cm.getRecipes();

		// create hashSet for test
		h = new HashSet<Recipe>();

		super.setUp();
	}

	@Test
	public void testAddRecipe() {

		// add recipe to recipe book
		cm.addRecipe(r1);

		// Oracle: check if recipe is contained within the recipe book
		assertTrue("Recipe is in the list", Arrays.asList(recipeBook).contains(r1));
	}

	@Test
	public void testCannotAddExistingRecipe() {

		// add recipe first
		cm.addRecipe(r1);

		// add same recipe again
		cm.addRecipe(r1);

		// Oracle: iterate over the recipe book for duplicates
		for (Recipe recipe : recipeBook) {
			// check if there is duplicate recipes by adding each recipe into the hashset
			// (does not allow duplicates)
			if (h.add(recipe) == false) {
				fail("Duplicate recipes exist in recipebook");
			}
		}

		// SUCCESS
	}

	@Test
	public void testDeleteRecipe() {

		// add recipe to recipe book
		cm.addRecipe(r1);

		// delete recipe from recipe book from first position
		cm.deleteRecipe(0);

		// Oracle: Check if recipe is removed from the list from the position specified
		assertNull("Recipe is not in the list", recipeBook[0]);
	}

	@Test
	public void testEditRecipe() {

		// add recipe to recipe book
		cm.addRecipe(r1);

		// create a new recipe (which will be the content that changes the first recipe)
		r2 = new Recipe();

		// create content of recipe
		String name = "x";
		String amtChocolate = "1";
		String amtCoffee = "2";
		String amtMilk = "2";
		String amtSugar = "2";
		String price = "10";

		// add content to recipe
		r2.setName(name);
		r2.setAmtChocolate(amtChocolate);
		r2.setAmtCoffee(amtCoffee);
		r2.setAmtMilk(amtMilk);
		r2.setAmtSugar(amtSugar);
		r2.setPrice(price);

		// edit recipe at first position
		cm.editRecipe(0, r2);

		// Oracle: check if the first recipe contains the new field value (fails together)
		assertAll(recipeBook[0], 
			() -> assertEquals(name, recipeBook[0].getName()),
			() -> assertEquals(amtChocolate, recipeBook[0].getAmtChocolate()),
			() -> assertEquals(amtChocolate, recipeBook[0].getAmtCoffee()),
			() -> assertEquals(amtChocolate, recipeBook[0].getAmtMilk()),
			() -> assertEquals(amtChocolate, recipeBook[0].getAmtSugar()),
			() -> assertEquals(amtChocolate, recipeBook[0].getPrice())
			);
	}

	@AfterEach
	public void tearDown() throws Exception {
		cm = null;
		r1 = null;
		r2 = null;
		recipeBook = null;
		h = null;
	}

}
