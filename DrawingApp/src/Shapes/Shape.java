/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

/**
 *
 * @author loren
 */
public interface Shape {
    public void setLineColor(ColorPicker color);
    public void setFillColor(ColorPicker color);
    public ColorPicker getLineColor();
    public ColorPicker getFillColor();
    public void setGraphicsContext(GraphicsContext gc);
    public void drawShape();
}
