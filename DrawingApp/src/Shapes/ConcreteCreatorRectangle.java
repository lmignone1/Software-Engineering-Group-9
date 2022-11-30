/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

/**
 *
 * @author Acer
 */
public class ConcreteCreatorRectangle extends Creator{
    
    public static Shape createShape() {
        return new ConcreteShapeRectangles();   
    }
}
