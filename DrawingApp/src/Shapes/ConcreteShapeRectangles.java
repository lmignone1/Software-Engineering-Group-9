/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

/**
 *
 * @author Acer
 */
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Rectangle;

public class ConcreteShapeRectangles implements Shapes{
    private ColorPicker FillColor, LineColor;
    public double width, height, PositionX, PositionY;

    private Rectangle rectangle = new Rectangle();
    @Override
    public void setLineColor(ColorPicker colorPicker){
        this.LineColor = colorPicker;
    }

    public void setFillColor(ColorPicker colorPicker){
        this.FillColor = colorPicker;
    }

    public void setWidth(){
        this.width = 4;

        rectangle.setWidth(Math.abs((width)));
    }

    public void setHeight(){
        this.height = 2;

        rectangle.setHeight(height);
    }

   
    public double getPositionX(){
        return rectangle.getX();
    }

    public double getPositionY(){
        return rectangle.getY();
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
   

}
