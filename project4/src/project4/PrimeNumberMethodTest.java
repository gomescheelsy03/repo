// starting by defining the package that the test class resides in.
package project4;

// importing the static methods assertEquals, assertFalse, and assertTrue from the org.junit.Assert class.
// These methods will be used in the tests.
import static org.junit.Assert.*;

// importing the org.junit.Test annotation. This annotation tells JUnit that the public void method 
// to which it is attached can be run as a test case.
import org.junit.Test;

// defining the test class, PrimeNumberMethodTest. 
public class PrimeNumberMethodTest {

    // annotating a method with @Test to tell JUnit to run this method as a test case.
    @Test
    public void testIsPrime() {
        // using the assertTrue method to assert that the condition inside the parentheses is true.
        // If it is not, then the test fails.
        // Here, testing the isPrime method with various integers to ensure that it correctly 
        // identifies whether or not they're prime numbers.
        assertTrue(PrimeNumberMethod.isPrime(2)); // 2 is a prime number, so this should be true.
        assertTrue(PrimeNumberMethod.isPrime(3)); // 3 is a prime number, so this should be true.
        assertFalse(PrimeNumberMethod.isPrime(4)); // 4 is not a prime number, so this should be false.
        assertTrue(PrimeNumberMethod.isPrime(5)); // 5 is a prime number, so this should be true.
        assertFalse(PrimeNumberMethod.isPrime(6)); // 6 is not a prime number, so this should be false.
        assertTrue(PrimeNumberMethod.isPrime(7)); // 7 is a prime number, so this should be true.
        assertFalse(PrimeNumberMethod.isPrime(8)); // 8 is not a prime number, so this should be false.
        assertFalse(PrimeNumberMethod.isPrime(9)); // 9 is not a prime number, so this should be false.
        assertTrue(PrimeNumberMethod.isPrime(11)); // 11 is a prime number, so this should be true.
        assertFalse(PrimeNumberMethod.isPrime(12)); // 12 is not a prime number, so this should be false.
    }
}
