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

import java.util.Objects;

// This class defines the properties of a Road that connects two towns in a graph.
public class Road implements Comparable<Road> {
    // Private fields to store the towns at either end of the road, the distance between them, and the road's name.
    private Town town1;
    private Town town2;
    private int distance;
    private String name;

    // Constructor to initialize a road with two towns, a distance, and a name.
    public Road(Town town1, Town town2, int distance, String name) {
        this.town1 = town1;
        this.town2 = town2;
        this.distance = distance;
        this.name = name;
    }

    // Returns the first town on the road.
    public Town getTown1() {
        return town1;
    }

    // Returns the second town on the road.
    public Town getTown2() {
        return town2;
    }

    // Returns the distance of the road.
    public int getDistance() {
        return distance;
    }

    // Returns the name of the road.
    public String getName() {
        return name;
    }

    // Provides a string representation of the road including its name, distance, and connected towns.
    @Override
    public String toString() {
        return name + ", " + distance + " miles; " + town1.getName() + "; " + town2.getName();
    }

    // Compares this road to another road based on the road's name, distance, and the towns it connects.
    @Override
    public int compareTo(Road other) {
        int result = this.name.compareTo(other.name); // Compare by name first.
        if (result == 0) {
            result = Integer.compare(this.distance, other.distance); // If names are the same, compare by distance.
            if (result == 0) {
                // If distances are also the same, compare the towns by alphabetical order.
                result = this.town1.compareTo(other.town1);
                if (result == 0) {
                    result = this.town2.compareTo(other.town2);
                }
            }
        }
        return result; // Return the comparison result.
    }

    // Checks if this road is equal to another object based on distance, name, and the towns it connects.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Check for identity.
        if (o == null || getClass() != o.getClass()) return false; // Check for null and compare classes.
        Road road = (Road) o; // Cast the object to Road.
        // Check if the distance and name are the same and if the towns are interchangeable.
        return distance == road.distance && name.equals(road.name) &&
               ((town1.equals(road.town1) && town2.equals(road.town2)) ||
                (town1.equals(road.town2) && town2.equals(road.town1)));
    }

    // Generates a hash code for this road.
    @Override
    public int hashCode() {
        // Hash code is based on the name, distance, and both towns, irrespective of their order.
        return Objects.hash(name, distance) + Objects.hash(town1, town2) + Objects.hash(town2, town1);
    }

    // Returns the weight of the road, which is equivalent to its distance.
    public int getWeight() {
        return getDistance(); // This is used, for example, in pathfinding algorithms where weight is a factor.
    }
}
