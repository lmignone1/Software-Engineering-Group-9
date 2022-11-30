/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

/**
 *
 * @author Acer
 */

import javafx.geometry.Point2D;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Rectangle;

public class ConcreteShapeRectangles extends AbstractShape{
    
     double width, height;
    private ColorPicker fillColor;
    private Rectangle rectangle;

    public ConcreteShapeRectangles(){
        this.width = 100.0;
        this.height = 50.0;
        this.rectangle = new Rectangle();
    }
    
    @Override
    public void setFillColor(ColorPicker color){
       this.fillColor = color;
    }
    
    @Override
    public ColorPicker getFillColor(){
        return this.fillColor;
    }

    @Override
    public void setXY(double newX, double newY){
        setX(newX - this.width/2);
        setY(newY - this.height/2);
        rectangle.setX(getX());
        rectangle.setY(getY());
        rectangle.setWidth(this.width);
        rectangle.setHeight(this.height);
    }
    
    public double getWidth(){
        return rectangle.getWidth();
    }

    public double getHeight() {
        return rectangle.getHeight();
    }

    @Override
    public void draw(){
        getGraphicsContext().setStroke(getLineColor().getValue());
        getGraphicsContext().setFill(getFillColor().getValue());
        getGraphicsContext().setLineWidth(2);
        getGraphicsContext().fillRect(getX(), getY(), getWidth(), getHeight());
        getGraphicsContext().strokeRect(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public Point2D getPoint() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean containsPoint(double x, double y) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
