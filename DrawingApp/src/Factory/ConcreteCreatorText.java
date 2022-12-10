/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import Shapes.ConcreteText;
import Shapes.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

/**
 *
 * @author artem
 */
public class ConcreteCreatorText extends Creator{
    
    public static Shape createShape(GraphicsContext gc, double x, double y, ColorPicker lineColor, ColorPicker fillColor, String string, double degrees) {
        
        ConcreteText text = new ConcreteText();
        
        text.setGraphicsContext(gc);
        text.setXY(x, y);
        text.setDegrees(degrees);
        text.setLineColor(lineColor);
        text.setFillColor(fillColor);
        text.setText(string);
        
        return text;   
    }

    static Shape createShape(GraphicsContext gc, double x, double y, ColorPicker lineColor, ColorPicker fillColor) {
        ConcreteText text = new ConcreteText();
        
        text.setGraphicsContext(gc);
        text.setXY(x, y);
        text.setLineColor(lineColor);
        text.setFillColor(fillColor);
        
        return text;
    }
}
