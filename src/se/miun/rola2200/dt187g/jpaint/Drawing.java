package se.miun.rola2200.dt187g.jpaint;

import java.util.ArrayList;
import se.miun.rola2200.dt187g.jpaint.geometry.Shape;

public class Drawing implements Drawable {
    private ArrayList<Shape> shapes;
    private String name;

    public Drawing(String name) {
        this.name = name;
        this.shapes = new ArrayList<>();
    }

    public void addShape(Shape s) {
        shapes.add(s);
    }

    public void removeShape(Shape s) {
        shapes.remove(s);
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

}
