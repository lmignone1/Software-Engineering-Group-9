/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.geom.Rectangle2D;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

/**
 *
 * @author artem
 */
//testo all'interno di un rettangolo
public class ConcreteText extends AbstractShape {

    private double width, height;
    private ColorPicker fillColor;
    private Rectangle2D rectangle = null;
    private Point2D point;
    private String string;
    private final String TYPE;
    

    public ConcreteText(){
        this.TYPE = "Text";
        this.width = 50.0;
        this.height = 0.1;
        this.rectangle = new Rectangle2D.Double();
        this.setDegrees(0.0);
    }
    
    @Override
    public void setFillColor(ColorPicker color){
       /*ColorPicker cp = new ColorPicker();
       cp.setValue(Color.TRANSPARENT);
       this.fillColor = new ColorPicker(cp.getValue());*/
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
    
    @Override
    public void draw(){
        GraphicsContext gc = getGraphicsContext();
        double deg = this.getDegrees();
        Affine a = gc.getTransform();
        
        ColorPicker cp = new ColorPicker();
        cp.setValue(Color.TRANSPARENT);
        gc.setStroke(cp.getValue());
        gc.setFill(getFillColor().getValue());
        gc.setLineWidth(2);
        
        if (deg != 0.0) {
            a.appendRotation(deg, this.getX() + width / 2, this.getY() + height / 2);
            gc.setTransform(a);
        }
        
        gc.fillRect(getX(), getY(), this.width, this.height);
        gc.strokeRect(getX(), getY(), this.width, this.height);
        gc.fillText(string, getX() + this.width / 4, getY());
        
        if(deg != 0.0){
            a.setToIdentity();
            gc.setTransform(a);
        }
    }

    @Override
    public boolean containsPoint(double x, double y) {
        return rectangle.intersects(x, y, 10.0, 25.0);
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

    public void setText(String string) {
        this.string = new String(string.toString());
    }
    
    public String getText() {
        return this.string;
    }

    @Override
    public String toString() {
        String s = super.toString();
        String[] split = s.split(" ");
        double x = Double.parseDouble(split[0]);
        double y = Double.parseDouble(split[1]);
        x = x + (this.width/2);
        y = y + (this.height/2);
        return TYPE + " " + x + " " + y + " " + split[2] + " " + fillColor.getValue() + " " + this.width + " " + this.height + " " + string + " " + split[3];
    }
    
    
    
}

