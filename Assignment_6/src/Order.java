/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: The 'Order' class manages individual beverage orders, including their creation, calculation of total price, and sorting based on order numbers.
 * Due: 12/04/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Chelsy Gomes________
*/

import java.util.ArrayList;

public class Order implements OrderInterface, Comparable<Order> {
    private int orderNo;
    private int orderTime;
    private Day orderDay;
    private Customer cust;
    private ArrayList<Beverage> bevList;

    public Order(int orderTime, Day orderDay, Customer cust) {
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.cust = cust;
        this.bevList = new ArrayList<>();
        this.orderNo = generateOrder();
    }

    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        bevList.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    public void addNewBeverage(String bevName, Size size) {
        bevList.add(new Alcohol(bevName, size, isWeekend()));
    }

    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        bevList.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    public double calcOrderTotal() {
        double total = 0;
        for (Beverage bev : bevList) {
            total += bev.calcPrice();
        }
        return total;
    }

    public int compareTo(Order anotherOrder) {
        return Integer.compare(this.orderNo, anotherOrder.orderNo);
    }

    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage bev : bevList) {
            if (bev.getType() == type) {
                count++;
            }
        }
        return count;
    }

    private int generateOrder() {
        return (int) (Math.random() * (90000 - 10000) + 10000);
    }

    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < bevList.size()) {
            return bevList.get(itemNo);
        }
        return null;
    }

    public Customer getCustomer() {
        return cust;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public int getTotalItems() {
        return bevList.size();
    }

    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Order Number: " + orderNo +
                ", Order Time: " + orderTime +
                ", Order Day: " + orderDay +
                ", Customer: " + cust.getName() +
                ", Customer Age: " + cust.getAge() +
                "\nBeverages:\n");

        for (Beverage b : bevList) {
            result.append(b.toString()).append("\n");
        }
        result.append("Total Price: ").append(calcOrderTotal()).append("\n");
        return result.toString();
    }
}
