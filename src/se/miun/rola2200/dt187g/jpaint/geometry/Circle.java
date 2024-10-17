package se.miun.rola2200.dt187g.jpaint.geometry;
import java.awt.*;


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
        Point start = points.get(0);
        Point end = points.get(1);
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public double getCircumference() {
        if (!hasEndPoint()) {
            return 0;
        } else {
            return 2 * PI * getRadius();
        }
    }

    @Override
    public double getArea() {
        if (!hasEndPoint()) {
            return 0;
        } else {
            return getRadius() * getRadius() * PI;
        }
    }

    @Override
    public void draw() {
        System.out.println(toString());
    }

    @Override
    public void draw(java.awt.Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(Color.decode(getColor()));
        Point center = points.get(0);
        double radius = getRadius();
        
        // Calculate the bounding box for the oval
        int x = (int) (center.getX() - radius);
        int y = (int) (center.getY() - radius);
        int diameter = (int) (radius * 2);
    
        // Draw the oval (circle)
        graphics.fillOval(x, y, diameter, diameter);    }

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
        return "Circle[start=" +
        (points.size() > 0 ? String.format("[%s, %s]", points.get(0).getX(), points.get(0).getY()) : "N/A") +
        "; end=" +
        (points.size() > 1 ? String.format("[%s, %s]", points.get(1).getX(), points.get(1).getY()) : "N/A") +
        "; radius=" +
        (points.size() > 1 ? String.valueOf(getRadius()) : "N/A") +
        "; color=" + getColor() + "]";
    }
}
