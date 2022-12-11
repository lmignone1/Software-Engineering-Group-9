
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.geom.Ellipse2D;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.transform.Affine;

/**
 *
 * @author loren
 */
public class ConcreteShapeEllipses extends AbstractShape {

    private ColorPicker fillColor;
    private double radiusX, radiusY;
    private Point2D point;
    private Ellipse2D ellipse;
    private final String TYPE;

    public ConcreteShapeEllipses() {
        this.TYPE = "Ellipse";
        this.radiusX = 150.0;
        this.radiusY = 90.0;
        this.ellipse = new Ellipse2D.Double();
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
    public void setXY(double centerX, double centerY) {
        setX(centerX - this.getSizeX() / 2);
        setY(centerY - this.getSizeY() / 2);
        ellipse.setFrame(getX(), getY(), this.radiusX, this.radiusY);
        point = new Point2D(getX(), getY());
    }

    @Override
    public void draw() {
        GraphicsContext gc = getGraphicsContext();
        double deg = this.getDegrees();
        Affine a = gc.getTransform();

        gc.setStroke(getLineColor().getValue());
        gc.setFill(getFillColor().getValue());
        gc.setLineWidth(3);

        if (deg != 0.0) {
            a.appendRotation(deg, this.getX() + radiusX / 2, this.getY() + radiusY / 2);
            gc.setTransform(a);
        }

        gc.strokeOval(getX(), getY(), this.radiusX, this.radiusY);
        gc.fillOval(getX(), getY(), this.radiusX, this.radiusY);

        if (deg != 0.0) {
            a.setToIdentity();
            gc.setTransform(a);
        }
    }

    @Override
    public boolean containsPoint(double x, double y) {
        return ellipse.contains(x, y);
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

    @Override
    public String toString() {
        String s = super.toString();
        String[] split = s.split(" ");
        double x = Double.parseDouble(split[0]);
        double y = Double.parseDouble(split[1]);
        x = x + (this.radiusX / 2);
        y = y + (this.radiusY / 2);
        return TYPE + " " + x + " " + y + " " + split[2] + " " + fillColor.getValue() + " " + radiusX + " " + radiusY + " " + "nothing" + " " + split[3];
    }

}
