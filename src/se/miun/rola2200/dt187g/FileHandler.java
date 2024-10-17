package se.miun.rola2200.dt187g;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import se.miun.rola2200.dt187g.jpaint.Drawable;
import se.miun.rola2200.dt187g.jpaint.Drawing;

public class FileHandler  {
    // Sluta skriv skitkod dumma jävla Larsson!
    
    public static void save(Drawing drawing, String fileName){
        if (!fileName.endsWith(".shape")) {
            fileName += ".shape";
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(drawing);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Drawing load(String fileName){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Drawing drawing = (Drawing) ois.readObject();
            return drawing;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
