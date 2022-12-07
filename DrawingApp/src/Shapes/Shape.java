/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Shapes;


import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

/**
 *
 * @author loren
 */
public interface Shape {
    public void setGraphicsContext(GraphicsContext gc);
    public GraphicsContext getGraphicsContext();
    public void setXY(double newX, double newY);
    public void setLineColor(ColorPicker color);
    public ColorPicker getLineColor();
    public void setFillColor(ColorPicker color);
    public ColorPicker getFillColor();
    public void setX(double newX);
    public double getX();
    public void setY(double newY);
    public double getY();
    public void draw();
    public boolean containsPoint(double x, double y);
    public Point2D getPoint();
    public String getType();
    public void setSizeX(double sizeX);
    public void setSizeY(double sizeY);
    public double getSizeX();
    public double getSizeY();
    
}
