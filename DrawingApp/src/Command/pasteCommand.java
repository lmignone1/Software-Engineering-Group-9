/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author Davide
 */
public class pasteCommand implements Command {
    
    Select shape;
    private double x,y;

    public pasteCommand(Select shape, double x, double y) {
        this.shape = shape;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        this.shape.paste(this.x, this.y);
    }

    @Override
    public void undo() {
        this.shape.getShape().remove(shape.getCopyShape());
    }
    
    
    
}
