/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;



/**
 *
 * @author loren
 */
public class ConcreteCreatorEllipse extends Creator {

    @Override
    public ConcreteShapeEllipses createShape() {
        return new ConcreteShapeEllipses();
    }
    
}
