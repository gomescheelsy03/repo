/*
 * Class: CMSC204 
 * Instructor: Gary Thai
 * Due: 05/05/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Chelsy Gomes_____
*/


package application;

import java.util.ArrayList;
import java.util.Objects;

// Represents a town in a graph. Each town can have adjacent towns, useful for pathfinding algorithms.
public class Town implements Comparable<Town> {
    private String name; // Name of the town
    private ArrayList<Town> adjacentTowns; // List of adjacent towns (edges to other towns)
    private Town previous; // Previous town in the path, used in shortest path algorithms
    private int distance; // Distance from the source town, used in shortest path calculations

    // Constructor to initialize a town with a name
    public Town(String name) {
        this.name = name;
        this.adjacentTowns = new ArrayList<>(); // Initialize the list of adjacent towns
        this.previous = null; // Initially, there is no previous town in the path
        this.distance = Integer.MAX_VALUE; // Distance is set to the maximum value by default
    }

    // Copy constructor to create a new Town instance based on another Town instance
    public Town(Town templateTown) {
        this(templateTown.name); // Delegate to the main constructor for name
        this.adjacentTowns = new ArrayList<>(templateTown.adjacentTowns); // Copy the list of adjacent towns
        this.previous = templateTown.previous; // Copy the previous town reference
        this.distance = templateTown.distance; // Copy the distance value
    }

    // Adds an adjacent town to this town's list if it's not already present
    public void addAdjacentTown(Town neighbor) {
        if (!this.adjacentTowns.contains(neighbor)) {
            this.adjacentTowns.add(neighbor); // Add neighbor only if it's not already in the list
        }
    }

    // Getter for the town's name
    public String getName() {
        return this.name;
    }

    // Setter for the town's name
    public void setName(String name) {
        this.name = name;
    }

    // Returns a copy of the list of adjacent towns to ensure encapsulation
    public ArrayList<Town> getAdjacentTowns() {
        return new ArrayList<>(this.adjacentTowns);
    }

    // Getter for the previous town in the path
    public Town getPrevious() {
        return previous;
    }

    // Setter for the previous town in the path
    public void setPrevious(Town previous) {
        this.previous = previous;
    }

    // Getter for the distance from the source town
    public int getDistance() {
        return distance;
    }

    // Setter for the distance from the source town
    public void setDistance(int distance) {
        this.distance = distance;
    }

    // Converts the town to a string representation showing its name
    @Override
    public String toString() {
        return "Town{" +
               "name='" + name + '\'' +
               '}';
    }

    // Compares this town to another town based on their names for sorting purposes
    @Override
    public int compareTo(Town other) {
        return this.name.compareTo(other.name);
    }

    // Checks if this town is equal to another object based on the town's name
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Town town = (Town) o;
        return Objects.equals(name, town.name);
    }

    // Generates a hash code for this town based primarily on its name
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
