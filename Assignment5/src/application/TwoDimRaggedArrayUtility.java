/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: This utility class manages two-dimensional ragged arrays of doubles. It provides methods to read and write these arrays from files, calculate totals, averages, row and column totals, and identify highest and lowest values in rows, columns, and the entire array.
 * Due: 11/13/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: _Chelsy Gomes_________
*/

package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class TwoDimRaggedArrayUtility {

    // Reads from a file and returns a ragged array of doubles
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        double[][] data = new double[10][];
        int numRows = 0;

        while (scanner.hasNextLine() && numRows < 10) {
            String[] values = scanner.nextLine().trim().split(" ");
            data[numRows] = new double[values.length];
            for (int i = 0; i < values.length; i++) {
                data[numRows][i] = Double.parseDouble(values[i]);
            }
            numRows++;
        }

        scanner.close();
        return java.util.Arrays.copyOf(data, numRows);
    }

    // Writes the ragged array of doubles into the file
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(outputFile);
        for (double[] row : data) {
            for (double element : row) {
                writer.print(element + " ");
            }
            writer.println();
        }
        writer.close();
    }

    // Returns the total of the elements in the array
    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data) {
            for (double element : row) {
                total += element;
            }
        }
        return total;
    }

    // Returns the average of the elements in the array
    public static double getAverage(double[][] data) {
        double total = getTotal(data);
        int count = 0;
        for (double[] row : data) {
            count += row.length;
        }
        return total / count;
    }

    // Returns the total of the selected row in the array
    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        for (double element : data[row]) {
            total += element;
        }
        return total;
    }

    // Returns the total of the selected column in the array
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (double[] row : data) {
            if (col < row.length) {
                total += row[col];
            }
        }
        return total;
    }

    // Returns the largest element in the selected row
    public static double getHighestInRow(double[][] data, int row) {
        double max = data[row][0];
        for (double element : data[row]) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    // Returns the index of the largest element in the selected row
    public static int getHighestInRowIndex(double[][] data, int row) {
        int index = 0;
        double max = data[row][0];
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] > max) {
                max = data[row][i];
                index = i;
            }
        }
        return index;
    }

    // Returns the smallest element in the selected row
    public static double getLowestInRow(double[][] data, int row) {
        double min = data[row][0];
        for (double element : data[row]) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    // Returns the index of the smallest element in the selected row
    public static int getLowestInRowIndex(double[][] data, int row) {
        int index = 0;
        double min = data[row][0];
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] < min) {
                min = data[row][i];
                index = i;
            }
        }
        return index;
    }

    // Returns the largest element in the selected column
    public static double getHighestInColumn(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            if (col < row.length && row[col] > max) {
                max = row[col];
            }
        }
        return max;
    }

    // Returns the index of the largest element in the selected column
    public static int getHighestInColumnIndex(double[][] data, int col) {
        int index = -1;
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] > max) {
                max = data[i][col];
                index = i;
            }
        }
        return index;
    }

    // Returns the smallest element in the selected column
    public static double getLowestInColumn(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            if (col < row.length && row[col] < min) {
                min = row[col];
            }
        }
        return min;
    }

    // Returns the index of the smallest element in the selected column
    public static int getLowestInColumnIndex(double[][] data, int col) {
        int index = -1;
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] < min) {
                min = data[i][col];
                index = i;
            }
        }
        return index;
    }

    // Returns the largest element in the array
    public static double getHighestInArray(double[][] data) {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            for (double element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }

    // Returns the smallest element in the array
    public static double getLowestInArray(double[][] data) {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            for (double element : row) {
                if (element < min) {
                    min = element;
                }
            }
        }
        return min;
    }
}
