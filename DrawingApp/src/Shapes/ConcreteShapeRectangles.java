/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

/**
 *
 * @author Acer
 */
import java.awt.geom.Rectangle2D;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.transform.Affine;

public class ConcreteShapeRectangles extends AbstractShape {

    private double width, height;
    private ColorPicker fillColor;
    private Rectangle2D rectangle = null;
    private Point2D point;
    private final String TYPE;

    public ConcreteShapeRectangles() {
        this.TYPE = "Rectangle";
        this.width = 100.0;
        this.height = 50.0;
        this.rectangle = new Rectangle2D.Double();
        this.setDegrees(0.0);
    }

    @Override
    public void setFillColor(ColorPicker color) {
        this.fillColor = new ColorPicker(color.getValue());
    }

    @Override
    public ColorPicker getFillColor() {
        return this.fillColor;
    }

    @Override
    public void setXY(double newX, double newY) {
        setX(newX - this.width / 2);
        setY(newY - this.height / 2);
        rectangle.setFrame(getX(), getY(), this.width, this.height);
        point = new Point2D(getX(), getY());
    }

    /*
    public double getWidth(){
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }
     */
    @Override
    public void draw() {
        GraphicsContext gc = getGraphicsContext();
        double deg = this.getDegrees();
        Affine a = gc.getTransform();

        gc.setStroke(getLineColor().getValue());
        gc.setFill(getFillColor().getValue());
        gc.setLineWidth(2);

        if (deg != 0.0) {
            a.appendRotation(deg, this.getX() + width / 2, this.getY() + height / 2);
            gc.setTransform(a);
        }
        
        gc.strokeRect(getX(), getY(), this.width, this.height);
        gc.fillRect(getX(), getY(), this.width, this.height);
        
        if(deg != 0.0){
            a.setToIdentity();
            gc.setTransform(a);
        }
    }

    @Override
    public boolean containsPoint(double x, double y) {
        return rectangle.contains(x, y);
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

    @Override
    public String toString() {
        String s = super.toString();
        String[] split = s.split(" ");
        double x = Double.parseDouble(split[0]);
        double y = Double.parseDouble(split[1]);
        x = x + (this.width / 2);
        y = y + (this.height / 2);
        return TYPE + " " + x + " " + y + " " + split[2] + " " + fillColor.getValue() + " " + this.width + " " + this.height + " " + "nothing" + " " + split[3];
    }
}
