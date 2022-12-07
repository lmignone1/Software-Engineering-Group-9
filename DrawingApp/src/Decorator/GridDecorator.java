/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

import Shapes.Shape;
import java.util.Iterator;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author artem
 */
public class GridDecorator extends Decorator {
    
    public GridDecorator(Component component){
        super(component);
    }
    
    @Override
    public void execute(){
        super.execute();
        setGrid();
    }
    
    private void setGrid(){
        System.out.println("Concrete component grid");
        //grid = new GridPane();
        //grid.visibleProperty().set(true);
    }

}
