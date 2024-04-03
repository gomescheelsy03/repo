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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * This class manages the course database. It allows adding courses, retrieving a course by CRN,
 * reading courses from a file, and displaying all courses in a sorted manner.
 */
public class CourseDBManager implements CourseDBManagerInterface {
    private CourseDBStructure db;

    /**
     * Constructor initializing the course database structure with an estimated size.
     */
    public CourseDBManager() {
        // Initialize the CourseDBStructure with an estimated size
        db = new CourseDBStructure(100); // The number here is just an initial capacity
    }

    /**
     * Adds a course to the database.
     *
     * @param id         Course ID
     * @param crn        Course Registration Number
     * @param credits    Number of credits
     * @param roomNum    Room number
     * @param instructor Instructor's name
     */
    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
        db.add(element);
    }

    /**
     * Retrieves a course from the database using its CRN.
     *
     * @param crn Course Registration Number
     * @return The course if found, or null otherwise
     */
    @Override
    public CourseDBElement get(int crn) {
        try {
            return db.get(crn);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null; // Indicates the course was not found
        }
    }

    /**
     * Reads course data from a file and adds the courses to the database.
     *
     * @param input The file to read from
     * @throws FileNotFoundException If the specified file does not exist
     */
    @Override
    public void readFile(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.startsWith("#") && !line.isEmpty()) { // Skip comments and empty lines
                String[] parts = line.split("\\s+", 5);
                if (parts.length >= 5) {
                    add(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3], parts[4]);
                }
            }
        }
        scanner.close();
    }

    /**
     * Returns an ArrayList of strings representing all courses in the database, sorted by CRN.
     *
     * @return A sorted ArrayList of course representations
     */
   
    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> allElements = db.showAll();
        Collections.sort(allElements, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int crn1 = extractCRN(s1);
                int crn2 = extractCRN(s2);
                return Integer.compare(crn1, crn2);
            }

            private int extractCRN(String courseInfo) {
                try {
                    // Ensure the CRN extraction logic is foolproof against formatting variations.
                    String crnStr = courseInfo.split("CRN:")[1].split(" ")[0].trim();
                    return Integer.parseInt(crnStr);
                } catch (Exception e) {
                    System.err.println("Error parsing CRN from: " + courseInfo);
                    return -1; // Consider how to handle parsing errors appropriately.
                }
            }
        });
        return allElements;
    }


}