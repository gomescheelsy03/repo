/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg 
 * Description: The code provides a ‘GradeBook’ class that allows for the storage and manipulation of student scores, alongside a ‘GradebookTester’ class that contains unit tests to validate the functionality of the ‘GradeBook’ class.
 * Due: 10/02/2023
 * Platform/compiler:Eclipse 
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Chelsy Gomes 
 */

package grade;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GradebookTester {
    // Two GradeBook instances to be tested
    private GradeBook gradeBook1;
    private GradeBook gradeBook2;

    // Set up method, runs before each test
    @Before
    public void setUp() {
        // Initialize the gradeBook instances with capacity of 5
        gradeBook1 = new GradeBook(5);
        gradeBook2 = new GradeBook(5);

        // Adding scores to the first GradeBook instance
        gradeBook1.addScore(75.0);
        gradeBook1.addScore(85.0);

        // Adding scores to the second GradeBook instance
        gradeBook2.addScore(70.0);
        gradeBook2.addScore(40.0);
        gradeBook2.addScore(35.0);
        gradeBook2.addScore(15.0);
    }

    // Tear down method, runs after each test
    @After
    public void tearDown() {
        // Nullifying the gradeBook instances to free up memory
        gradeBook1 = null;
        gradeBook2 = null;
    }

    // Test method for the addScore and toString methods
    @Test
    public void addScoreTest() {
        // Check if scores are added correctly using the toString representation
        assertTrue((gradeBook1.toString()).equals("75.0 85.0 "));
        assertTrue((gradeBook2.toString()).equals("70.0 40.0 35.0 15.0 "));

        // Verify the size (number of scores) added for each gradeBook
        assertEquals(2, gradeBook1.getScoreSize(), 0.1);
        assertEquals(4, gradeBook2.getScoreSize(), 0.1);
    }

    // Test method for the sum of scores
    @Test
    public void sumTest() {
        // Verify the sum of scores for each gradeBook
        assertEquals(160.0, gradeBook1.sum(), 0.1);
        assertEquals(160.0, gradeBook2.sum(), 0.1);
    }

    // Test method for the minimum score
    @Test
    public void minimumTest() {
        // Verify the smallest score for each gradeBook
        assertEquals(75.0, gradeBook1.minimum(), 0.1);
        assertEquals(15.0, gradeBook2.minimum(), 0.1);
    }

    // Test method for the final score calculation
    @Test
    public void finalScoreTest() {
        // Verify the final score (sum minus the smallest score if there are at least 2 scores)
        assertEquals(85.0, gradeBook1.finalScore(), 0.1);
        assertEquals(145.0, gradeBook2.finalScore(), 0.1);
    }
}
