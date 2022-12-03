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

    public static void setSelectedShape(Shape selectedShape) {
        Select.selectedShape = selectedShape;
    }
   
    public Shape getCopyShape() {
        return copyShape;
    }

    public void setCopyShape(Shape copyShape) {
        this.copyShape = copyShape;
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
        
       
        System.out.println("list past" + list);
   }
    
    public void cut(){
        this.copyShape = this.selectedShape;
        delete();
    }
    
    public void move(Point2D point, Shape shape){ // SCRITTA A CASO DA RIVEDERE
        double newX = point.getX();
        double newY = point.getY();
        
        shape.setXY(newX, newY);
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
