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
    private static Shape selectedShape;
    private Shape copyShape;
    private Shape changeShape;
    private Creator creator = new Creator();
    private ColorPicker previusLineColor;
    private ColorPicker previusFillColor;
    private Integer count = 0;
    private double previousX,previousY;
   public Select(List<Shape> shape, Shape selectedShape) {

        this.list = shape;
        Select.selectedShape = selectedShape;
   }

   public List<Shape> getShape() {
        return list;
    }

   public void setShape(List<Shape> shape) {
        this.list = shape;
    }


   public static Shape getSelectedShape(){
       return selectedShape;
   }

    public void setCopyShape(Shape copyShape){
        this.copyShape=copyShape;
    }
    public static void setSelectedShape(Shape selectedShape) {
        Select.selectedShape = selectedShape;

    }

    public Shape getCopyShape() {
        return copyShape;
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
        list.remove(Select.selectedShape);
    }
    
    public void copy(){ 
        this.copyShape = Creator.createShape(Select.selectedShape.getType(), Select.selectedShape.getGraphicsContext(), 
                Select.selectedShape.getX(),Select.selectedShape.getY(), Select.selectedShape.getLineColor(), Select.selectedShape.getFillColor());
         

    }
    

    public void paste(double x, double y){
        this.copyShape = this.creator.createShape(this.selectedShape.getType(), this.selectedShape.getGraphicsContext(), 
                x,y, this.selectedShape.getLineColor(), this.selectedShape.getFillColor());
        //this.copyShape.setXY(x,y);

        

        if(count == 0){
            this.copyShape.setXY(x,y);
            this.list.add(this.copyShape);
            count++;
        }else{
            
            copy();
            this.copyShape.setXY(x,y);
            this.list.add(this.copyShape);
             //count++;
        }

        System.out.println("shape copiata: " + copyShape);
        System.out.println("ho settato" + copyShape.getX());
        System.out.println("ho settato" + copyShape.getY());
        


        this.list.add(this.copyShape);

    
 
       
        System.out.println("list past" + list);

        copy();
        this.copyShape.setXY(x,y);
        this.list.add(this.copyShape);


   }

    public void cut(){
        this.copyShape = this.selectedShape;
        delete();
    }

    public double getPreviousX() {
        return previousX;
    }

    public double getPreviousY() {
        return previousY;
    }

    public void setPreviousX(double previousX) {
        this.previousX = previousX;
    }

    public void setPreviousY(double previousY) {
        this.previousY = previousY;
    }
    
    
    public void move(double newX,double newY, double previousX,double previousY){ // SCRITTA A CASO DA RIVEDERE
     setPreviousX(previousX);
     setPreviousY(previousY);
        selectedShape.setXY(newX,newY);
    }
    public void changeColor(ColorPicker lineColor, ColorPicker fillColor) {
        
        if(Select.selectedShape.getType().equals("Line")){
            setPreviusLineColor(Select.selectedShape.getLineColor());
        }else{
            setPreviusLineColor(Select.selectedShape.getLineColor());
            setPreviusFillColor(Select.selectedShape.getFillColor());
        }
        
        if(Select.selectedShape.getType().equals("Line")){
            Select.selectedShape.setLineColor(lineColor);
        }else{
            Select.selectedShape.setLineColor(lineColor);
            Select.selectedShape.setFillColor(fillColor);
        }
    }
}
