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
public class DecoratorBorderPane implements BorderPaneComponent {
    
    
    protected BorderPaneComponent borderPane;

    public DecoratorBorderPane(BorderPaneComponent borderPane) {
        this.borderPane = borderPane;
    }

    @Override
    public void addProperty() {
        borderPane.addProperty();
    }

    @Override
    public BorderPane getBorderPane() {
        return borderPane.getBorderPane();
    }

    @Override
    public String test() {
        return borderPane.test();
    }


    
}
