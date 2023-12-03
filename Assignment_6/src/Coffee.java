/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: The 'Coffee' class extends 'Beverage' to calculate the price of coffee, accounting for optional extra shots and syrup.
 * Due: 12/04/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Chelsy Gomes________
*/

public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;

    private static final double EXTRA_SHOT_PRICE = 0.5;
    private static final double EXTRA_SYRUP_PRICE = 0.5;

    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        super(bevName, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = super.getBasePrice();
        if (this.extraShot) {
            price += EXTRA_SHOT_PRICE;
        }
        if (this.extraSyrup) {
            price += EXTRA_SYRUP_PRICE;
        }
        return price + super.addSizePrice();
    }

    public boolean getExtraShot() {
        return extraShot;
    }

    public boolean getExtraSyrup() {
        return extraSyrup;
    }

    @Override
    public String toString() {
        return String.format("%s, Size: %s, Extra Shot: %b, Extra Syrup: %b, Price: $%.2f", 
                             super.getBevName(), super.getSize(), extraShot, extraSyrup, this.calcPrice());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Coffee other = (Coffee) obj;
        return extraShot == other.extraShot && extraSyrup == other.extraSyrup;
    }
}