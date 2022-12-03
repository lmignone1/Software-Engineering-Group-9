/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Command.Command;
import Command.Command;
import Command.Select;
import Command.Select;
import Shapes.Shape;

/**
 *
 * @author Acer
 */
public class moveCommand implements Command{
     Select shape;
       double previousX;
       double previousY;
       double newX;
       double newY;
    public moveCommand(Select shape, double newX, double newY,double previousX,double previousY) {
        this.shape = shape;
        this.newX=newX;
        this.newY=newY;
        this.previousX=previousX;
        this.previousY=previousY;
    }
   
    @Override
    public void execute() {
        this.shape.move(this.newX,this.newY,this.previousX,this.previousY);
        
    }

    @Override
    public void undo() {
     Select.getSelectedShape().setXY(this.shape.getPreviousX(), this.shape.getPreviousY());
      
    }
    
}
