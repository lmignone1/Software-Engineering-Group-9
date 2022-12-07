/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Memory;

import Shapes.Shape;
import java.util.Stack;
import javafx.scene.control.ColorPicker;

/**
 *
 * @author Davide
 */
public class Memory {
    
    private Stack<Shape> stackShape;
    private Stack<Double> stackDouble;
    private Stack<ColorPicker> stackColor;

    public Memory() {
        this.stackShape = new Stack<>();
        this.stackDouble = new Stack<>();
        this.stackColor = new Stack<>();
    }

    public Shape getStackShape() {
        return this.stackShape.pop();
    }

    public Double getStackDouble() {
        return this.stackDouble.pop();
    }

    public ColorPicker getStackColor() {
        return this.stackColor.pop();
    }

    public void setStackShape(Shape selectedShape) {
        this.stackShape.add(selectedShape);
    }

    public void setStackDouble(Double number) {
        this.stackDouble.add(number);
    }

    public void setStackColor(ColorPicker color) {
        this.stackColor.add(color);
    }
}
