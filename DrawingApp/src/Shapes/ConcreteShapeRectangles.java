/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

/**
 *
 * @author Acer
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ConcreteShapeRectangles implements Shape{
    private ColorPicker FillColor;
    private ColorPicker LineColor;
    private double width, height;
    GraphicsContext graphicsContext;
     public ConcreteShapeRectangles(){ 
      this.width = 4;
      this.height = 2;
      LineColor.setValue(Color.BLACK);
      FillColor.setValue(Color.WHITE);
     }
    private Rectangle rectangle = new Rectangle();
    @Override
    public void setLineColor(ColorPicker colorPicker){
        this.LineColor = colorPicker;
    }
    public void setFillColor(ColorPicker colorPicker){
        this.FillColor = colorPicker;
    }
    public void setWidth(double width){
        this.width=width;
        rectangle.setWidth(Math.abs((width)));
    }
    public void setHeight(double height){
        this.height=height;
        rectangle.setHeight(height);
    }
    public double getWidth(){
        return rectangle.getWidth();
    }
    public double getHeight() {
        return rectangle.getHeight();
    }
    @Override
    public ColorPicker getLineColor(){
        return LineColor;
    }
    public ColorPicker getFillColor(){
        return FillColor;
    }
    public void setGraphicsContext(GraphicsContext graphicsContext){
        this.graphicsContext = graphicsContext;
    }
    
}
