/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: The 'Alcohol' class extends 'Beverage' to calculate and represent the price and details of alcoholic beverages, with a weekend surcharge feature.
 * Due: 12/04/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Chelsy Gomes________
*/


public class Alcohol extends Beverage {
    private boolean isWeekend;
    private static final double WEEKEND_SURCHARGE = 0.6;

    public Alcohol(String bevName, Size size, boolean isWeekend) {
        super(bevName, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    @Override
    public double calcPrice() {
        double price = super.getBasePrice();
        if (this.isWeekend) {
            price += WEEKEND_SURCHARGE;
        }
        return price + super.addSizePrice();
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    @Override
    public String toString() {
        return String.format("%s, Size: %s, Weekend: %b, Price: $%.2f",
                             super.getBevName(), super.getSize(), isWeekend, this.calcPrice());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Alcohol other = (Alcohol) obj;
        return isWeekend == other.isWeekend;
    }

        
    }
