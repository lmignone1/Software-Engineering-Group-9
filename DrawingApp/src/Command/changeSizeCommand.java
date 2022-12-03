/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author artem
 */
public class changeSizeCommand implements Command {
    
    Select shape;
    double sizeX, sizeY;

    public changeSizeCommand(Select shape, double sizeX, double sizeY) {
        this.shape = shape;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
    
    public changeSizeCommand(Select shape, double sizeX) {
        this.shape = shape;
        this.sizeX = sizeX;
        //this.sizeY = 0;
    }
    

    @Override
    public void execute() {
        this.shape.changeSize(this.sizeX, this.sizeY);
    }

    @Override
    public void undo() {
        this.shape.getSelectedShape().setSizeX(shape.getPreviousSizeX());
        this.shape.getSelectedShape().setSizeY(shape.getPreviousSizeY());
    }
    
}
