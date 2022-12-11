/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Shapes.Shape;

/**
 *
 * @author artem
 */
public class ChangeSizeCommand implements Command {

    private Select shape;
    double sizeX, sizeY;
    double previousX, previousY;

    public ChangeSizeCommand(Select shape, double sizeX, double sizeY) {
        this.shape = shape;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public ChangeSizeCommand(Select shape, double sizeX) {
        this.shape = shape;
        this.sizeX = sizeX;
    }

    @Override
    public void execute() {
        this.shape.changeSize(this.sizeX, this.sizeY);
    }

    @Override
    public void undo() {
        if (this.shape.getSelectedShape().getType().equals("Line")) {
            Shape oldShape = this.shape.getMemory().popStackShape();
            oldShape.setSizeX(this.shape.getMemory().popStackDouble());
            oldShape.setXY(this.shape.getMemory().popStackDouble(), this.shape.getMemory().popStackDouble());
        } else {
            Shape oldShape = this.shape.getMemory().popStackShape();
            oldShape.setSizeX(this.shape.getMemory().popStackDouble());
            oldShape.setSizeY(this.shape.getMemory().popStackDouble());
            oldShape.setXY(this.shape.getMemory().popStackDouble(), this.shape.getMemory().popStackDouble());
        }
    }

}
