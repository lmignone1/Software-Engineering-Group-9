/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;


import Shapes.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;


/**
 *
 * @author loren
 */
public class Creator {
    
    public static Shape createShape(String mode, GraphicsContext gc, double x, double y, ColorPicker lineColor, ColorPicker fillColor){
        
        Shape shape = null;
        
        if(mode.equals("Line")){
            shape = ConcreteCreatorLine.createShape(gc, x, y, lineColor);
        }
        if(mode.equals("Rectangle")){
            shape = ConcreteCreatorRectangle.createShape(gc, x, y, lineColor, fillColor);
        }
        if(mode.equals("Ellipse")){
            shape = ConcreteCreatorEllipse.createShape(gc, x, y, lineColor, fillColor);
        }
        
        return shape;
    }
}
