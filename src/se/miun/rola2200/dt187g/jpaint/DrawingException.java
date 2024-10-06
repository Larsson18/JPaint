package se.miun.rola2200.dt187g.jpaint;

public class DrawingException  extends Exception {
    public DrawingException(String message) {
        super(message);
    }

    public DrawingException(String parameter, boolean isNull) {
        super(isNull ? parameter + " cannot be null." : parameter + " cannot be empty.");
    }

}
