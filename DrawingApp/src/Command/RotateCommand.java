/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Shapes.Shape;
import javafx.scene.transform.Affine;

/**
 *
 * @author loren
 */
public class RotateCommand implements Command{
    
    private Select shape;
    private double degrees;

    public RotateCommand(Select shape, double degrees) {
        this.shape = shape;
        this.degrees = degrees;
    }

    @Override
    public void execute() {
        this.shape.rotate(degrees);
    }

    @Override
    public void undo() {
        Shape oldShape = this.shape.getMemory().popStackShape();
        double oldDegrees = this.shape.getMemory().popStackDouble();
        oldShape.setDegrees(oldDegrees);
    }
}