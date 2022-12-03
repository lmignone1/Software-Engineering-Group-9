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
    private Shape cutShape;
    private Creator creator = new Creator();
    private ColorPicker previusLineColor;
    private ColorPicker previusFillColor;
    private Integer count = 0;

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


   public static Shape getSelectedShape() {

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
        System.out.println("shape copiata: " + copyShape);
        System.out.println("shape selezionata: " + selectedShape);
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
   }

    public void cut(){
        this.copyShape = this.selectedShape;
        delete();
    }
    

    public void move(double x,double y){ // SCRITTA A CASO DA RIVEDERE
     selectedShape.setXY(x,y);
     
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
