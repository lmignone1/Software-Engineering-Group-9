
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
    //private Ellipse2D ellipse = null;
    private Ellipse2D ellipse;
    private final String TYPE;
    
    
    public ConcreteShapeEllipses() {
        this.TYPE = "Ellipse";
        this.radiusX = 150.0;
        this.radiusY = 90.0;
        //this.point = null;
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
        setX(centerX - this.getRadiusX()/2);
        setY(centerY - this.getRadiusY()/2);  
        ellipse.setFrame(getX(), getY(), getRadiusX(), getRadiusY());
        point = new Point2D(getX(), getY());
    }

    public double getRadiusX(){
        return this.radiusX;
    }

    public double getRadiusY(){
        return this.radiusY;
    }

    @Override
    public void draw(){
        getGraphicsContext().setStroke(getLineColor().getValue());
        getGraphicsContext().setFill(getFillColor().getValue());
        getGraphicsContext().setLineWidth(3);
        getGraphicsContext().strokeOval(getX(), getY(), getRadiusX(), getRadiusY());
        getGraphicsContext().fillOval(getX(), getY(), getRadiusX(), getRadiusY());
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

}
