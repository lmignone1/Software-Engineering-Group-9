package Decorator;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

//Decorator: modella ogni possibile aggiunta non prevista ad un prodotto (es ingrediente aggiuntivo di un panino)
//l'interfaccia tra il Component e il ConcreteDecorator: possiede un riferimento al Component e un'interfaccia ad esso conforme

public class Decorator implements Component {
    
    protected Component component;

    public Decorator(Component decoratedComponent) {
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
