package se.miun.rola2200.dt187g.jpaint;

/**
 * A class representing a rectangle, defined by a starting point
 * and an endpoint. Provides methods for calculating width,
 * height, area, and circumference, and for drawing itself.
 *
 * @rola2200
 * @version 1.0
 */

public class Rectangle extends Shape {

    public Rectangle(Point p, String color) {
        super(p, color);
    }

    public Rectangle(double x, double y, String color) {
        this(new Point(x, y), color);
    }

    public double getWidth() {
        if (!hasEndPoint()) {
            return 0;
        }
        return Math.abs(points[1].getX() - points[0].getX());
    }

    public double getHeight() {
        if (!hasEndPoint()) {
            return 0;
        }
        return Math.abs(points[1].getY() - points[0].getY());
    }

    @Override
    public double getCircumference() {
        if (!hasEndPoint()) {
            return 0;
        } else
            return 2 * (getWidth() + getHeight());
    }

    @Override
    public double getArea() {
        if (!hasEndPoint()) {
            return 0;
        } else
            return getWidth() * getHeight();
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
        if (points[1] == null) {
            points[1] = p;
        } else {
            points[1] = p;
        }
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
        return "Drawing a Rectangle[start=" +
                (points.length > 0 && points[0] != null ? String.format("[%s, %s]", points[0].getX(), points[0].getY())
                        : "N/A")
                +
                "; end=" +
                (points.length > 1 && points[1] != null ? String.format("[%s, %s]", points[1].getX(), points[1].getY())
                        : "N/A")
                +
                "; width=" +
                (points.length > 1 && points[1] != null ? getWidth() : "N/A") +
                "; height=" +
                (points.length > 1 && points[1] != null ? getHeight() : "N/A") +
                "; color=" + getColor() + "]";
    }

}
