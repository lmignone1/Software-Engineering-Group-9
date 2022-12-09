/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;


import java.awt.geom.Line2D;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

/**
 *
 * @author Acer
 */

public class ConcreteShapeLines extends AbstractShape{
    private double length;
    private Line2D line;
    private Point2D point;
    private double endX, endY;
    private final String TYPE;
    
    public ConcreteShapeLines(){
        this.TYPE = "Line";
        this.length = 100.0;
        this.line = new Line2D.Double();
    }

    @Override
    public void setXY(double x, double y){ 
        setX(x - length/2);
        setY(y);
        setEndX(getX() + length);
        setEndY(getY());
        line.setLine(getX(), getY(), getEndX(), getEndY());
        point = new Point2D(getX(), getY());
    }
    @Override
    public void draw() {
        getGraphicsContext().setStroke(getLineColor().getValue());
        getGraphicsContext().setLineWidth(2);
        getGraphicsContext().strokeLine(getX(), getY(), getEndX(), getEndY());
    }

    @Override
    public Point2D getPoint() {
        return this.point;
    }

    @Override
    public boolean containsPoint(double x, double y) {
        return line.intersects(x, y, 6.0, 6.0);
    }

    public double getEndX() {
        return endX;
    }

    public void setEndX(double endX) {
        this.endX = endX;
    }

    public double getEndY() {
        return endY;
    }

    public void setEndY(double endY) {
        this.endY = endY;
    }

    @Override
    public String getType() {
       return this.TYPE;
    }
    
    @Override
    public void setSizeX(double sizeX) {
        this.length = sizeX;
    }

    @Override
    public double getSizeX() {
        return this.length;
    }

    @Override
    public String toString() {
        String s = super.toString();
        String[] split = s.split(" ");
        double x = Double.parseDouble(split[0]);
        x = x + this.length/2;
        return TYPE + " " + x + " " + split[1] + " " + split[2] + " " + Color.WHITE + " " + length + " " + "0.0";
    }

}
