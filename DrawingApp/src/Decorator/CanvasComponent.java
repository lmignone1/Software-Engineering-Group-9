/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Decorator;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

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
