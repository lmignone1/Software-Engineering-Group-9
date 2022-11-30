/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

/**
 *
 * @author Davide
 */
public abstract class AbstractShape implements Shape{
    
    private ColorPicker LineColor;
    private GraphicsContext gc;
    private double x;
    private double y;
    public AbstractShape(){
    }
    @Override
    public void setLineColor(ColorPicker color){
        LineColor = color;
    }
    
    @Override
    public ColorPicker getLineColor(){
        return LineColor;
    }
    
    @Override
    public void setFillColor(ColorPicker color){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public ColorPicker getFillColor(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void setGraphicsContext(GraphicsContext gc){
        this.gc = gc;
    }
    
    @Override
    public GraphicsContext getGraphicsContext() {
        return gc;
    }
    
    @Override
    public void setX(double newX) {
        this.x = newX;
    }
    
    @Override
    public double getX() {
        return this.x;
    }
    
    @Override
    public void setY(double newY) {
        this.y = newY;
    }
    
    @Override
    public double getY() {
        return this.y;
    }
    
    
}
