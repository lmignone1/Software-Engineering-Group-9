/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author Davide
 */
public class CutCommand implements Command{
    
    Select shape;

    public CutCommand(Select shape) {
        this.shape = shape;
    }

    @Override
    public void execute() {
        this.shape.cut();
    }

    @Override
    public void undo() {
        shape.getShape().add(this.shape.getStackShape().pop());
       
    }
}
