/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import Factory.ConcreteCreatorRectangle;
import Factory.ConcreteCreatorLine;
import Factory.ConcreteCreatorEllipse;
import Shapes.Shape;


/**
 *
 * @author loren
 */
public class Creator {
    
    public static Shape createShape(String mode){
        
        Shape shape = null;
        
        if(mode.equals("Line")){
            shape = ConcreteCreatorLine.createShape();
        }
        if(mode.equals("Rectangle")){
            shape = ConcreteCreatorRectangle.createShape();
        }
        if(mode.equals("Ellipse")){
            shape = ConcreteCreatorEllipse.createShape();
        }
        
        return shape;
    }
}
