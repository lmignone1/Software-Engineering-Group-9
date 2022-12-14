/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Shapes.Shape;
import javafx.scene.control.ColorPicker;

/**
 *
 * @author Davide
 */
public class ChangeColorCommand implements Command {

    private Select shape;
    private ColorPicker lineColor;
    private ColorPicker fillColor;

    public ChangeColorCommand(Select shape, ColorPicker lineColor, ColorPicker fillColor) {
        this.shape = shape;
        this.lineColor = lineColor;
        this.fillColor = fillColor;
    }

    @Override
    public void execute() {
        this.shape.changeColor(this.lineColor, this.fillColor);
    }

    @Override
    public void undo() {

        if (this.shape.getSelectedShape().getType().equals("Line")) {
            this.shape.getMemory().popStackShape().setLineColor(this.shape.getMemory().popStackColor());
        } else {
            Shape oldShape = this.shape.getMemory().popStackShape();
            oldShape.setFillColor(this.shape.getMemory().popStackColor());
            oldShape.setLineColor(this.shape.getMemory().popStackColor());
        }

    }

}
