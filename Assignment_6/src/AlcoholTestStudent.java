/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: The 'AlcoholTestStudent' class contains JUnit tests for validating the functionality of the 'Alcohol' class, including constructors, price calculations, and weekend checks.
 * Due: 12/04/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Chelsy Gomes________
*/
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlcoholTestStudent {

    @Test
    void testAlcoholConstructor() {
        Alcohol alcohol = new Alcohol("Beer", Size.MEDIUM, true);
        assertNotNull(alcohol);
        assertEquals("Beer", alcohol.getBevName());
        assertEquals(Size.MEDIUM, alcohol.getSize());
        assertTrue(alcohol.isWeekend());
    }

    @Test
    void testCalcPrice() {
      
        // Testing a small-sized alcohol beverage on a non-weekend day
        Alcohol alcohol1 = new Alcohol("Beer", Size.SMALL, false);
        assertEquals(2.0, alcohol1.calcPrice()); // BASE_PRICE

        // Testing a medium-sized alcohol beverage on a weekend day
        Alcohol alcohol2 = new Alcohol("Wine", Size.MEDIUM, true);
        assertEquals(3.6, alcohol2.calcPrice()); // BASE_PRICE + SIZE_PRICE + WEEKEND_SURCHARGE

        // Testing a large-sized alcohol beverage on a weekend day
        Alcohol alcohol3 = new Alcohol("Whiskey", Size.LARGE, true);
        assertEquals(4.6, alcohol3.calcPrice()); // BASE_PRICE + 2 * SIZE_PRICE + WEEKEND_SURCHARGE
    }

    @Test
    void testToString() {
        Alcohol alcohol = new Alcohol("Beer", Size.LARGE, false);
        String expected = "Beer, Size: LARGE, Weekend: false, Price: $4.00";
        assertEquals(expected, alcohol.toString());
    }

    @Test
    void testEquals() {
        Alcohol alcohol1 = new Alcohol("Beer", Size.MEDIUM, true);
        Alcohol alcohol2 = new Alcohol("Beer", Size.MEDIUM, true);
        Alcohol alcohol3 = new Alcohol("Wine", Size.MEDIUM, true);

        assertEquals(alcohol1, alcohol2);
        assertNotEquals(alcohol1, alcohol3);
    }

    @Test
    void testIsWeekend() {
        Alcohol alcohol = new Alcohol("Beer", Size.SMALL, true);
        assertTrue(alcohol.isWeekend());
    }
}
