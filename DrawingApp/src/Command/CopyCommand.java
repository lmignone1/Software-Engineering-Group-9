/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Shapes.Shape;

/**
 *
 * @author Davide
 */
public class CopyCommand implements Command {

    Select shape;

    public CopyCommand(Select shape) {
        this.shape = shape;
    }

    public Shape getCopy() {
        return shape.getCopyShape();
    }

    @Override
    public void execute() {
        this.shape.copy();
    }

    @Override
    public void undo() {
        this.shape.setCopyShape(null);
    }

}