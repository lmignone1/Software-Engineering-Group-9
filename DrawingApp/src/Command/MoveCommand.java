/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;



/**
 *
 * @author Acer
 */
public class MoveCommand implements Command {

    private Select shape;
    private double previousX;
    private double previousY;
    private double newX;
    private double newY;

    public MoveCommand(Select shape, double newX, double newY, double previousX, double previousY) {
        this.shape = shape;
        this.newX = newX;
        this.newY = newY;
        this.previousX = previousX;
        this.previousY = previousY;
    }

    @Override
    public void execute() {
        this.shape.move(this.newX, this.newY, this.previousX, this.previousY);

    }

    @Override
    public void undo() {

        this.shape.getStackShape().pop().setXY(this.shape.getMoveStack().pop().doubleValue(), this.shape.getMoveStack().pop().doubleValue());
        
        //Select.getSelectedShape().setXY(this.shape.getPreviousX(), this.shape.getPreviousY());

    }

}
