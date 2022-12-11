/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

/**
 *
 * @author Davide
 */
public abstract class AbstractShape implements Shape {

    private ColorPicker lineColor;
    private GraphicsContext gc;
    private double x;
    private double y;
    private double degrees;

    @Override
    public void setLineColor(ColorPicker color) {
        lineColor = new ColorPicker(color.getValue());
    }

    @Override
    public ColorPicker getLineColor() {
        return lineColor;
    }

    @Override
    public void setFillColor(ColorPicker color) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ColorPicker getFillColor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setGraphicsContext(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public GraphicsContext getGraphicsContext() {
        return gc;
    }

    @Override
    public void setX(double newX) {
        this.x = newX;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public void setY(double newY) {
        this.y = newY;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public double getDegrees() {
        return this.degrees;
    }

    @Override
    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }

    @Override
    public void setSizeY(double sizeY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double getSizeY() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return x + " " + y + " " + lineColor.getValue() + " " + this.degrees;
    }

    @Override
    public void setText(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getText() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double[] getAllX() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double[] getAllY() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getVertices() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Shape clone() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setPolygonX(ArrayList<Double> arrayListX) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setPolygonY(ArrayList<Double> arrayListY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
