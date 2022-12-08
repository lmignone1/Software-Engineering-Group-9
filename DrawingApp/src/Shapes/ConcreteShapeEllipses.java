
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.geom.Ellipse2D;
import javafx.geometry.Point2D;

import javafx.scene.control.ColorPicker;

/**
 *
 * @author loren
 */
public class ConcreteShapeEllipses extends AbstractShape{
    private ColorPicker fillColor;
    private double radiusX, radiusY;
    private Point2D point;
    private Ellipse2D ellipse;
    private final String TYPE;
    
    
    public ConcreteShapeEllipses() {
        this.TYPE = "Ellipse";
        this.radiusX = 150.0;
        this.radiusY = 90.0;
        this.ellipse = new Ellipse2D.Double();
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
    public void setXY(double centerX, double centerY){
        setX(centerX - this.getSizeX()/2);
        setY(centerY - this.getSizeY()/2);  
        ellipse.setFrame(getX(), getY(), this.radiusX, this.radiusY);
        point = new Point2D(getX(), getY());
    }
    /*
    public double getRadiusX(){
        return this.radiusX;
    }

    public double getRadiusY(){
        return this.radiusY;
    }
    */
    @Override
    public void draw(){
        getGraphicsContext().setStroke(getLineColor().getValue());
        getGraphicsContext().setFill(getFillColor().getValue());
        getGraphicsContext().setLineWidth(3);
        getGraphicsContext().strokeOval(getX(), getY(), this.radiusX, this.radiusY);
        getGraphicsContext().fillOval(getX(), getY(), this.radiusX, this.radiusY);
    }

    @Override
    public boolean containsPoint(double x, double y) {
        return ellipse.contains(x, y);
    }
    
    @Override
    public Point2D getPoint(){
        return this.point;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }
    
    @Override
    public void setSizeX(double sizeX) {
        this.radiusX = sizeX;
    }

    @Override
    public void setSizeY(double sizeY) {
        this.radiusY = sizeY;
    }

    @Override
    public double getSizeX() {
        return this.radiusX;
    }

    @Override
    public double getSizeY() {
        return this.radiusY;
    }

    @Override
    public String toString() {
        return TYPE + " " + super.toString() + " " + fillColor.getValue() + " " + radiusX + " " + radiusY;
    }
}
