package se.miun.rola2200.dt187g.jpaint;

/**
 * An interface specifying the methods required for drawing shapes.
 * Classes that implement this interface must provide methods to to specify what to draw and how to draw it.
 * Eg. draw a shape to the console or to a graphical window.
 * 
 * @rola2200
 * @version 1.0
 */

public interface Drawable {

    void draw();

    void draw(java.awt.Graphics g);
}
