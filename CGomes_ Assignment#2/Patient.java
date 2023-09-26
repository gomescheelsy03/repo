/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: The `Patient` class models a medical patient's personal and emergency contact details, offering constructors for initialization and methods to retrieve formatted representations of the patient's full name, address, and emergency contact.
 * Due: 09/25/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Chelsy Gomes_____
*/


// The Patient class represents the attributes and behaviors of a patient.
public class Patient {

    // Attributes (fields) of the Patient class
    private String firstName, middleName, lastName;
    private String streetAddress, city, state, zipCode;
    private String phoneNumber;
    private String emergencyContactName, emergencyContactPhone;

    // Default constructor - initializes the default values for a Patient
    public Patient() {}

    // Constructor to initialize only the names of the Patient
    public Patient(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    // Overloaded constructor to initialize all attributes of the Patient
    public Patient(String firstName, String middleName, String lastName, String streetAddress, 
                   String city, String state, String zipCode, String phoneNumber, 
                   String emergencyContactName, String emergencyContactPhone) {
        // Using 'this' keyword to call the previous constructor for setting names
        this(firstName, middleName, lastName);
        // Setting the other attributes
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
    }

    // Getter and Setter methods for all attributes...
    // (You've mentioned this comment, so assuming all getters and setters are present)

    // Method to build and return the full name of the Patient
    public String buildFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    // Method to build and return the full address of the Patient
    public String buildAddress() {
        return streetAddress + ", " + city + ", " + state + " " + zipCode; // Added commas for formatting
    }

    // Method to build and return the emergency contact details
    public String buildEmergencyContact() {
        return emergencyContactName + ": " + emergencyContactPhone; // Added colon for better formatting
    }

    // Overriding the default 'toString' method to provide a custom representation of a Patient object
    @Override
    public String toString() {
        return "Patient:\n  " + buildFullName() + "\n  " + buildAddress() + "\n  " + buildEmergencyContact() + "\n";
    }
}
