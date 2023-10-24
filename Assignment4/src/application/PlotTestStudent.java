package application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlotTestStudent {

    private Plot defaultPlot;
    private Plot parameterizedPlot;
    private Plot copiedPlot;

    @Before
    public void setUp() throws Exception {
        defaultPlot = new Plot();
        parameterizedPlot = new Plot(1, 2, 3, 4);
        copiedPlot = new Plot(parameterizedPlot);
    }

    @After
    public void tearDown() {
        defaultPlot = parameterizedPlot = copiedPlot = null;
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(0, defaultPlot.getX());
        assertEquals(0, defaultPlot.getY());
        assertEquals(1, defaultPlot.getWidth());
        assertEquals(1, defaultPlot.getDepth());
    }

    @Test
    public void testParameterizedConstructor() {
        assertEquals(1, parameterizedPlot.getX());
        assertEquals(2, parameterizedPlot.getY());
        assertEquals(3, parameterizedPlot.getWidth());
        assertEquals(4, parameterizedPlot.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        assertEquals(parameterizedPlot.getX(), copiedPlot.getX());
        assertEquals(parameterizedPlot.getY(), copiedPlot.getY());
        assertEquals(parameterizedPlot.getWidth(), copiedPlot.getWidth());
        assertEquals(parameterizedPlot.getDepth(), copiedPlot.getDepth());
    }

    @Test
    public void testOverlaps() {
        Plot overlappingPlot = new Plot(2, 2, 2, 2);
        assertTrue(parameterizedPlot.overlaps(overlappingPlot));
    }

    @Test
    public void testEncompasses() {
        Plot smallerPlot = new Plot(2, 3, 1, 1);
        assertTrue(parameterizedPlot.encompasses(smallerPlot));
    }

    @Test
    public void testSettersAndGetters() {
        defaultPlot.setX(5);
        defaultPlot.setY(6);
        defaultPlot.setWidth(7);
        defaultPlot.setDepth(8);

        assertEquals(5, defaultPlot.getX());
        assertEquals(6, defaultPlot.getY());
        assertEquals(7, defaultPlot.getWidth());
        assertEquals(8, defaultPlot.getDepth());
    }

    @Test
    public void testToString() {
        assertEquals("1,2,3,4", parameterizedPlot.toString());
    }
}
