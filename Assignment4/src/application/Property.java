package application;

public class Property {

    private String city;
    private String owner;
    private String propertyName;
    private double rentAmount;
    private Plot plot;

    // Constructors
    public Property() {
        this.city = "";
        this.owner = "";
        this.propertyName = "";
        this.rentAmount = 0;
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.city = city;
        this.owner = owner;
        this.propertyName = propertyName;
        this.rentAmount = rentAmount;
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.city = city;
        this.owner = owner;
        this.propertyName = propertyName;
        this.rentAmount = rentAmount;
        this.plot = new Plot(x, y, width, depth);
    }

    public Property(Property otherProperty) {
        this.city = otherProperty.city;
        this.owner = otherProperty.owner;
        this.propertyName = otherProperty.propertyName;
        this.rentAmount = otherProperty.rentAmount;
        this.plot = new Plot(otherProperty.plot);
    }

    // Getters and Setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public void setPlot(int x, int y, int width, int depth) {
        this.plot = new Plot(x, y, width, depth);
    }

    // equals method to compare two Property objects
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Property property = (Property) obj;

        if (Double.compare(property.rentAmount, rentAmount) != 0) {
            return false;
        }
        if (!city.equals(property.city)) {
            return false;
        }
        if (!owner.equals(property.owner)) {
            return false;
        }
        if (!propertyName.equals(property.propertyName)) {
            return false;
        }
        return plot.equals(property.plot);
    }

    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}
