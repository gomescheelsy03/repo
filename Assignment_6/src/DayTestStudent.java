/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: The 'DayTestStudent' class contains tests to verify the functionality of the 'Day' enum, including its values and string representation.
 * Due: 12/04/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Chelsy Gomes________
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DayTestStudent {
    
    @Test
    void testValues() {
        Day[] expectedValues = {Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, 
                Day.THURSDAY, Day.FRIDAY, Day.SATURDAY, Day.SUNDAY};
        
        assertArrayEquals(expectedValues, Day.values());
    }
    
    @Test
    void testValueOf() {
        Day monday = Day.valueOf("MONDAY");
        assertSame(Day.MONDAY, monday);
        
        Day friday = Day.valueOf("FRIDAY"); 
        assertSame(Day.FRIDAY, friday);
        
        assertThrows(IllegalArgumentException.class, () -> {
            Day.valueOf("INVALID"); 
        });
    }
    
    @Test
    void testToString() {
        assertEquals("MONDAY", Day.MONDAY.toString());
        assertEquals("TUESDAY", Day.TUESDAY.toString());
        assertEquals("WEDNESDAY", Day.WEDNESDAY.toString());
        assertEquals("THURSDAY", Day.THURSDAY.toString());
        assertEquals("FRIDAY", Day.FRIDAY.toString());
        assertEquals("SATURDAY", Day.SATURDAY.toString());
        assertEquals("SUNDAY", Day.SUNDAY.toString());
    }

}