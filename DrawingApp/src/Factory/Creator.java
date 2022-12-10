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
        if(mode.equals("Text")){
            shape = ConcreteCreatorText.createShape(gc, x, y, lineColor, fillColor);
        }
        
        return shape;
    }
    
    public static Shape createShape(String mode, GraphicsContext gc, double x, double y, ColorPicker lineColor, ColorPicker fillColor, double sizeX, double sizeY, double degrees){
        
        Shape shape = null;
        
        if(mode.equals("Line")){
            shape = ConcreteCreatorLine.createShape(gc, x, y, lineColor, sizeX, degrees);
        }
        if(mode.equals("Rectangle")){
            shape = ConcreteCreatorRectangle.createShape(gc, x, y, lineColor, fillColor, sizeX, sizeY, degrees);
        }
        if(mode.equals("Ellipse")){
            shape = ConcreteCreatorEllipse.createShape(gc, x, y, lineColor, fillColor, sizeX, sizeY, degrees);
        }
        if(mode.equals("Text")){
            shape = ConcreteCreatorText.createShape(gc, x, y, lineColor, fillColor);
        }
        
        return shape;
    }
    
    public static Shape createShape(String mode, GraphicsContext gc, double x, double y, ColorPicker lineColor, ColorPicker fillColor, double sizeX, double sizeY, String string, double degrees){
        
        Shape shape = null;
        
        if(mode.equals("Line")){
            shape = ConcreteCreatorLine.createShape(gc, x, y, lineColor, sizeX, degrees);
        }
        if(mode.equals("Rectangle")){
            shape = ConcreteCreatorRectangle.createShape(gc, x, y, lineColor, fillColor, sizeX, sizeY, degrees);
        }
        if(mode.equals("Ellipse")){
            shape = ConcreteCreatorEllipse.createShape(gc, x, y, lineColor, fillColor, sizeX, sizeY, degrees);
        }
        if(mode.equals("Text")){
            shape = ConcreteCreatorText.createShape(gc, x, y, lineColor, fillColor, string, degrees);
        }
        
        return shape;
    }

}
