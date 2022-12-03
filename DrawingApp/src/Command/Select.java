/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Factory.Creator;
import Shapes.Shape;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.control.ColorPicker;


/**
 *
 * @author Davide
 * //Receiver
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
    private double previusX,previusY;


   public Select(List<Shape> shape, Shape selectedShape) {
        this.list = shape;
        Select.selectedShape = selectedShape;
   }

   public List<Shape> getShape() {
        return list;
    }

   public void setShape(List<Shape> shape) {
        this.list = shape;
    }

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

    public double getPreviusX() {
        return previusX;
    }

    public void setPreviusX(double previusX) {
        this.previusX = previusX;
    }

    public double getPreviusY() {
        return previusY;
    }

    public void setPreviusY(double previusY) {
        this.previusY = previusY;
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
    
    
    public void delete(){
        list.remove(Select.selectedShape);
    }
    
    public void copy(){
        
        if(Select.getSelectedShape().getType().equals("Line")){
            this.copyShape = creator.createShape(Select.selectedShape.getType(), Select.selectedShape.getGraphicsContext(), Select.selectedShape.getX(),Select.selectedShape.getY(), Select.selectedShape.getLineColor(), null,Select.selectedShape.getSizeX(),0);
        }else{
            this.copyShape = creator.createShape(Select.selectedShape.getType(), Select.selectedShape.getGraphicsContext(), Select.selectedShape.getX(),Select.selectedShape.getY(), Select.selectedShape.getLineColor(), Select.selectedShape.getFillColor(),Select.selectedShape.getSizeX(),Select.selectedShape.getSizeY());
        }
        
    }
    
    public void paste(double x, double y){
        
        //copy();
        this.copyShape.setXY(x,y);
        this.list.add(this.copyShape);

   }
    
    public void cut(){
        this.copyShape = Select.selectedShape;
        delete();
    }
    
    public void move(double x, double y){ // SCRITTA A CASO DA RIVEDERE
        
    }
    
    public void changeColor(ColorPicker lineColor, ColorPicker fillColor) {
        
        if(Select.selectedShape.getType().equals("Line")){
            setPreviusLineColor(Select.selectedShape.getLineColor());
        }else{
            setPreviusLineColor(Select.selectedShape.getLineColor());
            setPreviusFillColor(Select.selectedShape.getFillColor());
        }
        
        if(Select.selectedShape.getType().equals("Line")){
            Select.selectedShape.setLineColor(lineColor);
        }else{
            Select.selectedShape.setLineColor(lineColor);
            Select.selectedShape.setFillColor(fillColor);
        }
    }
    
        public void changeSize(double sizeX, double sizeY){
        if(Select.selectedShape.getType().equals("Line")){
            setPreviousSizeX(Select.selectedShape.getSizeX());
        }
        else{
            setPreviousSizeX(Select.selectedShape.getSizeX());
            setPreviousSizeY(Select.selectedShape.getSizeY());
        }
        
        if(Select.selectedShape.getType().equals("Line")){
            Select.selectedShape.setSizeX(sizeX);
            Select.selectedShape.setXY(Select.selectedShape.getX(), Select.selectedShape.getY());
        }
        else{
            Select.selectedShape.setSizeX(sizeX);
            Select.selectedShape.setSizeY(sizeY);
            Select.selectedShape.setXY(Select.selectedShape.getX(), Select.selectedShape.getY());
        }
    }
    
    
}

