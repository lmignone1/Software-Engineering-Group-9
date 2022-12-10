/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;


import java.awt.geom.Line2D;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

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
        this.setDegrees(0.0);
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
        GraphicsContext gc = getGraphicsContext();
        double deg = this.getDegrees();
        Affine a = gc.getTransform();

        gc.setStroke(getLineColor().getValue());
        gc.setLineWidth(2);
        
        if (deg != 0.0) {
            a.appendRotation(deg, this.getX() + length / 2, this.getY());
            gc.setTransform(a);
        }
        
        gc.strokeLine(getX(), getY(), getEndX(), getEndY());
        
        if(deg != 0.0){
            a.setToIdentity();
            gc.setTransform(a);
        }
    }

    @Override
    public Point2D getPoint() {
        return this.point;
    }

    @Override
    public boolean containsPoint(double x, double y) {
        return line.intersects(x, y, 8.0, 8.0);
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
        return TYPE + " " + x + " " + split[1] + " " + split[2] + " " + Color.WHITE + " " + length + " " + "0.0" + " " + "nothing" + " " + split[3];
    }

}
