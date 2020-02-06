import exceptions.InventoryException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class InventoryTest {

    private Inventory inv;

    @BeforeEach
    void setUp() {

        //create a inventory
        inv = new Inventory();

    }

    @AfterEach
    void tearDown() {

        //reset inventory
        inv = null;
    }

    @Test
    void testAddChocolateToInventory() {

        String num = "1";

        //expected is 16 considering that inventory is initialized 15 units of chocolate
        int expected = 16;

        try {
            //add 1 unit of chocolate to inventory
            inv.addChocolate(num);

            //get the update number of chocolate of inventory
            int chocoInInventory = inv.getChocolate();

            //Oracle: check that 1 unit of choc has been added to inventory
            assertEquals(expected,chocoInInventory);

            //SUCCESS

        } catch (InventoryException e) {
            fail("Should not throw exception");
        }

    }

    @Test
    void testAddCoffeeToInventory() {

        String num = "1";

        //expected is 16 considering that inventory is initialized 15 units of chocolate
        int expected = 16;

        try {
            //add 1 unit of coffee to inventory
            inv.addCoffee(num);

            //get the update number of coffee of inventory
            int coffeeInInventory = inv.getCoffee();

            //Oracle: check that 1 unit of coffee has been added to inventory
            assertEquals(expected,coffeeInInventory);

            //SUCCESS

        } catch (InventoryException e) {
            fail("Should not throw exception");
        }
    }

    @Test
    void testAddMilkToInventory() {

        String num = "1";

        //expected is 16 considering that inventory is initialized 15 units of chocolate
        int expected = 16;

        try {
            //add 1 unit of milk to inventory
            inv.addMilk(num);

            //get the update number of milk of inventory
            int milkInInventory = inv.getMilk();

            //Oracle: check that 1 unit of milk has been added to inventory
            assertEquals(expected,milkInInventory);

            //SUCCESS

        } catch (InventoryException e) {
            fail("Should not throw exception");
        }
    }

    @Test
    void testAddSugarToInventory() {

        String num = "1";

        //expected is 16 considering that inventory is initialized 15 units of chocolate
        int expected = 16;

        try {
            //add 1 unit of sugar to inventory
            inv.addSugar(num);

            //get the update number of sugar of inventory
            int sugarInInventory = inv.getSugar();

            //Oracle: check that 1 unit of sugar has been added to inventory
            assertEquals(expected,sugarInInventory);

            //SUCCESS

        } catch (InventoryException e) {
            fail("Should not throw exception");
        }
    }

    @Test
    void enoughIngredients() {
    }

    @Test
    void useIngredients() {
    }
}