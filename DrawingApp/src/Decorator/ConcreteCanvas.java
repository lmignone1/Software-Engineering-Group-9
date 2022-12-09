/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author artem
 */

//rappresenta la canvas: oggetto che deve essere decorato
public class ConcreteCanvas implements CanvasComponent {
    
    Canvas canvas;
    int gridSize;
    

    public ConcreteCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public Canvas getCanvas() {
        return this.canvas;
    }

    @Override
    public void execute() {
    }

    @Override
    public void setGridSizeInput(int size) {
        this.gridSize = size;
    }

    @Override
    public int getGridSizeInput() {
        return this.gridSize;
    }
    
    

    
}