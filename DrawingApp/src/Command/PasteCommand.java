/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author Davide
 */
public class PasteCommand implements Command {
    
    private Select shape;
    private double x, y;

    public PasteCommand(Select shape, double x, double y) {
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
        this.shape.getShape().remove(this.shape.getMemory().popStackShape());

    }
    
}
