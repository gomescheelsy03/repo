package application;

public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    // Default Constructor
    public Plot() {
        this(0, 0, 1, 1);
    }

    // Copy Constructor
    public Plot(Plot p) {
        this(p.x, p.y, p.width, p.depth);
    }

    // Parameterized Constructor
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public boolean overlaps(Plot p) {
        if (x + width <= p.x || p.x + p.width <= x || y + depth <= p.y || p.y + p.depth <= y) {
            return false;  // If one plot is to the left, right, above, or below the other, they don't overlap
        }
        return true;
    }

    public boolean encompasses(Plot p) {
        return x <= p.x && x + width >= p.x + p.width && y <= p.y && y + depth >= p.y + p.depth;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
