/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: The 'SmoothieTestStudent' class contains tests to validate the construction, price calculation, and properties of the 'Smoothie' class.
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

class SmoothieTestStudent {
    private Smoothie smoothie;

    @BeforeEach
    void setUp() {
        smoothie = new Smoothie("Berry Blast", Size.MEDIUM, 3, true);
    }

    @Test
    void testSmoothieConstructor() {
        assertNotNull(smoothie);
        assertEquals("Berry Blast", smoothie.getBevName());
        assertEquals(Size.MEDIUM, smoothie.getSize());
        assertEquals(3, smoothie.getNumOfFruits());
        assertTrue(smoothie.getAddProtein());
    }

    @Test
    void testCalcPrice() {
        double basePrice = 2.0; // Known base price
        double sizePrice = smoothie.getSize() == Size.MEDIUM ? 1.0 : (smoothie.getSize() == Size.LARGE ? 2.0 : 0.0);
        double fruitPrice = smoothie.getNumOfFruits() * 0.5;
        double proteinPrice = smoothie.getAddProtein() ? 1.5 : 0.0;

        double expectedPrice = basePrice + sizePrice + fruitPrice + proteinPrice;
        assertEquals(expectedPrice, smoothie.calcPrice(), "The calculated price is incorrect.");
    }

    @Test
    void testGetAddProtein() {
        assertTrue(smoothie.getAddProtein());
    }

    @Test
    void testGetNumOfFruits() {
        assertEquals(3, smoothie.getNumOfFruits());
    }

    @Test
    void testToString() {
        String expected = "Berry Blast, Size: MEDIUM, Fruits: 3, Protein Added: true, Price: $" + String.format("%.2f", smoothie.calcPrice());
        assertEquals(expected, smoothie.toString());
    }

    @Test
    void testEquals() {
        Smoothie smoothie2 = new Smoothie("Berry Blast", Size.MEDIUM, 3, true);
        Smoothie smoothie3 = new Smoothie("Tropical Mix", Size.MEDIUM, 3, true);
        
        assertEquals(smoothie, smoothie2);
        assertNotEquals(smoothie, smoothie3);
    }
}
