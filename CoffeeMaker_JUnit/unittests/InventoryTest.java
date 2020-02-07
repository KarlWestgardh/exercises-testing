import exceptions.InventoryException;
import exceptions.RecipeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class InventoryTest {

    private Inventory inv;
    private String num;
    private Recipe r;
    private int expectedNum;
    private boolean expectedBool;
    private boolean actualBool;

    @BeforeEach
    void setUp() {

        //create a inventory
        inv = new Inventory();

        //initalization of a variable for test
        num = "1";

        //create a recipe for testing
        r = new Recipe();
        try {
            r.setName("x");
            r.setPrice("1");
        } catch (RecipeException e) {
            e.getMessage();
        }

        //initalization of expectedNum
        expectedNum = 16;

    }

    @AfterEach
    void tearDown() {

        //reset variables
        inv = null;
        r = null;
        expectedNum = 0;
        num = null;

    }

    @Test
    void testAddChocolateToInventory() {

        try {
            //add 1 unit of chocolate to inventory
            inv.addChocolate(num);

            //get the update number of chocolate of inventory
            int chocoInInventory = inv.getChocolate();

            //Oracle: check that 1 unit of choc has been added to inventory
            assertEquals(expectedNum,chocoInInventory);

            //SUCCESS

        } catch (InventoryException e) {
            fail("Should not throw exception");
        }

    }

    @Test
    void testAddCoffeeToInventory() {

        try {
            //add 1 unit of coffee to inventory
            inv.addCoffee(num);

            //get the update number of coffee of inventory
            int coffeeInInventory = inv.getCoffee();

            //Oracle: check that 1 unit of coffee has been added to inventory
            assertEquals(expectedNum,coffeeInInventory);

            //SUCCESS

        } catch (InventoryException e) {
            fail("Should not throw exception");
        }
    }

    @Test
    void testAddMilkToInventory() {

        try {
            //add 1 unit of milk to inventory
            inv.addMilk(num);

            //get the update number of milk of inventory
            int milkInInventory = inv.getMilk();

            //Oracle: check that 1 unit of milk has been added to inventory
            assertEquals(expectedNum,milkInInventory);

            //SUCCESS

        } catch (InventoryException e) {
            fail("Should not throw exception");
        }
    }

    @Test
    void testAddSugarToInventory() {        

        try {
            //add 1 unit of sugar to inventory
            inv.addSugar(num);

            //get the update number of sugar of inventory
            int sugarInInventory = inv.getSugar();

            //Oracle: check that 1 unit of sugar has been added to inventory
            assertEquals(expectedNum,sugarInInventory);

            //SUCCESS

        } catch (InventoryException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testEnoughIngredientsWithInputUnderThreshold() {

        //assign values to recipe under threshold (15 per ingredient)
        try {
            r.setAmtChocolate("10");
            r.setAmtCoffee("10");
            r.setAmtMilk("10");
            r.setAmtSugar("10");
        } catch (RecipeException e) {
            e.getMessage();
        }
        //expect the function to return true considering under threshold (15 > 10)
        expectedBool = true;
        try {
            //check if inventory has enough ingredients from recipe r
            actualBool = inv.enoughIngredients(r);

            //Oracle: Validate expected value with actual value
            assertEquals(expectedBool, actualBool);
            
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testEnoughIngredientsWithInputOverThreshold() {

            //assign most values to recipe under threshold (15 per ingredient)
        try {
            r.setAmtChocolate("20");
            r.setAmtCoffee("10");
            r.setAmtMilk("20");
            r.setAmtSugar("10");
        } catch (RecipeException e) {
            e.getMessage();
        }

    
            //expect the function to return false considering over threshold (15 < 20)
            expectedBool = false;
            
            try {
                //check if inventory has enough ingredients from recipe r
                actualBool = inv.enoughIngredients(r);
    
                //Oracle: Validate expected value with actual value
                assertEquals(expectedBool, actualBool);
                
            } catch (Exception e) {
                fail(e.getMessage());
            }
    }

    @Test
    void testUseIngredients() {

        //assign most values to recipe under threshold (15 per ingredient)

        try {
            r.setAmtChocolate("1");
            r.setAmtCoffee("1");
            r.setAmtMilk("1");
            r.setAmtSugar("1");
        } catch (RecipeException e) {
            e.getMessage();
        }

        //expectedNum is 14 since function decreases inventory by recipe field values
        expectedNum = 14;
        
        try {
            //call to function useIngredients
            inv.useIngredients(r);

            //Oracle: Validate expected value with actual value, field by field
            assertAll("Ingredients",
                ()->assertEquals(expectedNum,inv.getChocolate()),
                ()->assertEquals(expectedNum,inv.getCoffee()),
                ()->assertEquals(expectedNum,inv.getMilk()),
                ()->assertEquals(expectedNum,inv.getSugar())
            );
            
        } catch (Exception e) {
            fail(e.getMessage());

        }
    }
}