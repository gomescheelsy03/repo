/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: The 'Beverage' class is an abstract template for various beverages, including their name, size, and pricing methods.
 * Due: 12/04/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Chelsy Gomes________
*/

public abstract class Beverage {
    private String bevName; // Beverage name
    private Type type;      // Beverage type
    private Size size;      // Beverage size

    private static final double BASE_PRICE = 2.0; // Base price for all beverages
    private static final double SIZE_PRICE = 1.0; // Additional price to go a size up

    public Beverage(String bevName, Type type, Size size) {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }

    public abstract double calcPrice();

    public double addSizePrice() {
        switch (size) {
            case MEDIUM:
                return SIZE_PRICE; // Additional $1 for medium size
            case LARGE:
                return 2 * SIZE_PRICE; // Additional $2 for large size
            default:
                return 0; // No additional charge for small size
        }
    }

    public static double getBasePrice() {
        return BASE_PRICE;
    }

    public String getBevName() {
        return bevName;
    }

    public Size getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return bevName + ", " + size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Beverage other = (Beverage) obj;
        return bevName.equals(other.bevName) && type == other.type && size == other.size;
    }
        

    }
