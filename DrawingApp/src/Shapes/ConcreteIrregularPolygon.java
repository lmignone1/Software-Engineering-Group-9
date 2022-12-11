/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.transform.Affine;

/**
 *
 * @author Davide
 */
public class ConcreteIrregularPolygon extends AbstractShape {

    private Polygon2D polygon;
    private Point2D point;
    private ColorPicker fillColor;
    private final String TYPE;
    private ArrayList<Double> polygonX = new ArrayList<Double>();
    private ArrayList<Double> polygonY = new ArrayList<Double>();
    private double[] allX;
    private double[] allY;
    private int nPoints;

    public ConcreteIrregularPolygon() {
        this.TYPE = "IrregularPolygon";
        this.polygon = new Polygon2D();
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
    public double[] getAllX() {
        return allX;
    }

    @Override
    public double[] getAllY() {
        return allY;
    }

    @Override
    public int getVertices() {
        return nPoints;
    }

    public void setVertices(int n) {
        this.nPoints = n;
    }

    public void setAllX(double[] allX) {
        this.allX = allX;
    }

    public void setAllY(double[] allY) {
        this.allY = allY;
    }

    @Override
    public void setPolygonX(ArrayList<Double> polygonX) {
        this.polygonX = polygonX;
    }

    @Override
    public void setPolygonY(ArrayList<Double> polygonY) {
        this.polygonY = polygonY;
    }

    @Override
    public Shape clone() {
        ConcreteIrregularPolygon irregularPolygon = new ConcreteIrregularPolygon();

        irregularPolygon.setAllX(allX);
        irregularPolygon.setAllY(allY);
        irregularPolygon.setVertices(nPoints);
        irregularPolygon.setPolygonX(polygonX);
        irregularPolygon.setPolygonX(polygonY);
        irregularPolygon.setGraphicsContext(this.getGraphicsContext());
        irregularPolygon.setLineColor(this.getLineColor());
        irregularPolygon.setFillColor(this.getFillColor());

        return irregularPolygon;
    }

    @Override
    public void setXY(double newX, double newY) {
        this.polygonX.add(newX);
        this.polygonY.add(newY);
        float floatX = (float) newX;
        float floatY = (float) newY;
        this.polygon.addPoint(floatX, floatY);
    }

    @Override
    public void draw() {

        GraphicsContext gc = getGraphicsContext();
        double deg = this.getDegrees();
        Affine a = gc.getTransform();

        getGraphicsContext().setStroke(getLineColor().getValue());
        getGraphicsContext().setFill(fillColor.getValue());

        double[] polyX = new double[polygonX.size()];
        double[] polyY = new double[polygonY.size()];
        allX = new double[polygonX.size()];
        allY = new double[polygonY.size()];

        for (int i = 0; i < polygonX.size(); i++) {
            polyX[i] = polygonX.get(i);
            polyY[i] = polygonY.get(i);
            allX[i] = polygonX.get(i);
            allY[i] = polygonY.get(i);

        }
        nPoints = polyX.length;

        if (deg != 0.0) {
            a.appendRotation(deg, polyX[0], polyY[0]);
            gc.setTransform(a);
        }

        getGraphicsContext().setLineWidth(3);

        getGraphicsContext().strokePolygon(polyX, polyY, polyX.length);
        getGraphicsContext().fillPolygon(polyX, polyY, polyX.length);

        if (deg != 0.0) {
            a.setToIdentity();
            gc.setTransform(a);
        }

    }

    @Override
    public boolean containsPoint(double x, double y) {
        return this.polygon.contains(x, y);
    }

    @Override
    public String getType() {
        return this.TYPE;
    }

    @Override
    public void setSizeX(double sizeX) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double getSizeX() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Point2D getPoint() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
