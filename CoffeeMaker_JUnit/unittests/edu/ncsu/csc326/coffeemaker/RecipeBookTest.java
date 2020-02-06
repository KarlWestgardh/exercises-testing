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
 * Unit tests for Main Functionality
 */
public class RecipeBookTest extends TestCase {

	private CoffeeMaker cm;
	private Recipe r1;
	private Recipe[] recipeBook;
	HashSet<Recipe> h;

	@BeforeEach
	protected void setUp() throws Exception {
		cm = new CoffeeMaker();

		//Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");

		//set up access to recipe book
		recipeBook = cm.getRecipes();

		//create hashSet for test
		h = new HashSet<Recipe>(); 

		super.setUp();		
	}
	
	@Test
	public void testAddRecipe() {

		//add recipe to recipe book
		cm.addRecipe(r1);

		//check if recipe is contained within the recipe book
		assertTrue("Recipe is in the list",Arrays.asList(recipeBook).contains(r1));
	}

	@Test
	public void testCannotAddExistingRecipe() {

		//add recipe first
		cm.addRecipe(r1);

		//add same recipe again
		cm.addRecipe(r1);

		//iterate over the recipe book for duplicates
		for (Recipe recipe : recipeBook) {
			//check if there is duplicate recipes by adding each recipe into the hashset (does not allow duplicates)
			if(h.add(recipe) == false){
				fail("Duplicate recipes exist in recipebook");
			}
		}

		//SUCCESS
	}

	@Test
	public void testDeleteRecipe() {

		//add recipe to recipe book
		cm.addRecipe(r1);

		//delete recipe from recipe book from first position
		cm.deleteRecipe(0);

		//check if recipe is removed from the list from the position specified
		assertNull("Recipe is not in the list",recipeBook[0]);
	}
	
	@AfterEach
	public void tearDown() {
		cm = null;
		r1 = null;
	}

}
