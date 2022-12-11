/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Decorator;

import javafx.scene.canvas.Canvas;

/**
 *
 * @author artem
 */
public interface CanvasComponent {

    public void execute();

    public Canvas getCanvas();

    public void setGridSizeInput(int size);

    public int getGridSizeInput();

}
