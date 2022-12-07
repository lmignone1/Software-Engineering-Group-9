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
public class ConcreteComponent implements Component {
    
    Canvas canvas;

    public ConcreteComponent(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        System.out.println("Concrete component");
    }

    
}
