/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import javafx.scene.control.ColorPicker;

/**
 *
 * @author Davide
 */
public class changeColorCommand implements Command {
    
    private Select shape;
    private ColorPicker lineColor;
    private ColorPicker fillColor;

    public changeColorCommand(Select shape, ColorPicker lineColor, ColorPicker fillColor) {
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
        this.shape.getSelectedShape().setLineColor(this.shape.getPreviusLineColor());
        this.shape.getSelectedShape().setFillColor(this.shape.getPreviusFillColor());
    }
    
}
