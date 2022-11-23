/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Line;

/**
 *
 * @author Acer
 */
public class ConcreteShapeLines {
    private ColorPicker LineColor;
    private Line line = new Line();
    public void setLineColor(ColorPicker colorLine){
        LineColor = colorLine;
    }

    public void setStartPoint(double x, double y){
        line.setStartX(x);
        line.setStartY(y);
    }

    public void setEndPoint(double x, double y){
        line.setEndX(x);
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

    public ColorPicker getLineColor(){
        return LineColor;
    }
}
