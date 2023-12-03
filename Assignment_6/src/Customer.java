/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: The 'Customer' class represents a customer with a name and age, including methods to access and modify these properties.
 * Due: 12/04/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Chelsy Gomes________
*/

public class Customer {
    private String name;
    private int age;

    // Constructor
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Customer(Customer c) {
        this.name = c.name;
        this.age = c.age;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // toString method
    @Override
    public String toString() {
        return "Customer [Name: " + name + ", Age: " + age + "]";
    }
}
