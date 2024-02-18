public class ArraySumDriver {
    private final static int ARRAY_SIZE = 6;

    public static void main(String[] args) {
        int index = 0;
        Integer[] myArray = new Integer[ARRAY_SIZE];
        
        myArray[index++] = 13;
        myArray[index++] = 5;
        myArray[index++] = 12;
        myArray[index++] = 6;
        
        int sum = sumOfArray(myArray, 3);
        System.out.println("Sum of array (first 4 values): " + sum);
        
        myArray[index++] = 7;
        myArray[index++] = 1;
        
        sum = sumOfArray(myArray, 5);
        System.out.println("Sum of full array: " + sum);
        
        // Test for Fibonacci method
        int fibIndex = 10; // Example: Calculate the 10th Fibonacci number
        System.out.println("Fibonacci of " + fibIndex + ": " + fibonacci(fibIndex));
    }
    
    /**
     * Recursive method for generating sum of values in an array
     * @param arr array of Integers
     * @param num index of array to sum all previous index values (including num)
     * @return sum of array values
     */
    public static int sumOfArray(Integer[] arr, int num) {
        if (num < 0) {
            return 0;
        } else {
            return sumOfArray(arr, num - 1) + arr[num];
        }
    }

    /**
     * Method to compute Fibonacci number using dynamic programming approach
     * @param n the position in Fibonacci sequence
     * @return the Fibonacci number
     */
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
