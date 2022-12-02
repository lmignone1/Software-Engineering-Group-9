/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author Davide
 */
public class cutCommand implements Command{
    
    Select shape;

    public cutCommand(Select shape) {
        this.shape = shape;
    }

    @Override
    public void execute() {
        this.shape.cut();
    }

    @Override
    public void undo() {
        shape.getShape().add(shape.getCopyShape());
        shape.setCopyShape(null);
    }
}
