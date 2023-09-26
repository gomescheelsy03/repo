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

// The Procedure class represents medical procedures that a patient might undergo.
public class Procedure {
    
    // Attributes (fields) defining the procedure details.
    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double charges;

    // Default constructor: initializes a new procedure with default values.
    public Procedure() {}

    // Constructor to initialize only the procedure name and date.
    public Procedure(String procedureName, String procedureDate) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
    }

    // Overloaded constructor: initializes a procedure with all provided details.
    public Procedure(String procedureName, String procedureDate, String practitionerName, double charges) {
        // Using 'this' keyword to call the previous constructor for setting procedure name and date.
        this(procedureName, procedureDate);
        // Setting the remaining attributes.
        this.practitionerName = practitionerName;
        this.charges = charges;
    }

    // Getters (Accessor methods) for the attributes.
    public String getProcedureName() {
        return procedureName;
    }

    public String getProcedureDate() {
        return procedureDate;
    }

    public String getPractitionerName() {
        return practitionerName;
    }

    public double getCharges() {
        return charges;
    }

    // Setters (Mutator methods) for the attributes.
    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public void setProcedureDate(String procedureDate) {
        this.procedureDate = procedureDate;
    }

    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    // Overriding the default 'toString' method to provide a custom representation of a Procedure object.
    @Override
    public String toString() {
        return "Procedure: " + procedureName + "\n" +
               "Date=" + procedureDate + "\n" +
               "Practitioner=" + practitionerName + "\n" +
               "Charge=$" + charges;
    }
}
