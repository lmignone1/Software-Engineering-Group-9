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
public class ToFrontCommand implements Command {

    private Select shape;
    private double index;
    private double size;
    public ToFrontCommand(Select shape, double index, double size) {
        this.shape = shape;
        this.index=index;
        this.size=size;
    }

    @Override
    public void execute() {
        
        this.shape.toFront(size);
    }

    @Override
    public void undo() {
        this.shape.toBack(index);
        
    }

}
