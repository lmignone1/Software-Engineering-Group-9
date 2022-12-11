/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author artem
 */
public class GridDecorator extends DecoratorCanvas {
    //int gridSize;

    public GridDecorator(CanvasComponent component) {
        super(component);
    }

    @Override
    public void execute() {
        super.execute();
        setGrid();
    }

    private void setGrid() {

        GraphicsContext gc = component.getCanvas().getGraphicsContext2D();
        gc.clearRect(0, 0, component.getCanvas().getWidth(), component.getCanvas().getHeight());

        // vertical lines
        gc.setStroke(Color.GREY);
        for (int i = 0; i < component.getCanvas().getWidth(); i += component.getGridSizeInput()) {
            gc.strokeLine(i, 0, i, component.getCanvas().getHeight() - (component.getCanvas().getHeight() % component.getGridSizeInput()));
        }
        // horizontal lines
        gc.setStroke(Color.GREY);
        for (int i = component.getGridSizeInput(); i < component.getCanvas().getHeight(); i += component.getGridSizeInput()) {
            gc.strokeLine(0, i, component.getCanvas().getWidth(), i);
        }
    }

}
