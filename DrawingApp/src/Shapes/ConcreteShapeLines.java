/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Line;

/**
 *
 * @author Acer
 */
public  class ConcreteShapeLines implements Shape{
    private double length;
    private ColorPicker LineColor;
    private GraphicsContext graphicsContext;
    private Line line = new Line();
    public ConcreteShapeLines(){
    this.length=100;
    }
    @Override
    public void setGraphicsContext(GraphicsContext graphicsContext){
        this.graphicsContext = graphicsContext;        
    }
    @Override
    public void setLineColor(ColorPicker colorLine){
        LineColor = colorLine;
    }
    @Override
    public void setFillColor(ColorPicker colorFill) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    public void setStart(double x, double y){
        line.setStartX(x-length/2);
        line.setStartY(y); 
        line.setEndX(x+length/2);
        line.setEndY(y);
    }
    public double getStartX(){
        return line.getStartX();   
    }
    public double getStartY(){
        return line.getStartY();  
    }
    public double getEndX(){
        return line.getEndX();
    }
    public double getEndY(){
        return line.getEndY();
    }
    @Override
    public ColorPicker getLineColor(){
        return LineColor;
    }
    public void drawShape() {
        graphicsContext.setStroke(getLineColor().getValue());
        graphicsContext.strokeLine(getStartX(), getStartY(), getEndX(), getEndY());
    }

    @Override
    public ColorPicker getFillColor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}


