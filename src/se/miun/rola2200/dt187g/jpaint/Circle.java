package se.miun.rola2200.dt187g.jpaint;

/**
 * A class representing a circle, also defined by two points.
 * Provides methods for calculating radius, area, and circumference,
 * and for drawing itself.
 *
 * @rola2200
 * @version 1.0
 */

public class Circle extends Shape {

    private static final double PI = 3.14159265;

    public Circle(Point p, String color) {
        super(p, color);
    }

    public Circle(double x, double y, String color) {
        this(new Point(x, y), color);
    }

    public double getRadius() {
        if (!hasEndPoint()) {
            return 0;
        }
        double dx = points[1].getX() - points[0].getX();
        double dy = points[1].getY() - points[0].getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public double getCircumference() {
        if (!hasEndPoint()) {
            return 0;
        } else
            return 2 * PI * getRadius();
    }

    @Override
    public double getArea() {
        if (!hasEndPoint()) {
            return 0;
        } else
            return getRadius() * getRadius() * PI;
    }

    @Override
    public void draw() {
        System.out.println(toString());
    }

    @Override
    public void draw(java.awt.Graphics g) {

    }

    @Override
    public void addPoint(Point p) {
        points[1] = p;
    }

    @Override
    public void addPoint(double x, double y) {
        addPoint(new Point(x, y));
    }

    @Override
    public boolean hasEndPoint() {
        return points[1] != null;
    }

    @Override
    public String toString() {
        return "Circle[start=" +
                (points.length > 0 && points[0] != null ? String.format("[%s, %s]", points[0].getX(), points[0].getY())
                        : "N/A")
                +
                "; end=" +
                (points.length > 1 && points[1] != null ? String.format("[%s, %s]", points[1].getX(), points[1].getY())
                        : "N/A")
                +
                "; radius=" +
                (points.length > 1 && points[1] != null ? getRadius() : "N/A") +
                "; color=" + getColor() + "]";
    }
}
