package application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
    ManagementCompany mgmt;

    @Before
    public void setUp() throws Exception {
        mgmt = new ManagementCompany("Titan", "31415", 5);
        mgmt.addProperty("Orange Valley", "Beltville", 2750, "Troy Lawrence", 2, 1, 3, 3);
        mgmt.addProperty("Leeson Heights", "Arlington", 1450, "Albert Robinson", 6, 1, 2, 2);
        mgmt.addProperty("Sunday Plains", "Virginia Beach", 3250, "Mike Inez", 2, 5, 3, 3);
    }

    @After
    public void tearDown() {
        mgmt = null;
    }

    @Test
    public void testAddPropertyDefaultPlot() {
        assertEquals(3, mgmt.addProperty("Baradur", "Mordor", 500, "Sauron"));
        assertEquals(4, mgmt.addProperty("Rivendell", "Arnor", 4500, "Elrond", 5, 5, 2, 2));
        assertEquals(-1, mgmt.addProperty("Orthanc", "Isengard", 3100, "Saruman", 7, 4, 2, 2));
    }

    @Test
    public void testMaxPropertyRent() {
        double maxRent = mgmt.getHighestRentPropperty().getRentAmount();
        assertEquals(3250.0, maxRent, 0.001);
    }

    @Test
    public void testTotalRent() {
        assertEquals(7450, mgmt.totalRent(), 0.001);
    }

    @Test
    public void testGetTotalRent() {
        assertEquals(7450, mgmt.getTotalRent(), 0.001);
    }

    @Test
    public void testIsManagementFeeValid() {
        assertTrue(mgmt.isMangementFeeValid());
    }

    @Test
    public void testIsPropertiesFull() {
        assertFalse(mgmt.isPropertiesFull()); // As it's not yet full in the setup
    }

    @Test
    public void testGetProperties() {
        Property[] properties = mgmt.getProperties();
        assertNotNull(properties);
        assertEquals(mgmt.getMAX_PROPERTY(), properties.length); // Fixed this line
    }

    @Test
    public void testRemoveLastProperty() {
        mgmt.removeLastProperty();
        assertEquals(2, mgmt.getPropertiesCount());
    }

    @Test
    public void testGetPropertiesCount() {
        assertEquals(3, mgmt.getPropertiesCount());
    }

    @Test
    public void testGetMgmFeePer() {
        assertEquals(5, mgmt.getMgmFeePer(), 0.001);
    }

    @Test
    public void testGetPlot() {
        assertNotNull(mgmt.getPlot());
    }

    @Test
    public void testGetName() {
        assertEquals("Titan", mgmt.getName());
    }

    @Test
    public void testGetTaxID() {
        assertEquals("31415", mgmt.getTaxID());
    }

}
