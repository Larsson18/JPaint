package se.miun.rola2200.dt187g.jpaint.geometry;

import se.miun.rola2200.dt187g.jpaint.Drawable;
import java.util.ArrayList;

/**
 * An abstract class representing the general concept of a shape.
 * It defines common properties and abstract methods that all shapes must
 * implement,
 * such as calculating area and circumference, and methods for drawing.
 * Also implements the Drawable interface to allow for drawing shapes.
 * 
 * @rola2200
 * @version 1.0
 */

public abstract class Shape implements Drawable {
    private String color;
    protected ArrayList<Point> points;

    public Shape(Point p, String color) {
        this.color = color;
        this.points = new ArrayList<>();
        this.points.add(p);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double getCircumference();

    public abstract double getArea();

    public void addPoint(Point p){
        this.points.add(p);
    }

    public void addPoint(double x, double y) {
        this.points.add(new Point(x, y));
    }

    public abstract boolean hasEndPoint();
}
