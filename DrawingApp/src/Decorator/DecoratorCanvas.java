package Decorator;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

//Decorator: modella ogni possibile aggiunta non prevista ad un prodotto (es ingrediente aggiuntivo di un panino)
//l'interfaccia tra il CanvasComponent e il ConcreteDecorator: possiede un riferimento al CanvasComponent e un'interfaccia ad esso conforme

public class DecoratorCanvas implements CanvasComponent {
    
    protected CanvasComponent component;

    public DecoratorCanvas(CanvasComponent decoratedComponent) {
        this.component = decoratedComponent;
    }
    
    @Override
    public void execute(){
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
