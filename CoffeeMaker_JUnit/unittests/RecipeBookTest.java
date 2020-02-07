import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipeBookTest {

    private RecipeBook rb;
    private Recipe r;
    private Recipe r2;
    private Boolean expected;
    private Boolean actual;
    private HashSet<Recipe> hset;

    @BeforeEach
    void setUp() {

        // create a new recipebook
        rb = new RecipeBook();

        // create a new recipe
        r = new Recipe();
        r.setName("x");
        r.setAmtChocolate("1");
        r.setAmtCoffee("1");
        r.setAmtMilk("1");
        r.setAmtSugar("1");
        r.setPrice("1");

        // init a hashset for the tests
        hset = new HashSet<Recipe>();

    }

    @AfterEach
    void tearDown() {

        // reset variables
        rb = null;
        r = null;
        expected = null;
    }

    @Test
    void testAddRecipe() {

        // add recipe to recipeBook
        rb.addRecipe(r);

        // set expected value
        expected = true;

        // check if recipe has been added to recipebook
        assertEquals(expected, Arrays.asList(rb.getRecipes()).contains(r));

    }

    @Test
    void testAddRecipeWithExistingRecipe() {

        // add recipe to recipeBook
        rb.addRecipe(r);

        // add the same recipe again to recipeBook
        rb.addRecipe(r);

        for (Recipe recipe : rb.getRecipes()) {
            if (hset.add(recipe) == false) {
                fail("Found duplicates in recipebook");
            }
        }
        // SUCCESS
    }

    @Test
    void testAddRecipeWithMoreRecipesThanThereIsSpaceFor() {

        // add recipe to recipeBook
        rb.addRecipe(r);

        // change name of recipe
        r.setName("y");

        // add second recipe
        rb.addRecipe(r);

        // change name of recipe
        r.setName("z");

        // add third recipe
        rb.addRecipe(r);

        // change name of recipe
        r.setName("a");

        // add fourth recipe
        rb.addRecipe(r);

        // change name of recipe
        r.setName("b");

        // add a fifth recipe (should return false)
        actual = rb.addRecipe(r);

        // set expected value
        expected = false;

        // Oracle: check expected to actual
        assertEquals(expected, actual);

    }

    @Test
    void deleteRecipe() {

        // add recipe to recipeBook
        rb.addRecipe(r);

        // delete recipe from recipeBook at first position
        rb.deleteRecipe(0);

        // set expected value
        expected = false;

        // check if recipe still exists in recipebook
        assertEquals(expected, Arrays.asList(rb.getRecipes()).contains(r));

    }

    @Test
    void editRecipe() {

        //add recipe to recipeBook
        rb.addRecipe(r);

        //create a second recipe for the test
        r2 = new Recipe();
        r2.setName("z");
        r2.setAmtChocolate("2");
        r2.setAmtCoffee("2");
        r2.setAmtMilk("2");
        r2.setAmtSugar("2");
        r2.setPrice("2");

        //change the recipe of the first position (r) to the values of the new recipe (r2)
        rb.editRecipe(0, r2);

        //Oracle: check if field values is equal
        assertAll("Edit recipe",
            ()-> assertEquals(r2.getAmtChocolate(),rb.getRecipes[0].getAmtChocolate()),
            ()-> assertEquals(r2.getAmtCoffee(),rb.getRecipes[0].getAmtCoffee()),
            ()-> assertEquals(r2.getAmtMilk(),rb.getRecipes[0].getAmtMilk()),
            ()-> assertEquals(r2.getAmtSugar(),rb.getRecipes[0].getAmtSugar()),
            ()-> assertEquals(r2.getPrice(),rb.getRecipes[0].getPrice()),
            ()-> assertEquals(r2.getName(),rb.getRecipes[0].getName())
        );
        

    }
}