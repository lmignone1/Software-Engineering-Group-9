/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import Shapes.ConcreteIrregularPolygon;
import Shapes.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

/**
 *
 * @author Davide
 */
public class ConcreteCreatorIrregularPolygon extends Creator {

    public static Shape createShape(GraphicsContext gc, double x, double y, ColorPicker lineColor, ColorPicker fillColor) {

        ConcreteIrregularPolygon polygon = new ConcreteIrregularPolygon();

        polygon.setGraphicsContext(gc);
        polygon.setLineColor(lineColor);
        polygon.setFillColor(fillColor);

        return polygon;
    }
}
