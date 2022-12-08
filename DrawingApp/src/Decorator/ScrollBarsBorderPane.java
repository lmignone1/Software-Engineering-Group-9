/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

/**
 *
 * @author Davide
 */
public class ScrollBarsBorderPane extends DecoratorBorderPane {
    
    private Canvas canvas;
    private ScrollPane scrollPane;
    
    public ScrollBarsBorderPane(BorderPaneComponent borderPane, Canvas canvas) {
        super(borderPane);
        this.canvas = canvas;
        
    }
    
    
    @Override
    public void addProperty(){
        super.addProperty();
        setScrollBars();
        
    }

    private void setScrollBars() {
        scrollPane = new ScrollPane();
        scrollPane.setContent(this.canvas);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        borderPane.getBorderPane().setCenter(scrollPane); 
    }
   
    @Override
    public String test(){
        return super.test() + " ,sono in scrollBars";
    }
}
