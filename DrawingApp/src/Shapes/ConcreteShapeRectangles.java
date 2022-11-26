/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

/**
 *
 * @author Acer
 */
import static java.lang.Math.sqrt;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Rectangle;

public class ConcreteShapeRectangles implements Shape{
    private GraphicsContext graphicsContext;
    private ColorPicker cpLine;
    private ColorPicker cpFill;

    public double startX, startY, width, height;

    private Rectangle rectangle;

    public ConcreteShapeRectangles(){
        this.graphicsContext = null;
        this.cpLine = null;
        this.cpFill = null;
        this.startX = 0.0;
        this.startY = 0.0;
        this.width = 100;
        this.height = 50;
        this.rectangle = new Rectangle();
    }

    @Override
    public void setGraphicsContext(GraphicsContext graphicsContext){
        this.graphicsContext = graphicsContext;
    }
    
    @Override
    public GraphicsContext getGraphicsContext(){
        return this.graphicsContext;
    }
    
    @Override
    public void setLineColor(ColorPicker colorPicker){
        this.cpLine = colorPicker;
    }

    /**
     *
     * @param colorPicker
     */
    @Override
    public void setFillColor(ColorPicker colorPicker){
        this.cpFill = colorPicker;
    }

    public void setStart(double startX, double startY){
        this.startX = startX;
        this.startY = startY;
        rectangle.setX(startX - this.width/2);
        rectangle.setY(startY - this.height/2);
    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }
    
    public void setWidth(){
        rectangle.setWidth(this.width);
    }

    public void setHeight(){
        rectangle.setHeight(this.height);
    }
    public double getX(){
        return rectangle.getX();
    }

    public double getY(){
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
        return cpLine;
    }

    @Override
    public ColorPicker getFillColor(){
        return cpFill;
    }

    @Override
    public void drawShape(){
        graphicsContext.setStroke(cpLine.getValue());
        graphicsContext.setLineWidth(2);
        graphicsContext.setFill(cpFill.getValue());
        graphicsContext.fillRect(getX(), getY(), getWidth(), getHeight());
        graphicsContext.strokeRect(getX(), getY(), getWidth(), getHeight());
    }
}
