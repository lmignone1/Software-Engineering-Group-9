/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

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
        this.shape.move(x,y,shape.getSelectedShape());
    }

    @Override
    public void undo() {
      
    }
    
}
