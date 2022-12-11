/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import Shapes.ConcreteShapeLines;
import Shapes.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

/**
 *
 * @author Acer
 */
public class ConcreteCreatorLine extends Creator {

    public static Shape createShape(GraphicsContext gc, double x, double y, ColorPicker lineColor) {

        ConcreteShapeLines line = new ConcreteShapeLines();

        line.setGraphicsContext(gc);
        line.setXY(x, y);
        line.setLineColor(lineColor);

        return line;
    }

    public static Shape createShape(GraphicsContext gc, double x, double y, ColorPicker lineColor, double sizeX, double degrees) {

        ConcreteShapeLines line = new ConcreteShapeLines();

        line.setGraphicsContext(gc);
        line.setSizeX(sizeX);
        line.setDegrees(degrees);
        line.setXY(x, y);
        line.setLineColor(lineColor);

        return line;
    }
}
