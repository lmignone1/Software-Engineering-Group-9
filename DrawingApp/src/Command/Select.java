/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Factory.Creator;
import Shapes.Shape;
import java.util.List;
import javafx.geometry.Point2D;


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

   public void setSelectedShape(Shape selectedShape) {
        this.selectedShape = selectedShape;
    }

    public Shape getCopyShape() {
        return copyShape;
    }

    public void setCopyShape(Shape copyShape) {
        this.copyShape = copyShape;
    }
    
    public void delete(){
        list.remove(this.selectedShape);
    }
    
    public void copy(){ 
        this.copyShape = this.creator.createShape(this.selectedShape.getType(), this.selectedShape.getGraphicsContext(), 
                0 ,0, this.selectedShape.getLineColor(), this.selectedShape.getFillColor());
    }
    
    public void paste(){  
        this.list.add(this.copyShape);
   }
    
    public void cut(){
        copy();
        delete();
    }
    
    public void move(Point2D point, Shape shape){ // SCRITTA A CASO DA RIVEDERE
        double newX = point.getX();
        double newY = point.getY();
        
        shape.setXY(newX, newY);
    }
    
}
