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

    public Shape popStackShape() {
        return this.stackShape.pop();
    }

    public Double popStackDouble() {
        return this.stackDouble.pop();
    }

    public ColorPicker popStackColor() {
        return this.stackColor.pop();
    }

    public void addStackShape(Shape selectedShape) {
        this.stackShape.add(selectedShape);
    }

    public void addStackDouble(Double number) {
        this.stackDouble.add(number);
    }

    public void addStackColor(ColorPicker color) {
        this.stackColor.add(color);
    }

    public Stack<Shape> getStackShape() {
        return stackShape;
    }

    public Stack<Double> getStackDouble() {
        return stackDouble;
    }

    public Stack<ColorPicker> getStackColor() {
        return stackColor;
    }

}
