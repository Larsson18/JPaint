package se.miun.rola2200.dt187g.jpaint;

import java.util.ArrayList;
import se.miun.rola2200.dt187g.jpaint.geometry.Shape;

/**
 * The Drawing class represents a collection of shapes that together form a drawing.
 * It implements the Drawable interface to allow for drawing operations.
 * 
 * The Drawing class maintains a list of shapes and provides functionality to manage these shapes,
 * including adding shapes, calculating total circumference and area, and drawing the entire collection.
 * The class also manages metadata about the drawing such as its name and author.
 * 
 * @rola2200
 * @version 1.0
 */

public class Drawing implements Drawable {
    private ArrayList<Shape> shapes;
    private String name;
    private String author;

    public Drawing() {
        shapes = new ArrayList<>();
    }

    public Drawing(String name, String author) throws DrawingException {
        if (name == null || name.isEmpty() || author == null || author.isEmpty()) {
            throw new DrawingException("name and author can't be null or empty");
        }
        this.name = name;
        this.author = author;
        this.shapes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws DrawingException {
        if (name == null) {
            throw new DrawingException("Name", true);
        } else if (name.trim().isEmpty()) {
            throw new DrawingException("Name", false);
        } else {
            this.name = name;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws DrawingException {
        if (author == null) {
            throw new DrawingException("Author", true);
        } else if (author.trim().isEmpty()) {
            throw new DrawingException("Author", false);
        } else {
            this.author = author;
        }
    }

    public void addShape(Shape shape) {
        if (shape != null) {
            shapes.add(shape);
            System.out.println("Shape added: " + shape);
        } else {
            System.out.println("Null shape cannot be added.");
        }
    }

    public int getSize() {
        return shapes.size();
    }

    public double getTotalCircumference() {
        double totalCircumference = 0;
        if (shapes != null) {
            for (Shape shape : shapes) {
                if (shape.getCircumference() > 0) {
                    totalCircumference += shape.getCircumference();
                }
            }
        }
        return totalCircumference;
    }

    public double getTotalArea() {
        double totalArea = 0;
        if (shapes != null) {
            for (Shape shape : shapes) {
                if (shape.getArea() > 0) {
                    totalArea += shape.getArea();
                }
            }
        }
        return totalArea;
    }

    public void removeShape(int Index) {
		shapes.remove(Index); 
	}

    public void draw() {
        System.out.println("A drawing by " + author + " called " + name);
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    @Override
    public void draw(java.awt.Graphics g) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    @Override
    public String toString() {
        return "Drawing[name=" + (name != null ? name : "") +
                ", author=" + (author != null ? author : "") +
                ", size=" + (shapes != null ? shapes.size() : 0) +
                ", totalCircumference=" + (shapes != null && !shapes.isEmpty() ? getTotalCircumference() : 0) +
                ", totalArea=" + (shapes != null ? getTotalArea() : 0) + "]";
    }

}
