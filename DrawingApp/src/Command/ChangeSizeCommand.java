/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author artem
 */
public class ChangeSizeCommand implements Command {
    
    Select shape;
    double sizeX, sizeY;
    double previousX, previousY;

    public ChangeSizeCommand(Select shape, double sizeX, double sizeY, double previousX, double previousY) {
        this.shape = shape;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.previousX = previousX;
        this.previousY = previousY;
    }
    
    public ChangeSizeCommand(Select shape, double sizeX, double previousX, double previousY) {
        this.shape = shape;
        this.sizeX = sizeX;
        this.previousX = previousX;
        this.previousY = previousY;
    } 
    

    @Override
    public void execute() {
        this.shape.changeSize(this.sizeX, this.sizeY, this.previousX, this.previousY);
    }

    @Override
    public void undo() {
        if (this.shape.getSelectedShape().getType().equals("Line")){
            this.shape.getSelectedShape().setSizeX(shape.getPreviousSizeX());
            Select.getSelectedShape().setXY(this.shape.getPreviousX(), this.shape.getPreviousY());
        }
        else{
            this.shape.getSelectedShape().setSizeX(shape.getPreviousSizeX());
            this.shape.getSelectedShape().setSizeY(shape.getPreviousSizeY());
            Select.getSelectedShape().setXY(this.shape.getPreviousX(), this.shape.getPreviousY());
        }
    }
    
}
