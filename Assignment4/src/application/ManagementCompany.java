package application;

public class ManagementCompany {

    final int MAX_PROPERTY = 5;
    private final int MAX_WIDTH = 10;  // Equivalent to MGMT_WIDTH
    private final int MAX_DEPTH = 10;  // Equivalent to MGMT_DEPTH
    private Property[] properties;
    private double mgmFeePer;
    private String name;
    private String taxID;
    private Plot plot;

    // Default constructor
    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmFeePer = 0;
        this.plot = new Plot();
        this.properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.plot = new Plot(0, 0, MAX_WIDTH, MAX_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
    }

    // Copy Constructor
    public ManagementCompany(ManagementCompany otherCompany) {
        this.name = otherCompany.name;
        this.taxID = otherCompany.taxID;
        this.mgmFeePer = otherCompany.mgmFeePer;
        this.plot = new Plot(otherCompany.plot);
        this.properties = otherCompany.properties.clone();
    }

    public int addProperty(Property property) {
        if (property == null) {
            return -2;
        }
        if (!plot.encompasses(property.getPlot())) {
            return -3;
        }
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null) {
                if (properties[i].getPlot().overlaps(property.getPlot())) {
                    return -4;
                }
            } else {
                properties[i] = property;
                return i;
            }
        }
        return -1;
    }

    public int addProperty(String propertyName, String city, double rent, String ownerName) {
        return addProperty(new Property(propertyName, city, rent, ownerName));
    }

    public int addProperty(String propertyName, String city, double rent, String ownerName, int x, int y, int width, int depth) {
        return addProperty(new Property(propertyName, city, rent, ownerName, x, y, width, depth));
    }

    public double totalRent() {
        double total = 0;
        for (Property p : properties) {
            if (p != null) {
                total += p.getRentAmount();
            }
        }
        return total;
    }

    public int getPropertiesCount() {
        int count = 0;
        for (Property p : properties) {
            if (p != null) {
                count++;
            }
        }
        return count;
    }

    public Property getHighestRentPropperty() {
        double maxRent = Double.MIN_VALUE;
        Property maxProperty = null;
        for (Property p : properties) {
            if (p != null && p.getRentAmount() > maxRent) {
                maxRent = p.getRentAmount();
                maxProperty = p;
            }
        }
        return maxProperty;
    }

    public String maxPropertyRent() {
        Property maxRentProperty = getHighestRentPropperty();
        if (maxRentProperty != null) {
            return maxRentProperty.toString();
        }
        return "";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxID)
            .append("\n______________________________________________________\n");
        for (Property p : properties) {
            if (p != null) {
                sb.append(p).append("\n");
            }
        }
        sb.append("______________________________________________________\n\n")
        .append(" total management Fee: ").append(totalRent() * mgmFeePer / 100);

        return sb.toString();
    }

    public double getTotalRent() {
        return totalRent();
    }

    public boolean isMangementFeeValid() {
        return mgmFeePer >= 0 && mgmFeePer <= 100;
    }

    public boolean isPropertiesFull() {
        return getPropertiesCount() == MAX_PROPERTY;
    }

    public void removeLastProperty() {
        int lastPropertyIndex = getPropertiesCount() - 1;
        if (lastPropertyIndex >= 0) {
            properties[lastPropertyIndex] = null;
        }
    }

    public Property[] getProperties() {
        return properties.clone();
    }

    public int getMAX_PROPERTY() {
        return MAX_PROPERTY;
    }

    public Plot getPlot() {
        return plot;
    }

    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public double getMgmFeePer() {
        return mgmFeePer;
    }
}
