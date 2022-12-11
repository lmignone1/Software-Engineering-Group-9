/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Shapes.Shape;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import javafx.geometry.Point2D;

/**
 *
 * @author Acer
 */
public class MoveCommand implements Command {

    private Select shape;
    private double previousX;
    private double previousY;
    private double newX;
    private double newY;

    public MoveCommand(Select shape, double newX, double newY, double previousX, double previousY) {
        this.shape = shape;
        this.newX = newX;
        this.newY = newY;
        this.previousX = previousX;
        this.previousY = previousY;
    }

    @Override
    public void execute() {
        this.shape.move(this.newX, this.newY, this.previousX, this.previousY);

    }

    @Override
    public void undo() { 
                
        if(this.shape.getMemory().getStackShape().peek().getType().equals("IrregularPolygon")){ 

            double distX;
            double distY;
            Shape irregularShape = this.shape.getMemory().popStackShape();
            double startX = irregularShape.getAllX()[0];
            double startY = irregularShape.getAllY()[0];
            double x = this.shape.getMemory().popStackDouble();
            double y = this.shape.getMemory().popStackDouble();
                  
            Point2D point = new Point2D(startX, startY);
            Point2D clickPointX = new Point2D(x, startY);
            Point2D clickPointY = new Point2D(startX, y);
            distX = point.distance(clickPointX);
            distY = point.distance(clickPointY);
            
            if (newX > startX && newY > startY) {

            } else if (newX < startX && newY < startY) {
                distX = -distX;
                distY = -distY;
            } else if (newX < startX && newY > startY) {
                distX = -distX;
            } else if (newX > startX && newY < startY) {
                distY = -distY;
            }

            ArrayList<Double> arrayListX = new ArrayList<>();
            ArrayList<Double> arrayListY = new ArrayList<>();
            irregularShape.setPolygonX(arrayListX);
            irregularShape.setPolygonY(arrayListY);
            System.out.println(Arrays.toString(irregularShape.getAllX()));
            System.out.println(Arrays.toString(irregularShape.getAllY()));
            
            for (int i = 0; i < irregularShape.getVertices(); i++) {

                double pastX = irregularShape.getAllX()[i];
                double pastY = irregularShape.getAllY()[i];
                
                System.out.println("pastX:" + pastX);
                System.out.println("pastY:" + pastY);

                double setX = pastX - distX;
                double setY = pastY - distY;

                irregularShape.setXY(setX, setY);
                
            }

        }else{
            this.shape.getMemory().popStackShape().setXY(this.shape.getMemory().popStackDouble(), this.shape.getMemory().popStackDouble());
        }
    }    

}
