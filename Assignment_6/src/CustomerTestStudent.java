/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: Validates the 'Customer' class, focusing on constructor functionality and attribute accessors.
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

class CustomerTestStudent {
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("John Doe", 30);
    }

    @Test
    void testConstructor() {
        assertEquals("John Doe", customer.getName());
        assertEquals(30, customer.getAge());
    }

    @Test
    void testCopyConstructor() {
        Customer copy = new Customer(customer);
        assertEquals(customer.getName(), copy.getName());
        assertEquals(customer.getAge(), copy.getAge());
    }

    @Test
    void testGetAge() {
        assertEquals(30, customer.getAge());
    }

    @Test
    void testSetAge() {
        customer.setAge(35);
        assertEquals(35, customer.getAge());
    }

    @Test
    void testGetName() {
        assertEquals("John Doe", customer.getName());
    }

    @Test
    void testSetName() {
        customer.setName("Jane Doe");
        assertEquals("Jane Doe", customer.getName());
    }

    @Test
    void testToString() {
        String expectedString = "Customer [Name: John Doe, Age: 30]";
        assertEquals(expectedString, customer.toString());
    }
}

