import exceptions.InventoryException;
import exceptions.RecipeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    private Recipe r;
    private String input;
    private int expectedNum;
    private int actualNum;
    private String expectedStr;
    private String actualStr;

    @BeforeEach
    void setUp() {

        //create a recipe
        r = new Recipe();


        try {
            r.setName("x");
            r.setPrice("1");
            r.setAmtCoffee("1");
            r.setAmtChocolate("1");
            r.setAmtMilk("1");
            r.setAmtSugar("1");

        } catch (RecipeException e) {
            e.getMessage();
        }

    }

    @AfterEach
    void tearDown() {

        //reset variables
        r = null;
        input = null;
        expectedNum = 0;
        actualNum = 0;
        expectedStr = null;
        actualStr = null;

    }

    @Test
    void testSetAmtChocolate() {

        //change input to valid value
        input = "1";

        //change amount of recipe
        try {
            r.setAmtChocolate(input);            
        } catch (RecipeException e) {
            e.getMessage();
        }

        //set value of expected
        expectedNum = 1;

        //get value of recipe
        actualNum = r.getAmtChocolate();

        //Oracle
        assertEquals(expectedNum,actualNum);
    }

    @Test
    void testSetAmtChocolateException() {

        //change input to invalid value
        input = "ABC";

        //Oracle: test if invalid makes method throw exception
        assertThrows(RecipeException.class, () -> r.setAmtChocolate(input));
    }

    @Test
    void testSetAmtSugar() {

        //change input to valid value
        input = "1";

        //change amount of recipe
        try {
            r.setAmtSugar(input);            
        } catch (RecipeException e) {
            e.getMessage();
        }

        //set value of expected
        expectedNum = 1;

        //get value of recipe
        actualNum = r.getAmtSugar();

        //Oracle
        assertEquals(expectedNum,actualNum);
    }

    @Test
    void testSetAmtSugarException() {

        //change input to invalid value
        input = "ABC";

        //Oracle: test if invalid makes method throw exception
        assertThrows(RecipeException.class, () -> r.setAmtSugar(input));
    }

    @Test
    void testSetAmtMilk() {

        //change input to valid value
        input = "1";

        //change amount of recipe
        try {
            r.setAmtMilk(input);            
        } catch (RecipeException e) {
            e.getMessage();
        }

        //set value of expected
        expectedNum = 1;

        //get value of recipe
        actualNum = r.getAmtMilk();

        //Oracle
        assertEquals(expectedNum,actualNum);
    }

    @Test
    void testSetAmtMilkException() {

        //change input to invalid value
        input = "ABC";

        //Oracle: test if invalid makes method throw exception
        assertThrows(RecipeException.class, () -> r.setAmtMilk(input));
    }
    @Test
    void testSetAmtCoffee() {

        //change input to valid value
        input = "1";

        //change amount of recipe
        try {
            r.setAmtCoffee(input);            
        } catch (RecipeException e) {
            e.getMessage();
        }

        //set value of expected
        expectedNum = 1;

        //get value of recipe
        actualNum = r.getAmtCoffee();

        //Oracle
        assertEquals(expectedNum,actualNum);
    }

    @Test
    void testSetAmtCoffeeException() {

        //change input to invalid value
        input = "ABC";

        //Oracle: test if invalid makes method throw exception
        assertThrows(RecipeException.class, () -> r.setAmtCoffee(input));
    }

    @Test
    void testSetPrice() {

        //change input to valid value
        input = "1";

        //change amount of recipe
        try {
            r.setPrice(input);            
        } catch (RecipeException e) {
            e.getMessage();
        }

        //set value of expected
        expectedNum = 1;

        //get value of recipe
        actualNum = r.getPrice();

        //Oracle
        assertEquals(expectedNum,actualNum);
    }

    @Test
    void testSetPriceException() {

        //change input to invalid value
        input = "ABC";

        //Oracle: test if invalid makes method throw exception
        assertThrows(RecipeException.class, () -> r.setPrice(input));
    }

    @Test
    void testSetName() {

        //change input to valid value
        input = "x";

        //change amount of recipe

            r.setName(input);


        //set value of expected
        expectedStr = "x";

        //get value of recipe
        actualStr = r.getName();

        //Oracle
        assertEquals(expectedStr,actualStr);
    }
}