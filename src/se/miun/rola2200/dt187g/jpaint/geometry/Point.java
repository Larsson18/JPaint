package se.miun.rola2200.dt187g.jpaint.geometry;

/**
 * A class representing a point in 2D space, defined by x and y coordinates.
 * This class provides methods to get and set the x and y values, as well as
 * a default constructor that initializes the point at (0.0, 0.0).
 *
 * @rola2200
 * @version 1.0
 */

public class Point {
    double x;
    double y;

    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setx(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Adding [" + x + ", " + y + "]";

    }
}
