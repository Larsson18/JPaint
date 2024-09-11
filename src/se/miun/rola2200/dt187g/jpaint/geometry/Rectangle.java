package se.miun.rola2200.dt187g.jpaint.geometry;

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
        return Math.abs(points.get(1).getX() - points.get(0).getX());
    }

    public double getHeight() {
        if (!hasEndPoint()) {
            return 0;
        }
        return Math.abs(points.get(1).getY() - points.get(0).getY());
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
        if (points.size() < 2) {
            points.add(p);
        } else {
            points.set(1, p);
        }
    }

    @Override
    public void addPoint(double x, double y) {
        addPoint(new Point(x, y));
    }

    @Override
    public boolean hasEndPoint() {
        return points.size() == 2;
    }

    @Override
    public String toString() {
        String startStr = points.size() > 0 && points.get(0) != null
                ? String.format("[%s, %s]", points.get(0).getX(), points.get(0).getY())
                : "N/A";
        String endStr = points.size() > 1 && points.get(1) != null
                ? String.format("[%s, %s]", points.get(1).getX(), points.get(1).getY())
                : "N/A";
        String widthStr = points.size() > 1 && points.get(1) != null ? String.valueOf(getWidth()) : "N/A";
        String heightStr = points.size() > 1 && points.get(1) != null ? String.valueOf(getHeight()) : "N/A";

        return "Drawing a Rectangle[start=" + startStr + "; end=" + endStr + "; width=" + widthStr + "; height="
                + heightStr + "; color=" + getColor() + "]";

    }

}
