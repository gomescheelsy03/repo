/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: This class calculates holiday bonuses for retail stores based on sales data. It uses a two-dimensional ragged array of doubles to represent sales for each store in each category. The class includes methods to calculate individual store bonuses and the total holiday bonus for the district, utilizing methods from TwoDimRaggedArrayUtility when needed.
 * Due: 11/13/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: _Chelsy Gomes_________
*/

package application;

public class HolidayBonus {

    /**
     * Calculates the holiday bonus for each store
     * 
     * @param data the two-dimensional array of store sales
     * @param high bonus for the highest store in a category
     * @param low bonus for the lowest store in a category
     * @param other bonus for all other stores in a category
     * @return an array of the bonus for each store
     */
    public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
        double[] bonuses = new double[data.length];

        int maxCol = 0;
        for (int i = 0; i < data.length; i++) {
            if (maxCol < data[i].length) {
                maxCol = data[i].length;
            }
        }

        for (int j = 0; j < maxCol; j++) {
            int highBonusIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
            int lowBonusIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);

            if (TwoDimRaggedArrayUtility.getHighestInColumn(data, j) > 0) {
                bonuses[highBonusIndex] += high;
            }

            if (TwoDimRaggedArrayUtility.getLowestInColumn(data, j) > 0 && highBonusIndex != lowBonusIndex) {
                bonuses[lowBonusIndex] += low;
            }

            for (int i = 0; i < data.length; i++) {
                if (j >= data[i].length || i == highBonusIndex || i == lowBonusIndex || data[i][j] <= 0) {
                    continue;
                } else {
                    bonuses[i] += other;
                }
            }
        }
        return bonuses;
    }

    /**
     * Overloaded method to calculate holiday bonus for each store without specifying bonus amounts
     * 
     * @param data the two-dimensional array of store sales
     * @return an array of the bonus for each store
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        double high = 5000.0;
        double low = 1000.0;
        double other = 2000.0;

        return calculateHolidayBonus(data, high, low, other);
    }

    /**
     * Calculates the total holiday bonuses
     * 
     * @param data the two-dimensional array of store sales
     * @param high bonus for the highest store in a category
     * @param low bonus for the lowest store in a category
     * @param other bonus for all other stores in a category
     * @return the total of all holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
        double[] bonusArray = calculateHolidayBonus(data, high, low, other);
        double total = 0;

        for (double bonus : bonusArray) {
            total += bonus;
        }
        return total;
    }

    /**
     * Overloaded method to calculate the total holiday bonuses without specifying bonus amounts
     * 
     * @param data the two-dimensional array of store sales
     * @return the total of all holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double high = 5000.0;
        double low = 1000.0;
        double other = 2000.0;

        return calculateTotalHolidayBonus(data, high, low, other);
    }
}
