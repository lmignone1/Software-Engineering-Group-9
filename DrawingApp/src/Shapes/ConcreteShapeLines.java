/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;


import javafx.geometry.Point2D;
import javafx.scene.shape.Line;

/**
 *
 * @author Acer
 */
public  class ConcreteShapeLines extends AbstractShape{
    private final double length;
    private final Line line;
    
    public ConcreteShapeLines(){
        this.length = 100.0;
        this.line = new Line();
    }

    @Override
    public void setXY(double x, double y){ 
        setX(x);
        setY(y);
        line.setStartX(getX());
        line.setStartY(getY());
    }
    @Override
    public void draw() {
        getGraphicsContext().setStroke(getLineColor().getValue());
        getGraphicsContext().setLineWidth(2);
        getGraphicsContext().strokeLine(line.getStartX() - length/2, line.getStartY(), line.getStartX() + length/2, line.getStartY());
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


