/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Shapes.Shape;
import static java.nio.file.Files.size;

/**
 *
 * @author Acer
 */
public class ToMirrorCommand implements Command {

    private Select shape;
    private double degrees;
    public ToMirrorCommand(Select shape, double degrees) {
        this.shape = shape;
        this.degrees = degrees;
    }

    @Override
    public void execute() {
        this.shape.toMirror(degrees);
      
    }
    
    @Override
    public void undo() {
        int index;
        degrees=this.shape.getSelectedShape().getDegrees();
        
        if(this.shape.getSelectedShape() == null){
            return;
        }
        
        Shape oldShape = this.shape.getMemory().popStackShape();
        
        if(oldShape.getType()!="Line"){
        oldShape.setXY(oldShape.getX()-0.5*oldShape.getSizeX(), oldShape.getY()+0.5*oldShape.getSizeY());
        oldShape.setDegrees(-degrees);
        }
        
        if(oldShape.getType()=="Line"){
            oldShape.setXY(oldShape.getX()- 0.5*oldShape.getSizeX(),oldShape.getY());
            oldShape.setDegrees(-degrees);
        }
    }
}


