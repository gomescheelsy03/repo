/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: Tests the 'Order' class, covering beverage additions, total calculations, and utility functions.
 * Due: 12/04/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Chelsy Gomes________
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderTestStudent {
    private Order order;
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("John Doe", 30);
        order = new Order(10, Day.MONDAY, customer);
    }

    @Test
    void testOrderConstructor() {
        assertNotNull(order);
        assertEquals(10, order.getOrderTime());
        assertEquals(Day.MONDAY, order.getOrderDay());
        assertEquals(customer, order.getCustomer());
    }

    @Test
    void testAddNewBeverageCoffee() {
        order.addNewBeverage("Coffee", Size.MEDIUM, true, true);
        assertNotNull(order.getBeverage(0));
        assertTrue(order.getBeverage(0) instanceof Coffee);
    }

    @Test
    void testAddNewBeverageAlcohol() {
        order.addNewBeverage("Wine", Size.LARGE);
        assertNotNull(order.getBeverage(0));
        assertTrue(order.getBeverage(0) instanceof Alcohol);
    }

    @Test
    void testAddNewBeverageSmoothie() {
        order.addNewBeverage("Smoothie", Size.SMALL, 2, false);
        assertNotNull(order.getBeverage(0));
        assertTrue(order.getBeverage(0) instanceof Smoothie);
    }

    @Test
    void testCalcOrderTotal() {
        order.addNewBeverage("Coffee", Size.MEDIUM, false, false);
        order.addNewBeverage("Wine", Size.LARGE);
        double total = order.calcOrderTotal();
        assertTrue(total > 0);
    }

    @Test
    void testCompareTo() {
        Order anotherOrder = new Order(11, Day.TUESDAY, customer);
        assertTrue(order.compareTo(anotherOrder) != 0);
    }

    @Test
    void testFindNumOfBeveType() {
        order.addNewBeverage("Coffee", Size.MEDIUM, true, true);
        order.addNewBeverage("Coffee", Size.SMALL, false, false);
        assertEquals(2, order.findNumOfBeveType(Type.COFFEE));
    }

    @Test
    void testGetBeverage() {
        order.addNewBeverage("Smoothie", Size.MEDIUM, 2, true);
        Beverage bev = order.getBeverage(0);
        assertNotNull(bev);
        assertTrue(bev instanceof Smoothie);
    }

    @Test
    void testGetTotalItems() {
        order.addNewBeverage("Coffee", Size.MEDIUM, true, true);
        assertEquals(1, order.getTotalItems());
    }

    @Test
    void testIsWeekend() {
        Order weekendOrder = new Order(10, Day.SATURDAY, customer);
        assertTrue(weekendOrder.isWeekend());
        assertFalse(order.isWeekend());
    }

    @Test
    void testToString() {
        assertNotNull(order.toString());
    }
}

