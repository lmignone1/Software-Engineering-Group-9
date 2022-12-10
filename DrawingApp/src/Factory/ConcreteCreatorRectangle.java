/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import Shapes.ConcreteShapeRectangles;
import Shapes.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

/**
 *
 * @author Acer
 */
public class ConcreteCreatorRectangle extends Creator{
    
    public static Shape createShape(GraphicsContext gc, double x, double y, ColorPicker lineColor, ColorPicker fillColor) {
        
        ConcreteShapeRectangles rect = new ConcreteShapeRectangles();
        
        rect.setGraphicsContext(gc);
        rect.setXY(x, y);
        rect.setLineColor(lineColor);
        rect.setFillColor(fillColor);
        
        return rect;   
    }
    
    public static Shape createShape(GraphicsContext gc, double x, double y, ColorPicker lineColor, ColorPicker fillColor, double sizeX, double sizeY, double degrees) {
        
        ConcreteShapeRectangles rect = new ConcreteShapeRectangles();
        
        rect.setGraphicsContext(gc);
        rect.setSizeX(sizeX);
        rect.setSizeY(sizeY);
        rect.setDegrees(degrees);
        rect.setXY(x, y);
        rect.setLineColor(lineColor);
        rect.setFillColor(fillColor);
        
        return rect;   
    }

    
    
    
}
