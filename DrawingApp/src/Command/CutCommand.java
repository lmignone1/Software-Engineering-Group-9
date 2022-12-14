/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author loren
 */
public class CutCommand implements Command {

    private Select shape;
    private double pos;

    public CutCommand(Select shape, double pos) {
        this.shape = shape;
        this.pos = pos;
    }

    @Override
    public void execute() {
        this.shape.cut();
    }

    @Override
    public void undo() {

        this.shape.setCopyShape(null);
        this.shape.getShape().add((int) pos, this.shape.getMemory().popStackShape());

    }
}
