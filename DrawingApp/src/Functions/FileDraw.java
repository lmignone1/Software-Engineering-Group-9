/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import Factory.Creator;
import Shapes.Shape;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 *
 * @author loren
 */
public class FileDraw {
 
    public static void saveDraw(List<Shape> listShape, String path) throws IOException{
        
        try ( FileWriter f = new FileWriter(path + ".txt")) {
                for (Shape elem : listShape) {
                    f.write(elem.toString() + "\n");
                }
            }
    }
    
    public static void loadDraw(List<Shape> listShape, String path, GraphicsContext gc) throws IOException{
        FileReader f = null;
        BufferedReader b = null;
        
        try {
            f = new FileReader(path);
            b = new BufferedReader(f);
            while (true) {
                String line = b.readLine();
                String[] split = line.split(" ");
                Shape s = Creator.createShape(split[0], gc, Double.parseDouble(split[1]), Double.parseDouble(split[2]),
                        new ColorPicker(Color.valueOf(split[3])), new ColorPicker(Color.valueOf(split[4])),
                        Double.parseDouble(split[5]), Double.parseDouble(split[6]));
                s.draw();
                listShape.add(s);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error");
        } catch (NullPointerException e2) {
            f.close();
            b.close();
        }
    }
}
