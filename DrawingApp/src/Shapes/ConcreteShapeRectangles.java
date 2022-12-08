/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

/**
 *
 * @author Acer
 */

import java.awt.geom.Rectangle2D;
import javafx.geometry.Point2D;
import javafx.scene.control.ColorPicker;


public class ConcreteShapeRectangles extends AbstractShape{
    
    private double width, height;
    private ColorPicker fillColor;
    private Rectangle2D rectangle = null;
    private Point2D point;
    private final String TYPE;

    public ConcreteShapeRectangles(){
        this.TYPE = "Rectangle";
        this.width = 100.0;
        this.height = 50.0;
        this.rectangle = new Rectangle2D.Double();
        //this.point = null;
    }
    
    @Override
    public void setFillColor(ColorPicker color){
       this.fillColor = new ColorPicker(color.getValue());
    }
    
    @Override
    public ColorPicker getFillColor(){
        return this.fillColor;
    }

    @Override
    public void setXY(double newX, double newY){
        setX(newX - this.width/2);
        setY(newY - this.height/2);
        rectangle.setFrame(getX(), getY(), this.width, this.height);
        point = new Point2D(getX(), getY());
    }
    
    /*
    public double getWidth(){
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }
    */
    @Override
    public void draw(){
        getGraphicsContext().setStroke(getLineColor().getValue());
        getGraphicsContext().setFill(getFillColor().getValue());
        getGraphicsContext().setLineWidth(2);
        getGraphicsContext().fillRect(getX(), getY(), this.width, this.height);
        getGraphicsContext().strokeRect(getX(), getY(), this.width, this.height);
    }

    @Override
    public boolean containsPoint(double x, double y) {
        return rectangle.contains(x, y);
    }

    @Override
    public Point2D getPoint() {
        return this.point;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }
    
    @Override
    public void setSizeX(double sizeX) {
        this.width = sizeX;
    }

    @Override
    public void setSizeY(double sizeY) {
        this.height = sizeY;
    }

    @Override
    public double getSizeX() {
        return this.width;
    }

    @Override
    public double getSizeY() {
        return this.height;
    }

    @Override
    public String toString() {
        return TYPE + " " + super.toString() + " " + fillColor.getValue() + " " + width + " " + height;
    }
    
    
}
