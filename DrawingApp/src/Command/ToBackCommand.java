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
public class ToBackCommand implements Command {

    private Select shape;
    private double index;
    
    public ToBackCommand(Select shape, double index) {
        this.shape = shape;
        this.index=index;
        
    }

    @Override
    public void execute() {
        
        this.shape.toBack(0);
    }

    @Override
    public void undo() {
        //this.shape.toBack(index);
        Shape oldShape = this.shape.getMemory().popStackShape();
        this.shape.getShape().remove(oldShape);
        this.shape.getShape().add((int)index,oldShape);
        
    }

}
