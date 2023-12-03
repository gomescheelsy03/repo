/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: The 'BevShopTestStudent' class contains tests to validate the functionality of the 'BevShop' class, such as order processing and sales calculations.
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

class BevShopTestStudent {
    private BevShop bevShop;

    @BeforeEach
    void setUp() {
        bevShop = new BevShop();
    }

    @Test
    void testIsValidTime() {
        assertTrue(bevShop.isValidTime(BevShopInterface.MIN_TIME));
        assertFalse(bevShop.isValidTime(BevShopInterface.MIN_TIME - 1));
        assertTrue(bevShop.isValidTime(BevShopInterface.MAX_TIME));
        assertFalse(bevShop.isValidTime(BevShopInterface.MAX_TIME + 1));
    }

    @Test
    void testGetMaxNumOfFruits() {
        assertEquals(BevShopInterface.MAX_FRUIT, bevShop.getMaxNumOfFruits());
    }

    @Test
    void testGetMinAgeForAlcohol() {
        assertEquals(BevShopInterface.MIN_AGE_FOR_ALCOHOL, bevShop.getMinAgeForAlcohol());
    }

    @Test
    void testIsMaxFruit() {
        assertTrue(bevShop.isMaxFruit(BevShopInterface.MAX_FRUIT));
        assertFalse(bevShop.isMaxFruit(BevShopInterface.MAX_FRUIT + 1));
    }

    @Test
    void testGetMaxOrderForAlcohol() {
        assertEquals(BevShopInterface.MAX_ORDER_FOR_ALCOHOL, bevShop.getMaxOrderForAlcohol());
    }

    @Test
    void testIsEligibleForMore() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 30);
        for (int i = 0; i < BevShopInterface.MAX_ORDER_FOR_ALCOHOL; i++) {
            bevShop.processAlcoholOrder("Beer", Size.SMALL);
        }
        assertFalse(bevShop.isEligibleForMore());
    }

    @Test
    void testGetNumOfAlcoholDrink() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 30);
        bevShop.processAlcoholOrder("Beer", Size.SMALL);
        assertEquals(1, bevShop.getNumOfAlcoholDrink());
    }

    @Test
    void testIsValidAge() {
        assertTrue(bevShop.isValidAge(BevShopInterface.MIN_AGE_FOR_ALCOHOL));
        assertFalse(bevShop.isValidAge(BevShopInterface.MIN_AGE_FOR_ALCOHOL - 1));
    }

    @Test
    void testStartNewOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 30);
        assertNotNull(bevShop.getCurrentOrder());
    }

    @Test
    void testProcessCoffeeOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 30);
        bevShop.processCoffeeOrder("Coffee", Size.MEDIUM, true, true);
        assertNotNull(bevShop.getCurrentOrder());
    }

    @Test
    void testProcessAlcoholOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 30);
        bevShop.processAlcoholOrder("Beer", Size.SMALL);
        assertNotNull(bevShop.getCurrentOrder());
    }

    @Test
    void testProcessSmoothieOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 30);
        bevShop.processSmoothieOrder("Smoothie", Size.MEDIUM, 3, true);
        assertNotNull(bevShop.getCurrentOrder());
    }

    @Test
    void testFindOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 30);
        int orderNo = bevShop.getCurrentOrder().getOrderNo();
        assertEquals(0, bevShop.findOrder(orderNo));
    }

    @Test
    void testTotalOrderPrice() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 30);
        bevShop.processCoffeeOrder("Coffee", Size.MEDIUM, true, true);
        int orderNo = bevShop.getCurrentOrder().getOrderNo();
        assertTrue(bevShop.totalOrderPrice(orderNo) > 0);
    }

    @Test
    void testTotalMonthlySale() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 30);
        bevShop.processCoffeeOrder("Coffee", Size.MEDIUM, true, true);
        assertTrue(bevShop.totalMonthlySale() > 0);
    }

    @Test
    void testTotalNumOfMonthlyOrders() {
        assertEquals(0, bevShop.totalNumOfMonthlyOrders());
        bevShop.startNewOrder(10, Day.MONDAY, "John", 30);
        assertEquals(1, bevShop.totalNumOfMonthlyOrders());
    }

    @Test
    void testGetCurrentOrderAndGetOrderAtIndex() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 30);
        assertNotNull(bevShop.getCurrentOrder());
        assertEquals(bevShop.getCurrentOrder(), bevShop.getOrderAtIndex(0));
    }

    @Test
    void testSortOrders() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 30);
        bevShop.startNewOrder(11, Day.TUESDAY, "Jane", 25);
        bevShop.sortOrders();
        assertTrue(bevShop.getOrderAtIndex(0).getOrderNo() <= bevShop.getOrderAtIndex(1).getOrderNo());
    }

    @Test
    void testToString() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 30);
        assertNotNull(bevShop.toString());
    }
}
