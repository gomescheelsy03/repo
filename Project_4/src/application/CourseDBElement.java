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

/**
 * Represents an element in the course database, including all relevant information
 * about a course such as course ID, CRN, number of credits, room number, and instructor name.
 * Implements Comparable to allow for comparison based on CRN.
 */
public class CourseDBElement implements Comparable<CourseDBElement> {
    private String courseID; // Course identifier
    private int crn;         // Course Registration Number
    private int credits;     // Number of credits
    private String roomNumber; // Room number
    private String instructorName; // Instructor's name

    /**
     * Default constructor.
     */
    public CourseDBElement() {
    }

    /**
     * Constructor to create a CourseDBElement with all attributes.
     *
     * @param courseID The ID of the course.
     * @param crn The CRN of the course.
     * @param credits The number of credits the course is worth.
     * @param roomNumber The room number where the course is held.
     * @param instructorName The name of the instructor.
     */
    public CourseDBElement(String courseID, int crn, int credits, String roomNumber, String instructorName) {
        this.courseID = courseID;
        this.crn = crn;
        this.credits = credits;
        this.roomNumber = roomNumber;
        this.instructorName = instructorName;
    }

    // Getter for the course ID
    public String getID() {
        return courseID;
    }

    // Setter for the course ID
    public void setID(String courseID) {
        this.courseID = courseID;
    }

    // Getter for the CRN
    public int getCRN() {
        return crn;
    }

    // Setter for the CRN
    public void setCRN(int crn) {
        this.crn = crn;
    }

    // Getter for the number of credits
    public int getCredits() {
        return credits;
    }

    // Setter for the number of credits
    public void setCredits(int credits) {
        this.credits = credits;
    }

    // Getter for the room number
    public String getRoomNum() {
        return roomNumber;
    }

    // Setter for the room number
    public void setRoomNum(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    // Getter for the instructor's name
    public String getInstructorName() {
        return instructorName;
    }

    // Setter for the instructor's name
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    /**
     * Compares this CourseDBElement with another based on CRN.
     * 
     * @param other The other CourseDBElement to compare to.
     * @return A negative integer, zero, or a positive integer as this object is less than,
     *         equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(CourseDBElement other) {
        return Integer.compare(this.crn, other.crn);
    }

    /**
     * Generates a hash code for this CourseDBElement based on its CRN.
     * 
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(crn);
    }

    /**
     * Returns a string representation of the course information.
     * This string is used for displaying the course in lists and should be formatted
     * to clearly present all the course details.
     * 
     * @return A string containing the course ID, CRN, number of credits, room number, and instructor's name.
     */
    
    @Override
    public String toString() {
        // Ensure this format matches the test expectation exactly
        return "Course:" + courseID + " CRN:" + crn + " Credits:" + credits + " Room:" + roomNumber + " Instructor:" + instructorName;
    }


	public static void main(String[] args) {
		
	}

}
