package project4;

public class PrimeNumberMethod {
    
    // Main function
    public static void main(String[] args) {
        System.out.println("The first 50 prime numbers are \n");
        printPrimeNumbers(50);
    }

    // Function to print first N prime numbers
    public static void printPrimeNumbers(int numberOfPrimes) {
        final int NUMBER_OF_PRIMES_PER_LINE = 10; // Display 10 per line
        int count = 0; // Count the number of prime numbers found so far
        int number = 2; // The current number that we're checking

        // This loop will continue until we find the required number of primes
        while (count < numberOfPrimes) {
            // If current number is prime
            if (isPrime(number)) {
                count++; // Increase the count of prime numbers found so far

                // If this is the 10th prime number (or 20th, 30th, etc.)
                // we print it on a new line
                if (count % NUMBER_OF_PRIMES_PER_LINE == 0) {
                    System.out.printf("%-5s\n", number);
                } else { // Otherwise, we print it on the same line
                    System.out.printf("%-5s", number);
                }
            }

            // Move on to the next number
            number++;
        }
    }

    // Function to check if a number is prime
    public static boolean isPrime(int number) {
        // A prime number is a number greater than 1 that has no positive divisors other than 1 and itself.
        // So, we check if the current number is divisible by any number up to its half.
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) { // If number is divisible, it's not prime
                return false; // So, we return false
            }
        }

        // If we haven't returned false yet, the number is prime
        return true;
    }
}

