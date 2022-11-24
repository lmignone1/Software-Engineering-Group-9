
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Ellipse;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;


/**
 *
 * @author Acer
 */
public class ConcreteShapeEllipses implements Shape{
    private ColorPicker LineColor;
    private ColorPicker FillColor;
    private double centerX;
    private double centerY;
    private Ellipse ellipse  = new Ellipse();
    private GraphicsContext gc;
    
    @Override
    public void setLineColor(ColorPicker color){
        LineColor = color;
    }
    
    @Override
    public void setFillColor(ColorPicker color){
        FillColor = color;
    }
    
    public void setCenter(double centerX, double centerY){
        this.centerX = centerX; // update of this class
        this.centerY = centerY;
        ellipse.setCenterX(centerX);    // update of the composition obj
        ellipse.setCenterY(centerY);
    }

    public void setRadius(){
        ellipse.setRadiusY(90.0f);
        ellipse.setRadiusX(150.0f);
    }
    
    public double getCenterX(){
        return ellipse.getCenterX();
    }

    public double getCenterY(){
        return  ellipse.getCenterY();
    }

    public double getRadiusX(){
        return ellipse.getRadiusX();
    }

    public double getRadiusY(){
        return ellipse.getRadiusY();
    }

    @Override
    public ColorPicker getLineColor(){
        return LineColor;
    }

    @Override
    public ColorPicker getFillColor(){
        return FillColor;
    }
    
    @Override
    public void setGraphicsContext(GraphicsContext gc){
        this.gc = gc;
    }
    
    @Override
    public void drawShape(){
        gc.setStroke(LineColor.getValue());
        gc.setLineWidth(3);
        gc.setFill(FillColor.getValue());
        gc.strokeOval(this.centerX - (getRadiusX())/2, this.centerY - (getRadiusY()/2), getRadiusX(), getRadiusY());
        gc.fillOval(this.centerX - (getRadiusX())/2, this.centerY - (getRadiusY()/2), getRadiusX(), getRadiusY());
    }
}
