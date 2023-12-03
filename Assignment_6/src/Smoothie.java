/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: The 'Smoothie' class extends `Beverage` to calculate the price of smoothies, including options for additional fruits and protein.
 * Due: 12/04/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Chelsy Gomes________
*/

public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;

    private static final double FRUIT_PRICE = 0.5;
    private static final double PROTEIN_PRICE = 1.5;

    public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
        super(bevName, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    @Override
    public double calcPrice() {
        double price = super.getBasePrice() + (numOfFruits * FRUIT_PRICE);
        if (this.addProtein) {
            price += PROTEIN_PRICE;
        }
        return price + super.addSizePrice();
    }

    public boolean getAddProtein() {
        return addProtein;
    }

    public int getNumOfFruits() {
        return numOfFruits;
    }

    @Override
    public String toString() {
        return String.format("%s, Size: %s, Fruits: %d, Protein Added: %b, Price: $%.2f", 
                             super.getBevName(), super.getSize(), numOfFruits, addProtein, this.calcPrice());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Smoothie other = (Smoothie) obj;
        return numOfFruits == other.numOfFruits && addProtein == other.addProtein;
    }
}
