/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import Shapes.ConcreteShapeEllipses;
import Shapes.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;



/**
 *
 * @author loren
 */
public class ConcreteCreatorEllipse extends Creator {

    public static Shape createShape(GraphicsContext gc, double x, double y, ColorPicker lineColor, ColorPicker fillColor) {
        
        ConcreteShapeEllipses ellipse = new ConcreteShapeEllipses();
        
        ellipse.setGraphicsContext(gc);
        ellipse.setXY(x, y);
        ellipse.setLineColor(lineColor);
        ellipse.setFillColor(fillColor);
        
        return ellipse;   
    }
    public static Shape createShape(GraphicsContext gc, double x, double y, ColorPicker lineColor, ColorPicker fillColor, double sizeX, double sizeY, double degrees) {
        
        ConcreteShapeEllipses ellipse = new ConcreteShapeEllipses();
        
        ellipse.setGraphicsContext(gc);
        ellipse.setSizeX(sizeX);
        ellipse.setSizeY(sizeY);
        ellipse.setDegrees(degrees);
        ellipse.setXY(x, y);
        ellipse.setLineColor(lineColor);
        ellipse.setFillColor(fillColor);
        
        return ellipse;   
    }
    
}
