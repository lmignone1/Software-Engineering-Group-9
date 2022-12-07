/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Factory.Creator;
import Shapes.Shape;
import java.util.List;
import java.util.Stack;

import javafx.scene.control.ColorPicker;

/**
 *
 * @author Davide //Receiver
 */
public class Select {

    private List<Shape> list;
    private Shape selectedShape;
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
    private Stack<ColorPicker> colorStack;

    public Select(List<Shape> listShape, Shape selectedShape) {
        this.list = listShape;
        this.selectedShape = selectedShape;
        this.stackShape = new Stack<>();
        this.moveStack = new Stack<>();
        this.colorStack = new Stack<>();
    }

    public List<Shape> getShape() {
        return list;
    }
    
    /*
    public void setShape(List<Shape> shape) {
        this.list = shape;
    }
    */
    
    public Shape getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(Shape selectedShape) {
        this.selectedShape = selectedShape;
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

    public Stack<ColorPicker> getColorStack() {
        return colorStack;
    }

    public void setColorStack(Stack<ColorPicker> colorStack) {
        this.colorStack = colorStack;
    }
    
    public void delete() {
        list.remove(this.selectedShape);
       
        stackShape.add(this.selectedShape);
    }

    public void copy() {

        if (this.getSelectedShape().getType().equals("Line")) {
            this.copyShape = creator.createShape(this.selectedShape.getType(), this.selectedShape.getGraphicsContext(), this.selectedShape.getX(), this.selectedShape.getY(), this.selectedShape.getLineColor(), null, this.selectedShape.getSizeX(), 0);
        } else {
            this.copyShape = creator.createShape(this.selectedShape.getType(), this.selectedShape.getGraphicsContext(), this.selectedShape.getX(), this.selectedShape.getY(), this.selectedShape.getLineColor(), this.selectedShape.getFillColor(), this.selectedShape.getSizeX(), this.selectedShape.getSizeY());
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
        this.copyShape = this.selectedShape;
        delete();
    }

    public void move(double newX, double newY, double previousX, double previousY) { 
        setPreviousX(previousX);
        setPreviousY(previousY);
        
        //cambiare nome di provaX e provaY
        Double provaX = new Double(previousX); 
        Double provaY = new Double(previousY);
        
        
        this.moveStack.add(provaY);
        this.moveStack.add(provaX);
        
        this.selectedShape.setXY(newX, newY);
        this.stackShape.add(this.selectedShape);
    }

    public void changeColor(ColorPicker lineColor, ColorPicker fillColor) {

        if (this.selectedShape.getType().equals("Line")) {
            setPreviusLineColor(this.selectedShape.getLineColor());
            
            this.colorStack.add(this.selectedShape.getLineColor());
        } else {
            setPreviusLineColor(this.selectedShape.getLineColor());
            setPreviusFillColor(this.selectedShape.getFillColor());
            
            
            this.colorStack.add(this.selectedShape.getLineColor());
            this.colorStack.add(this.selectedShape.getFillColor());
        }

        if (this.selectedShape.getType().equals("Line")) {
            this.selectedShape.setLineColor(lineColor);
            
        } else {
            this.selectedShape.setLineColor(lineColor);
            this.selectedShape.setFillColor(fillColor);
        }
        this.stackShape.add(this.selectedShape);
    }

    public void changeSize(double sizeX, double sizeY, double previousX, double previousY) {
        if (this.selectedShape.getType().equals("Line")) {
            setPreviousSizeX(this.selectedShape.getSizeX());
            setPreviousX(previousX);
            setPreviousY(previousY);
            this.moveStack.add(previousY);
            this.moveStack.add(previousX);
            this.moveStack.add(this.selectedShape.getSizeX());
        } else {
            setPreviousSizeX(this.selectedShape.getSizeX());
            setPreviousSizeY(this.selectedShape.getSizeY());
            setPreviousX(previousX);
            setPreviousY(previousY);
            this.moveStack.add(previousY);
            this.moveStack.add(previousX);
            this.moveStack.add(this.selectedShape.getSizeY());
            this.moveStack.add(this.selectedShape.getSizeX());
        }

        if (this.selectedShape.getType().equals("Line")) {
            this.selectedShape.setSizeX(sizeX);
            this.selectedShape.setXY(this.selectedShape.getX(), this.selectedShape.getY());
        } else {
            this.selectedShape.setSizeX(sizeX);
            this.selectedShape.setSizeY(sizeY);
            this.selectedShape.setXY(this.selectedShape.getX(), this.selectedShape.getY());
        }
        this.stackShape.add(this.selectedShape);
    }
}
