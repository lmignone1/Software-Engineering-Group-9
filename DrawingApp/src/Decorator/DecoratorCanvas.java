package Decorator;

import javafx.scene.canvas.Canvas;

public class DecoratorCanvas implements CanvasComponent {

    protected CanvasComponent component;

    public DecoratorCanvas(CanvasComponent decoratedComponent) {
        this.component = decoratedComponent;
    }

    @Override
    public void execute() {
        this.component.execute();
    }

    @Override
    public Canvas getCanvas() {
        return component.getCanvas();
    }

    @Override
    public void setGridSizeInput(int size) {
        component.setGridSizeInput(size);
    }

    @Override
    public int getGridSizeInput() {
        return component.getGridSizeInput();
    }

}
