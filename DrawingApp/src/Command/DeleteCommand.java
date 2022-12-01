/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author Davide
 */
public class DeleteCommand implements Command {
    
    Select shape;



   public DeleteCommand(Select shape) {
        this.shape = shape;
    }
    
    @Override
    public void execute() {
        shape.delete();
    }



   @Override
    public void undo() {
        shape.getShape().add(shape.getSelectedShape());
    }

}
