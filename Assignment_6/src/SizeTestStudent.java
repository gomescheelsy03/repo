/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: The 'SizeTestStudent' class contains tests to check the values, string representations, and correct instantiation of the 'Size' enum.
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

class SizeTestStudent {

    @Test
    void testValues() {
        Size[] expectedValues = {Size.SMALL, Size.MEDIUM, Size.LARGE};
        
        assertArrayEquals(expectedValues, Size.values());  
    }
    
    @Test
    void testValueOf() {
        Size small = Size.valueOf("SMALL");
        assertSame(Size.SMALL, small);
        
        Size large = Size.valueOf("LARGE");
        assertSame(Size.LARGE, large);
        
        assertThrows(IllegalArgumentException.class, () -> {
           Size.valueOf("INVALID"); 
        });
    }
    
    @Test
    void testToString() {    
        assertEquals("SMALL", Size.SMALL.toString());
        assertEquals("MEDIUM", Size.MEDIUM.toString());
        assertEquals("LARGE", Size.LARGE.toString());
    }

}