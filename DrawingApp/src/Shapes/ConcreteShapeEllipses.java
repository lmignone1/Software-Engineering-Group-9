
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import javafx.scene.shape.Ellipse;

import javafx.scene.control.ColorPicker;

/**
 *
 * @author Acer
 */
public class ConcreteShapeEllipses implements Shape{
    private ColorPicker LineColor,FillColor;
    private double centerX, centerY, endX, endY;
    private Ellipse ellipse = new Ellipse();
    @Override
    public void setLineColor(ColorPicker colorPicker){
        LineColor = colorPicker;
    }

    public void setFillColor(ColorPicker colorPicker){
        FillColor = colorPicker;
    }
    public void setCenter(double centerX, double centerY){
        this.centerX = centerX;
        this.centerY = centerY;

        ellipse.setCenterX(centerX);
        ellipse.setCenterY(centerY);
    }

    public void setEndPoint(double endX, double endY){
        this.endX = endX;
        this.endY = endY;
    }

    public void setRadius(){
        ellipse.setRadiusX(Math.abs((endX - centerX)));
        ellipse.setRadiusY(Math.abs((endY - centerY)));
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

    public ColorPicker getFillColor(){
        return FillColor;
    }

    
}
