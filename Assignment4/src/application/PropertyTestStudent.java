package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

    private Property defaultProperty, copyProperty, parameterizedProperty, fullyParameterizedProperty;

    @BeforeEach
    void setUp() {
        defaultProperty = new Property();
        copyProperty = new Property(defaultProperty);
        parameterizedProperty = new Property("Estate", "New York", 3500.00, "John Doe");
        fullyParameterizedProperty = new Property("Villa", "Los Angeles", 5000.00, "Jane Smith", 2, 3, 4, 5);
    }

    @AfterEach
    void tearDown() {
        defaultProperty = copyProperty = parameterizedProperty = fullyParameterizedProperty = null;
    }

    @Test
    void testDefaultConstructor() {
        assertEquals("", defaultProperty.getCity());
        assertEquals("", defaultProperty.getOwner());
        assertEquals("", defaultProperty.getPropertyName());
        assertEquals(0.0, defaultProperty.getRentAmount(), 0.001);
    }

    @Test
    void testCopyConstructor() {
        assertEquals(defaultProperty.getCity(), copyProperty.getCity());
        assertEquals(defaultProperty.getOwner(), copyProperty.getOwner());
        assertEquals(defaultProperty.getPropertyName(), copyProperty.getPropertyName());
        assertEquals(defaultProperty.getRentAmount(), copyProperty.getRentAmount(), 0.001);

        // Compare the Plot attributes instead of object references
        assertEquals(defaultProperty.getPlot().getX(), copyProperty.getPlot().getX());
        assertEquals(defaultProperty.getPlot().getY(), copyProperty.getPlot().getY());
        assertEquals(defaultProperty.getPlot().getWidth(), copyProperty.getPlot().getWidth());
        assertEquals(defaultProperty.getPlot().getDepth(), copyProperty.getPlot().getDepth());
    }

    @Test
    void testParameterizedConstructor() {
        assertEquals("New York", parameterizedProperty.getCity());
        assertEquals("John Doe", parameterizedProperty.getOwner());
        assertEquals("Estate", parameterizedProperty.getPropertyName());
        assertEquals(3500.00, parameterizedProperty.getRentAmount(), 0.001);
    }

    @Test
    void testFullyParameterizedConstructor() {
        assertEquals("Los Angeles", fullyParameterizedProperty.getCity());
        assertEquals("Jane Smith", fullyParameterizedProperty.getOwner());
        assertEquals("Villa", fullyParameterizedProperty.getPropertyName());
        assertEquals(5000.00, fullyParameterizedProperty.getRentAmount(), 0.001);
        assertEquals(2, fullyParameterizedProperty.getPlot().getX());
        assertEquals(3, fullyParameterizedProperty.getPlot().getY());
        assertEquals(4, fullyParameterizedProperty.getPlot().getWidth());
        assertEquals(5, fullyParameterizedProperty.getPlot().getDepth());
    }

    @Test
    void testSetCity() {
        defaultProperty.setCity("Seattle");
        assertEquals("Seattle", defaultProperty.getCity());
    }

    @Test
    void testSetOwner() {
        defaultProperty.setOwner("Elon Musk");
        assertEquals("Elon Musk", defaultProperty.getOwner());
    }

    @Test
    void testSetPropertyName() {
        defaultProperty.setPropertyName("Musk Manor");
        assertEquals("Musk Manor", defaultProperty.getPropertyName());
    }

    @Test
    void testSetRentAmount() {
        defaultProperty.setRentAmount(7000.00);
        assertEquals(7000.00, defaultProperty.getRentAmount(), 0.001);
    }

    @Test
    void testSetPlot() {
        Plot newPlot = new Plot(5, 6, 7, 8);
        defaultProperty.setPlot(newPlot);
        assertEquals(5, defaultProperty.getPlot().getX());
        assertEquals(6, defaultProperty.getPlot().getY());
        assertEquals(7, defaultProperty.getPlot().getWidth());
        assertEquals(8, defaultProperty.getPlot().getDepth());
    }

    @Test
    void testToString() {
        assertEquals("Estate,New York,John Doe,3500.0", parameterizedProperty.toString());
    }
}
