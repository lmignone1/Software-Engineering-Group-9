/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Factory.Creator;
import Memory.Memory;
import Shapes.Shape;
import java.util.List;

import javafx.scene.control.ColorPicker;

/**
 *
 * @author Davide 
 * //Receiver
 */
public class Select {

    private List<Shape> list;
    private Shape selectedShape;
    private Shape copyShape;
    private Creator creator = new Creator();
    private Shape pasteShape;
    private Memory memory;
    
    public Select(List<Shape> listShape, Shape selectedShape) {
        this.list = listShape;
        this.selectedShape = selectedShape;
        this.memory = new Memory();
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

    public Memory getMemory() {
        return memory;
    }

    public Shape getPasteShape() {
        return pasteShape;
    }
    
    /*
    public void setMemory(Memory memory) {
        this.memory = memory;
    }
    */
    
    public void delete() {
        
        if(this.selectedShape == null){
            return;
        }
        
        this.list.remove(this.selectedShape);
        this.memory.addStackShape(this.selectedShape);
    }

    public void copy() {
        
        if(this.selectedShape == null){
            return;
        }

        if (this.getSelectedShape().getType().equals("Line")) {
            this.copyShape = creator.createShape(this.selectedShape.getType(), this.selectedShape.getGraphicsContext(), this.selectedShape.getX(), this.selectedShape.getY(), this.selectedShape.getLineColor(), null, this.selectedShape.getSizeX(), 0);
        } else {
            this.copyShape = creator.createShape(this.selectedShape.getType(), this.selectedShape.getGraphicsContext(), this.selectedShape.getX(), this.selectedShape.getY(), this.selectedShape.getLineColor(), this.selectedShape.getFillColor(), this.selectedShape.getSizeX(), this.selectedShape.getSizeY());
        }
        
       this.memory.addStackShape(this.copyShape);
    }


    public void paste(double x, double y) {
        
        if(this.copyShape == null){
            return;
        }
        
        if (this.copyShape.getType().equals("Line")) {
                this.pasteShape = creator.createShape(this.copyShape.getType(), this.copyShape.getGraphicsContext(), this.copyShape.getX(), this.copyShape.getY(), this.copyShape.getLineColor(), null, this.copyShape.getSizeX(), 0);
        } else {
                this.pasteShape = creator.createShape(this.copyShape.getType(), this.copyShape.getGraphicsContext(), this.copyShape.getX(), this.copyShape.getY(), this.copyShape.getLineColor(), this.copyShape.getFillColor(), this.copyShape.getSizeX(), this.copyShape.getSizeY());
            }
        this.pasteShape.setXY(x, y);
        this.list.add(this.pasteShape);
        this.memory.addStackShape(this.pasteShape);
    }

    public void cut() {
        
        if(this.selectedShape == null){
            return;
        }
       
        this.copyShape = this.selectedShape;
        delete();
    }

    public void move(double newX, double newY, double previousX, double previousY) {
        
        if(this.selectedShape == null){
            return;
        }

        this.memory.addStackDouble(previousY);
        this.memory.addStackDouble(previousX);
        
        this.selectedShape.setXY(newX, newY);
        this.memory.addStackShape(this.selectedShape);
    }

    public void changeColor(ColorPicker lineColor, ColorPicker fillColor) {
        
        if(this.selectedShape == null){
            return;
        }

        if (this.selectedShape.getType().equals("Line")) {
            
            this.memory.addStackColor(this.selectedShape.getLineColor());
        } else {
            this.memory.addStackColor(this.selectedShape.getLineColor());
            this.memory.addStackColor(this.selectedShape.getFillColor());
        }

        if (this.selectedShape.getType().equals("Line")) {
            this.selectedShape.setLineColor(lineColor);
            
        } else {
            this.selectedShape.setLineColor(lineColor);
            this.selectedShape.setFillColor(fillColor);
        }
        this.memory.addStackShape(this.selectedShape);
    }

    public void changeSize(double sizeX, double sizeY, double previousX, double previousY) {
        
        if(this.selectedShape == null){
            return;
        }
        
        if (this.selectedShape.getType().equals("Line")) {
            this.memory.addStackDouble(previousY);
            this.memory.addStackDouble(previousX);
            this.memory.addStackDouble(this.selectedShape.getSizeX());
            
        } else {
            this.memory.addStackDouble(previousY);
            this.memory.addStackDouble(previousX);
            this.memory.addStackDouble(this.selectedShape.getSizeY());
            this.memory.addStackDouble(this.selectedShape.getSizeX());
            
        }

        if (this.selectedShape.getType().equals("Line")) {
            this.selectedShape.setSizeX(sizeX);
            this.selectedShape.setXY(this.selectedShape.getX(), this.selectedShape.getY());
        } else {
            this.selectedShape.setSizeX(sizeX);
            this.selectedShape.setSizeY(sizeY);
            this.selectedShape.setXY(this.selectedShape.getX(), this.selectedShape.getY());
        }
        this.memory.addStackShape(this.selectedShape);
    }
}
