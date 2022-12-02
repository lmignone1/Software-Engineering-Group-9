/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Factory.Creator;
import Shapes.Shape;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.control.ColorPicker;
import javafx.scene.effect.Light.Point;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;

/**
 *
 * @author Davide
 * //Receiver
 */
public class Select {
    
    private List<Shape> list;
    private Shape selectedShape;
    private Shape copyShape;
    private Shape cutShape;
    private Creator creator = new Creator();
    private ColorPicker previusLineColor;
    private ColorPicker previusFillColor;

   public Select(List<Shape> shape, Shape selectedShape) {

        this.list = shape;
        this.selectedShape = selectedShape;
   }

   public List<Shape> getShape() {
        return list;
    }

   public void setShape(List<Shape> shape) {
        this.list = shape;
    }

   public Shape getSelectedShape() {

        return selectedShape;
    }

    public void setCopyShape(Shape copyShape){
        this.copyShape=copyShape;
    }
    public Shape getCopyShape() {
        return copyShape;
    }
 

   public void setSelectedShape(Shape selectedShape) {

        this.selectedShape = selectedShape;
    }

  
    public ColorPicker getPreviusLineColor() {
        return previusLineColor;
    }

    public void setPreviusLineColor(ColorPicker previusLineColor) {
        this.previusLineColor = previusLineColor;
    }

    public ColorPicker getPreviusFillColor() {
        return previusFillColor;
    }

    public void setPreviusFillColor(ColorPicker previusFillColor) {
        this.previusFillColor = previusFillColor;
    }
       
    public void delete(){
        list.remove(this.selectedShape);
    }
    
    public void copy(){ 
        this.copyShape = this.creator.createShape(this.selectedShape.getType(), this.selectedShape.getGraphicsContext(), 
                0 ,0, this.selectedShape.getLineColor(), this.selectedShape.getFillColor());
    }
    

    public void paste(){
        
        //this.copyShape.draw();
        this.list.add(this.copyShape);

    }
 
    public void cut(){
        copy();
        delete();
    }
    

    public void move(double x,double y,Shape shape){ // SCRITTA A CASO DA RIVEDERE
       shape.setX(x);
       shape.setY(y);
       
    }
    public void changeColor(ColorPicker lineColor, ColorPicker fillColor) {
        
        if(this.selectedShape.getType().equals("Line")){
            setPreviusLineColor(this.selectedShape.getLineColor());
        }else{
            setPreviusLineColor(this.selectedShape.getLineColor());
            setPreviusFillColor(this.selectedShape.getFillColor());
        }
        
        if(this.selectedShape.getType().equals("Line")){
            this.selectedShape.setLineColor(lineColor);
        }else{
            this.selectedShape.setLineColor(lineColor);
            this.selectedShape.setFillColor(fillColor);
        }
    }
}
