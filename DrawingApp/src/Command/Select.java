/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Factory.Creator;
import Shapes.Shape;
import java.util.List;
import java.util.Stack;
import javafx.geometry.Point2D;
import javafx.scene.control.ColorPicker;
import javafx.scene.effect.Light.Point;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;

import javafx.scene.control.ColorPicker;

/**
 *
 * @author Davide //Receiver
 */
public class Select {

    private List<Shape> list;
    private static Shape selectedShape;
    private Shape copyShape;
    private Shape changeShape;
    private Creator creator = new Creator();
    private ColorPicker previusLineColor;
    private ColorPicker previusFillColor;
    private double previousSizeX, previousSizeY;
    private double previousX, previousY;
    private Stack<Shape> stackShape;
    private Shape pasteShape;
    private Stack<Double> moveStack;

    public Select(List<Shape> shape, Shape selectedShape) {
        this.list = shape;
        Select.selectedShape = selectedShape;
        this.stackShape = new Stack<>();
        this.moveStack = new Stack<>();
    }

    public List<Shape> getShape() {
        return list;
    }
    
    /*
    public void setShape(List<Shape> shape) {
        this.list = shape;
    }
    */
    
    public static Shape getSelectedShape() {
        return selectedShape;
    }

    public static void setSelectedShape(Shape selectedShape) {
        Select.selectedShape = selectedShape;
    }

    public Shape getCopyShape() {
        return copyShape;
    }

    public void setCopyShape(Shape copyShape) {
        this.copyShape = copyShape;
    }

    public ColorPicker getPreviusLineColor() {
        return previusLineColor;
    }

    public void setPreviusLineColor(ColorPicker previusLineColor) {
        this.previusLineColor = previusLineColor;
    }

    public ColorPicker getPreviusFillColor() {
        return previusFillColor;
    }

    public void setPreviusFillColor(ColorPicker previusFillColor) {
        this.previusFillColor = previusFillColor;
    }

    public double getPreviousSizeX() {
        return previousSizeX;
    }

    public void setPreviousSizeX(double previousSizeX) {
        this.previousSizeX = previousSizeX;
    }

    public double getPreviousSizeY() {
        return previousSizeY;
    }

    public void setPreviousSizeY(double previousSizeY) {
        this.previousSizeY = previousSizeY;
    }

    public double getPreviousX() {
        return previousX;
    }

    public double getPreviousY() {
        return previousY;
    }

    public void setPreviousX(double previousX) {
        this.previousX = previousX;
    }

    public void setPreviousY(double previousY) {
        this.previousY = previousY;
    }
    
    public Stack<Shape> getStackShape() {
        return stackShape;
    }
    
    public void setStackShape(Stack<Shape> stackShape) {
        this.stackShape = stackShape;
    }

    public Stack<Double> getMoveStack() {
        return moveStack;
    }

    public void setMoveStack(Stack<Double> moveStack) {
        this.moveStack = moveStack;
    }
    
    public void delete() {
        list.remove(Select.selectedShape);
        stackShape.add(Select.selectedShape);
    }

    public void copy() {

        if (Select.getSelectedShape().getType().equals("Line")) {
            this.copyShape = creator.createShape(Select.selectedShape.getType(), Select.selectedShape.getGraphicsContext(), Select.selectedShape.getX(), Select.selectedShape.getY(), Select.selectedShape.getLineColor(), null, Select.selectedShape.getSizeX(), 0);
        } else {
            this.copyShape = creator.createShape(Select.selectedShape.getType(), Select.selectedShape.getGraphicsContext(), Select.selectedShape.getX(), Select.selectedShape.getY(), Select.selectedShape.getLineColor(), Select.selectedShape.getFillColor(), Select.selectedShape.getSizeX(), Select.selectedShape.getSizeY());
        }
        
        this.stackShape.add(this.copyShape);
    }


    public void paste(double x, double y) {
        
        if (this.copyShape.getType().equals("Line")) {
                this.pasteShape = creator.createShape(this.copyShape.getType(), this.copyShape.getGraphicsContext(), this.copyShape.getX(), this.copyShape.getY(), this.copyShape.getLineColor(), null, this.copyShape.getSizeX(), 0);
        } else {
                this.pasteShape = creator.createShape(this.copyShape.getType(), this.copyShape.getGraphicsContext(), this.copyShape.getX(), this.copyShape.getY(), this.copyShape.getLineColor(), this.copyShape.getFillColor(), this.copyShape.getSizeX(), this.copyShape.getSizeY());
            }
        this.pasteShape.setXY(x, y);
        this.list.add(this.pasteShape);
        this.stackShape.add(this.pasteShape);
        
    }

    public void cut() {
        this.copyShape = Select.selectedShape;
        delete();
    }

    public void move(double newX, double newY, double previousX, double previousY) { 
        setPreviousX(previousX);
        setPreviousY(previousY);
        
        Double provaX = new Double(previousX);
        Double provaY = new Double(previousY);
        
        
        this.moveStack.add(provaY);
        this.moveStack.add(provaX);
        
        selectedShape.setXY(newX, newY);
        this.stackShape.add(selectedShape);
    }

    public void changeColor(ColorPicker lineColor, ColorPicker fillColor) {

        if (Select.selectedShape.getType().equals("Line")) {
            setPreviusLineColor(Select.selectedShape.getLineColor());
        } else {
            setPreviusLineColor(Select.selectedShape.getLineColor());
            setPreviusFillColor(Select.selectedShape.getFillColor());
        }

        if (Select.selectedShape.getType().equals("Line")) {
            Select.selectedShape.setLineColor(lineColor);
        } else {
            Select.selectedShape.setLineColor(lineColor);
            Select.selectedShape.setFillColor(fillColor);
        }
    }

    public void changeSize(double sizeX, double sizeY, double previousX, double previousY) {
        if (Select.selectedShape.getType().equals("Line")) {
            setPreviousSizeX(Select.selectedShape.getSizeX());
            setPreviousX(previousX);
            setPreviousY(previousY);
        } else {
            setPreviousSizeX(Select.selectedShape.getSizeX());
            setPreviousSizeY(Select.selectedShape.getSizeY());
            setPreviousX(previousX);
            setPreviousY(previousY);
        }

        if (Select.selectedShape.getType().equals("Line")) {
            Select.selectedShape.setSizeX(sizeX);
            Select.selectedShape.setXY(Select.selectedShape.getX(), Select.selectedShape.getY());
        } else {
            Select.selectedShape.setSizeX(sizeX);
            Select.selectedShape.setSizeY(sizeY);
            Select.selectedShape.setXY(Select.selectedShape.getX(), Select.selectedShape.getY());
        }
    }
}
