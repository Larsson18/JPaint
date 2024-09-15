package se.miun.rola2200.dt187g.jpaint;

import java.util.ArrayList;
import se.miun.rola2200.dt187g.jpaint.geometry.Shape;

public class Drawing implements Drawable {
    private ArrayList<Shape> shapes;
    private String name;
    private String author;

    public Drawing() {
    }

    public Drawing(String name, String author) {
        this.name = name;
        this.author = author;
        this.shapes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void addShape(Shape s) {
        if (s != null)
            shapes.add(s);
    }

    public int getSize() {
        return shapes.size();
    }

    public double getTotalCircumference() {
        double totalCircumference = 0;
        for (Shape s : shapes) {
            totalCircumference += s.getCircumference();
        }
        return totalCircumference;
    }

    public double getTotalArea() {
        double totalArea = 0;
        for (Shape s : shapes) {
            totalArea += s.getArea();
        }
        return totalArea;
    }

    public void draw() {
        System.out.println("Drawing: " + name);
        for (Shape s : shapes) {
            s.draw();
        }
    }

    public void draw(java.awt.Graphics g) {
        for (Shape s : shapes) {
            s.draw(g);
        }
    }

    @Override
    public String toString() {
        return "Drawing{" +
                "shapes=" + shapes +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }


    // String startStr = (points.size() > 0) ? String.format("[%s, %s]", points.get(0).getX(), points.get(0).getY()) : "N/A";
    // String endStr = (points.size() > 1) ? String.format("[%s, %s]", points.get(1).getX(), points.get(1).getY()) : "N/A";
    // String radiusStr = (points.size() > 1) ? String.valueOf(getRadius()) : "N/A";

    // return "Circle[start=" + startStr +
    //         "; end=" + endStr +
    //         "; radius=" + radiusStr +
    //         "; color=" + getColor() + "]";
    
}
