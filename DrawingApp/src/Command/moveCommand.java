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
       double x;
       double y;
    public moveCommand(Select shape, double x, double y) {
        this.shape = shape;
        this.x=x;
        this.y=y;
    }
   
    @Override
    public void execute() {
        this.shape.move(this.x,this.y);
    }

    @Override
    public void undo() {
      
    }
    
}
