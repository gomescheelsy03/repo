/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: The 'Coffee' class extends `Beverage` to calculate the price of coffee, accounting for optional extra shots and syrup.
 * Due: 12/04/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Chelsy Gomes________
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeTestStudent {
    private Coffee coffee;

    @BeforeEach
    void setUp() {
        coffee = new Coffee("Espresso", Size.SMALL, true, true);
    }

    @Test
    void testCoffeeConstructor() {
        assertNotNull(coffee);
        assertEquals("Espresso", coffee.getBevName());
        assertEquals(Size.SMALL, coffee.getSize());
        assertTrue(coffee.getExtraShot());
        assertTrue(coffee.getExtraSyrup());
    }

    @Test
    void testCalcPrice() {
        // Assuming extra shot and syrup prices are 0.5 each
        double extraPrices = coffee.getExtraShot() ? 0.5 : 0.0;
        extraPrices += coffee.getExtraSyrup() ? 0.5 : 0.0;

        double expectedPrice = Beverage.getBasePrice() + extraPrices + coffee.addSizePrice();
        assertEquals(expectedPrice, coffee.calcPrice());

        // Testing with different size
        Coffee largeCoffee = new Coffee("Latte", Size.LARGE, false, false);
        expectedPrice = Beverage.getBasePrice() + largeCoffee.addSizePrice();
        assertEquals(expectedPrice, largeCoffee.calcPrice());
    }

    @Test
    void testGetExtraShot() {
        assertTrue(coffee.getExtraShot());
    }

    @Test
    void testGetExtraSyrup() {
        assertTrue(coffee.getExtraSyrup());
    }

    @Test
    void testToString() {
        String expected = String.format("Espresso, Size: SMALL, Extra Shot: true, Extra Syrup: true, Price: $%.2f", coffee.calcPrice());
        assertEquals(expected, coffee.toString());
    }

    @Test
    void testEquals() {
        Coffee coffee2 = new Coffee("Espresso", Size.SMALL, true, true);
        Coffee coffee3 = new Coffee("Espresso", Size.SMALL, true, false);
        
        assertEquals(coffee, coffee2);
        assertNotEquals(coffee, coffee3);
    }
}
