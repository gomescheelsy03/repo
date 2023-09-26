/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: The `Procedure` class models medical procedures with attributes for the procedure's name, date, practitioner, and associated charges, providing constructors for initialization and methods for data access and modification.
 * Due: 09/25/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Chelsy Gomes_____
*/

import java.util.Scanner;

public class PatientDriverApp {

    // Method to display patient details.
    public static void displayPatient(Patient patient) {
        System.out.println("Patient:");
        System.out.println("  " + patient);
    }

    // Method to display procedure details.
    public static void displayProcedure(Procedure procedure) {
        System.out.println("\n\tProcedure: " + procedure.getProcedureName());
        System.out.println("\tDate=" + procedure.getProcedureDate());
        System.out.println("\tPractitioner=" + procedure.getPractitionerName());
        System.out.println("\tCharge=$" + String.format("%.2f", procedure.getCharges()));
    }

    // Method to calculate the total charges for three procedures.
    public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
        return p1.getCharges() + p2.getCharges() + p3.getCharges();
    }

    // Main driver method.
    public static void main(String[] args) {
        // Create a Scanner object for user input.
        Scanner sc = new Scanner(System.in);

        // Collect patient details from the user.
        System.out.print("Enter patient's first name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter patient's middle name: ");
        String middleName = sc.nextLine();

        System.out.print("Enter patient's last name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter patient's address: ");
        String streetAddress = sc.nextLine();

        System.out.print("Enter patient's city: ");
        String city = sc.nextLine();

        System.out.print("Enter patient's state: ");
        String state = sc.nextLine();

        System.out.print("Enter patient's zipcode: ");
        String zipCode = sc.nextLine();

        System.out.print("Enter emergency contact's name (first and last): ");
        String emergencyContactName = sc.nextLine();

        System.out.print("Enter your emergency contact's phone number: ");
        String emergencyContactPhone = sc.nextLine();

        // Create a new patient object using the details collected.
        Patient patient = new Patient(firstName, middleName, lastName, streetAddress, city, state, zipCode, "", emergencyContactName, emergencyContactPhone);
        displayPatient(patient);

        // Create an array to store three procedures.
        Procedure[] procedures = new Procedure[3];

        // Collect details for three procedures from the user.
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter procedure " + (i + 1) + ":");
            System.out.print("Procedure Name: ");
            String procedureName = sc.nextLine();

            System.out.print("Enter date of procedure: ");
            String procedureDate = sc.nextLine();

            System.out.print("Enter practitioner name: ");
            String practitionerName = sc.nextLine();

            System.out.print("Enter price: ");
            double charges = sc.nextDouble();
            sc.nextLine(); // Consume the newline left by nextDouble().

            // Store the procedure details in the procedures array.
            procedures[i] = new Procedure(procedureName, procedureDate, practitionerName, charges);
            displayProcedure(procedures[i]);
        }

        // Calculate and display the total charges for the three procedures.
        double totalCharges = calculateTotalCharges(procedures[0], procedures[1], procedures[2]);
        System.out.printf("\nTotal Charge: $%,.2f\n\n", totalCharges);

        // Display student details.
        System.out.println("Student Name: Chelsy Mary Gomes");
        System.out.println("MC#: M21074473");
        System.out.println("Due Date: 09/25/2023");

        // Close the Scanner object.
        sc.close();
    }
}
