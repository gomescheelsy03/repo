/*
 * Class: CMSC204 
 * Instructor: Gary Thai
 * Due: 03/31/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Chelsy Gomes_____
*/


package application;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a student test file for CourseDBManager, which implements the
 * CourseDBManagerInterface.
 */
public class CourseDBManager_STUDENT_Test {
    private CourseDBManagerInterface dataMgr;

    /**
     * Sets up a new CourseDBManager before each test
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        dataMgr = new CourseDBManager();
    }

    /**
     * Clears the dataMgr reference after each test
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        dataMgr = null;
    }

    /**
     * Test the add method to ensure courses are added correctly
     */
    @Test
    public void testAdd() {
        try {
            dataMgr.add("CMSC101", 12345, 3, "Online", "Dr. Smith");
            CourseDBElement element = dataMgr.get(12345);
            assertEquals("CMSC101", element.getID());
        } catch (Exception e) {
            fail("Adding course failed: " + e.getMessage());
        }
    }

    /**
     * Test the get method to retrieve correct courses by CRN
     */
    @Test
    public void testGet() {
        dataMgr.add("CMSC101", 12345, 3, "Online", "Dr. Smith");
        dataMgr.add("CMSC102", 23456, 4, "Classroom", "Dr. Jones");

        try {
            CourseDBElement element = dataMgr.get(23456);
            assertEquals("CMSC102", element.getID());
        } catch (Exception e) {
            fail("Getting course failed: " + e.getMessage());
        }
    }

    /**
     * Test the readFile method to ensure file data is read correctly
     */
    @Test
    public void testReadFile() {
        try {
            File inputFile = new File("TestCourseData.txt");
            PrintWriter inFile = new PrintWriter(inputFile);
            inFile.println("CMSC101 12345 3 Online Dr. Smith");
            inFile.println("CMSC102 23456 4 Classroom Dr. Jones");
            inFile.close();

            dataMgr.readFile(inputFile);
            assertEquals("Online", dataMgr.get(12345).getRoomNum());
            assertEquals("Dr. Jones", dataMgr.get(23456).getInstructorName());

            inputFile.delete(); // Clean up the file after test completes
        } catch (Exception e) {
            fail("Reading file failed: " + e.getMessage());
        }
    }

    /**
     * Test the showAll method to ensure all courses are displayed correctly
     */
    @Test
    public void testShowAll() {
        dataMgr.add("CMSC101", 12345, 3, "Online", "Dr. Smith");
        dataMgr.add("CMSC102", 23456, 4, "Classroom", "Dr. Jones");

        ArrayList<String> list = dataMgr.showAll();
        assertTrue(list.contains("Course:CMSC101 CRN:12345 Credits:3 Room:Online Instructor:Dr. Smith"));
        assertTrue(list.contains("Course:CMSC102 CRN:23456 Credits:4 Room:Classroom Instructor:Dr. Jones"));
    }
}

