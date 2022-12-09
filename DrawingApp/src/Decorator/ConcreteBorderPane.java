/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author Davide
 */
public class ConcreteBorderPane implements BorderPaneComponent {
    
    private BorderPane borderPane;

    public ConcreteBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }
    
    @Override
    public void addProperty() { 
    }

}
