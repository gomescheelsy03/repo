/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: The 'TypeTestStudent' class contains tests to verify the values, string representations, and correct instantiation of the 'Type' enum.
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

class TypeTestStudent {

    @Test
    void testValues() {
        Type[] expectedValues = {Type.ALCOHOL, Type.COFFEE, Type.SMOOTHIE};
        
        assertArrayEquals(expectedValues, Type.values());
    }
    
    @Test
    void testValueOf() {
        Type alcohol = Type.valueOf("ALCOHOL");
        assertSame(Type.ALCOHOL, alcohol);
        
        Type smoothie = Type.valueOf("SMOOTHIE");
        assertSame(Type.SMOOTHIE, smoothie);
        
        assertThrows(IllegalArgumentException.class, () -> {
            Type.valueOf("INVALID");
        });
    }
    
    @Test
    void testToString() {
        assertEquals("ALCOHOL", Type.ALCOHOL.toString()); 
        assertEquals("COFFEE", Type.COFFEE.toString());
        assertEquals("SMOOTHIE", Type.SMOOTHIE.toString());
    }

}