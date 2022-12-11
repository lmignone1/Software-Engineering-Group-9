/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workspace;

import Command.ChangeColorCommand;
import Command.ChangeSizeCommand;
import Command.Command;
import Command.CopyCommand;
import Command.CutCommand;
import Command.DeleteCommand;
import Command.Invoker;
import Command.MoveCommand;
import Command.PasteCommand;
import Command.RotateCommand;
import Command.Select;
import Decorator.ConcreteCanvas;
import Decorator.GridDecorator;
import Command.ToBackCommand;
import Command.ToFrontCommand;
import Decorator.BorderPaneComponent;
import Decorator.ConcreteBorderPane;
import Decorator.ScrollBarsBorderPane;
import Factory.Creator;
import Functions.FileDraw;
import Functions.Zoom;
import Shapes.Shape;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javax.imageio.ImageIO;
import Decorator.CanvasComponent;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

/**
 * FXML Controller class
 *
 * @author artem
 */
public class WorkspaceController implements Initializable {

    @FXML
    private Canvas drawingCanvas;

    @FXML
    private ColorPicker selectedContourColour;
    @FXML
    private ColorPicker selectedFullColour;

    @FXML
    private AnchorPane pane;

    private String mod;
    private GraphicsContext gc;
    private Creator creator;
    public List<Shape> listShape = null;
    private String oldMod;
    private Invoker invoker;
    private Select selectShape;
    private Command command = null;
    private double pastX, pastY;
    private Scale scale;

    ContextMenu contextMenu = new ContextMenu();
    MenuItem deleteMenu = new MenuItem("Delete");
    MenuItem moveMenu = new MenuItem("Move");
    MenuItem copyMenu = new MenuItem("Copy");
    MenuItem pasteMenu = new MenuItem("Paste");
    MenuItem cutMenu = new MenuItem("Cut");
    MenuItem colorMenu = new MenuItem("Change colour");
    MenuItem sizeMenu = new MenuItem("Change size");
    MenuItem toFrontMenu = new MenuItem("To Front");
    MenuItem toBackMenu = new MenuItem("To Back");
    MenuItem rotateMenu = new MenuItem("Rotate");
    
    @FXML
    private TextField sizeX;
    @FXML
    private TextField sizeY;

    //da cambiare 
    private Select changeShape = null;
    @FXML
    private MenuItem newProjectMenu;
    @FXML
    private MenuItem loadProjectMenu;
    @FXML
    private MenuItem saveProjectMenu;

    private CanvasComponent component;
    private CanvasComponent gridDecorator;
    @FXML
    private TextField gridSize;
    @FXML
    private BorderPane borderPane;

    public static BorderPaneComponent componentBorderPane;
    @FXML
    private TextField text;
    @FXML
    private ColorPicker textPicker;
    @FXML
    private TextField rotateField;
    
    private Shape shape;
    private boolean flagIrregular = true;
    @FXML
    private Button textButton;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = drawingCanvas.getGraphicsContext2D();
        creator = new Creator();
        listShape = new ArrayList<>();
        invoker = new Invoker();
        pasteMenu.setDisable(true);
        selectShape = new Select(listShape, null);
        oldMod = null;

        componentBorderPane = new ScrollBarsBorderPane(new ConcreteBorderPane(borderPane), drawingCanvas);

        gridSize.setText("50");
        component = new ConcreteCanvas(drawingCanvas);
        gridDecorator = new GridDecorator(component);
        scale = new Scale();
        drawingCanvas.getTransforms().add(scale);
        textPicker.setValue(Color.BLACK);

        gc.setTransform(new Affine());
    }

    private void loadWindow(String location, String title) throws IOException { //metodo per far apparire una nuova finestra. Usato per la creazione di nuovi progetti
        Parent root = FXMLLoader.load(getClass().getResource(location));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle(title);

        stage.show();
    }

    @FXML
    private void newProject(ActionEvent event) throws IOException { //metodo per creare un nuovo progetto
        loadWindow("/workspace/Workspace.fxml", " ");
    }

    @FXML
    private void loadProject(ActionEvent event) throws IOException { //metodo per aprire un progetto esistente
        FileChooser openFile = new FileChooser();
        openFile.setTitle("Open File");
        File file = null;
        do {
            file = openFile.showOpenDialog(Workspace.stage);
        } while (!file.getName().contains(".txt"));
        FileDraw.loadDraw(listShape, file.getAbsolutePath(), gc);
    }

    @FXML
    private void saveProject(ActionEvent event) throws IOException { //metodo per salvare il progetto
        FileChooser save = new FileChooser();
        save.setTitle("Save Image");
        File file = save.showSaveDialog(Workspace.stage);
        
        if (file != null) {
            FileDraw.saveDraw(listShape, file.getAbsolutePath());
        }
        
    }

    @FXML
    private void resizeCanvas(MouseEvent event) {

        if (pane.getWidth() > 800 && pane.getHeight() > 600) {
            drawingCanvas.setWidth(pane.getWidth());
            drawingCanvas.setHeight(pane.getHeight());
            //drawAll();
        }

    }

    @FXML
    private void makeDraw(MouseEvent event) {

        if (event.isPrimaryButtonDown() && (mod.equals("Line") || mod.equals("Rectangle") || mod.equals("Ellipse") || mod.equals("IrregularPolygon"))) {

            if (oldMod != null) {
                mod = oldMod;
                oldMod = null;
            }

            Shape shapeCreated = creator.createShape(mod, gc, event.getX(), event.getY(), selectedContourColour, selectedFullColour);
            listShape.add(shapeCreated);
            if(shapeCreated.getType().equals("IrregularPolygon")){
                shape = shapeCreated;
                flagIrregular = true;
            }else{
                //listShape.add(shapeCreated);
                shapeCreated.draw();
            }
           
        }
        else if (event.isPrimaryButtonDown() && mod.equals("Text")){
            
            if (oldMod != null) {
                mod = oldMod;
                oldMod = null;
            }

            Shape shapeCreated = creator.createShape(mod, gc, event.getX(), event.getY(), selectedContourColour, textPicker, 10, 10, text.getText(), 0.0);
            listShape.add(shapeCreated);
            shapeCreated.draw();
        }
        if (event.isSecondaryButtonDown()) {
            select(event);//QUANDO SELEZIONI UNA SECONDA VOLTA LANCIA SEMPRE UN ECCEZIONE Exception in thread "JavaFX Application Thread" java.lang.UnsupportedOperationException
        }
        if (event.isPrimaryButtonDown() && mod.equals("Move")) {
            move(event.getX(), event.getY());
            mod = oldMod;
            oldMod = null;
        }

    }
    @FXML
    private void drag(MouseEvent event) {
        if(mod.equals("IrregularPolygon") && !mod.equals("Move")){
            shape.setXY(event.getX(), event.getY());
            try{
                Thread.sleep(250);
            }
            catch (Exception e){ }
            }
            System.out.println("sono in drag");
    }

    @FXML
    private void endDrawPolygon(MouseEvent event) {
        
        if(mod.equals("IrregularPolygon") && flagIrregular && !mod.equals("Move") ){
            //shape.setXY(event.getX(), event.getY());
             
            shape.draw();
            flagIrregular = false;
            //shape = null; // non so se migliora o no 
            
        }
        //mod = "";
       

    }


    private void select(MouseEvent event) {
        Iterator<Shape> it = listShape.iterator();
        while (it.hasNext()) {
            Shape elem = it.next();
            if (elem.containsPoint(event.getX(), event.getY())) {
                selectShape.setSelectedShape(elem);
                System.out.println("--------SELECT---------");
                
                if (elem.getType().equals("Text") || elem.getType().equals("IrregularPolygon")) {
                    sizeMenu.setDisable(true);
                    
                } else {
                    sizeMenu.setDisable(false);
                }
            } else if (selectShape.getSelectedShape() == null) {
                selectShape.setSelectedShape(null);
            }
        }

        initContextMenu();
        /*if (selectShape.getSelectedShape() == null) {
            //System.out.println(selectShape.getSelectedShape());//CONTROLLARE QUANDO è NULL
            selectShape.setSelectedShape(null); //PER ESEMPIO COSì MA POI BISOGNA FARE DEI CHECK NEI NELLE VARIE OPERAZIONI
        }*/
        System.out.println(selectShape.getSelectedShape());
        pastX = event.getX();
        pastY = event.getY();
    }

    /* private void sel(){
           
            toFront(listShape.indexOf(selectShape.getSelectedShape()),listShape.size());
            
        }
    private void desel(){
        toFront(previousPosition,previousPosition);
    }*/
    private void drawAll() {
        Iterator<Shape> it = listShape.iterator();
        gc.clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
        while (it.hasNext()) {
            Shape elem = it.next();
            elem.draw();
        }
    }
    private int previousPosition;

    private void sel(MouseEvent event) {

        if (selectShape.getSelectedShape().containsPoint(event.getX(), event.getY())) {
            listShape.add(listShape.size() - 1, selectShape.getSelectedShape());
        }

    }

    @FXML
    private void rectangle(MouseEvent event) {
        mod = "Rectangle";
        selectedFullColour.setDisable(false);
        sizeX.setDisable(false);
        sizeY.setDisable(false);
    }

    @FXML
    private void lineSegment(MouseEvent event) {
        mod = "Line";
        selectedFullColour.setDisable(true);
        sizeX.setDisable(false);
        sizeY.setDisable(true);
    }

    @FXML
    private void ellipse(MouseEvent event) {
        mod = "Ellipse";
        selectedFullColour.setDisable(false);
        sizeX.setDisable(false);
        sizeY.setDisable(false);
    }
    
    @FXML
    private void irregularPolygon(ActionEvent event) {
        mod = "IrregularPolygon";
        selectedFullColour.setDisable(false);
        sizeX.setDisable(true);
        sizeY.setDisable(true);
       
    }


    private void initContextMenu() {
        contextMenu.getItems().addAll(deleteMenu, moveMenu, copyMenu, pasteMenu, cutMenu, colorMenu, sizeMenu, rotateMenu, toFrontMenu, toBackMenu);
        drawingCanvas.setOnContextMenuRequested(e -> contextMenu.show(drawingCanvas, e.getScreenX(), e.getScreenY()));
        /* contextMenu.showingProperty().addListener((observable, oldValue, newValue) -> {
        if(newValue==false&&flag==true){
        
        flag=false;
        }
    });*/

        deleteMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the deleteMenu item
            public void handle(ActionEvent event) {
                delete();
            }
        });

        moveMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the moveMenu item
            public void handle(ActionEvent event) {
                if (mod.equals("Line") || mod.equals("Rectangle") || mod.equals("Ellipse") || mod.equals("Text") || mod.equals("IrregularPolygon")) {
                    oldMod = mod;
                }
                mod = "Move";

            }
        });

        copyMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the copyMenu item
            public void handle(ActionEvent event) {
                copy();
                pasteMenu.setDisable(false);

            }
        });

        pasteMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the moveMenu item
            public void handle(ActionEvent event) {
                paste(pastX, pastY);
            }
        });

        cutMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the cutMenu item
            public void handle(ActionEvent event) {
                cut();
                pasteMenu.setDisable(false);
            }
        });

        colorMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the colorMenu item
            public void handle(ActionEvent event) {
                changeColor();
            }
        });

        sizeMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the sizeMenu item
            public void handle(ActionEvent event) {
                changeSize();
                
            }
        });
        
        toFrontMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the sizeMenu item
            public void handle(ActionEvent event) {
                toFront(listShape.indexOf(selectShape.getSelectedShape()), listShape.size());
            }
        });
        
        toBackMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the sizeMenu item
            public void handle(ActionEvent event) {
                toBack(listShape.indexOf(selectShape.getSelectedShape()));
            }
        });
        
        rotateMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the rotateMenu item
            public void handle(ActionEvent event) {
                rotate();
            }
        });
    }

    public void toFront(double index, double size) {
        command = new ToFrontCommand(selectShape, index, size);
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
    }

    public void toBack(double index) {
        command = new ToBackCommand(selectShape, index);
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();

    }

    public void delete() {
        command = new DeleteCommand(selectShape);
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
    }

    public void move(double x, double y) {
        command = new MoveCommand(selectShape, x, y, pastX, pastY);
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
    }

    public void copy() {
        command = new CopyCommand(selectShape);
        invoker.setCommand(command);
        invoker.startCommand();

    }

    public void paste(double x, double y) {
        command = new PasteCommand(selectShape, x, y);
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
    }

    public void cut() {
        command = new CutCommand(selectShape);
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
    }

    public void changeColor() {
        if (selectShape.getSelectedShape().getType().equals("Text")) {
            command = new ChangeColorCommand(selectShape, selectShape.getSelectedShape().getLineColor(), textPicker);
        } else {
            command = new ChangeColorCommand(selectShape, selectedContourColour, selectedFullColour);
        }
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();

    }

    public void changeSize() { //CONTROLLARE QUANDO L'UTENTE NON INSERISCE NULLA NELLE CASELLE DI TESTO DI SIZEX E SIZEY, LANCIA UN ECCEZIONE
        String x1 = sizeX.getText();
        String y1 = sizeY.getText(); 
        Double x = new Double(x1);

        if (selectShape.getSelectedShape().getType().equals("Line")) {
            command = new ChangeSizeCommand(selectShape, x.doubleValue(), pastX, pastY);
        } else {
            Double y = new Double(y1);
            command = new ChangeSizeCommand(selectShape, x.doubleValue(), y.doubleValue(), pastX, pastY);

        }
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
    }

    public void rotate() {
        String x = rotateField.getText();
        command = new RotateCommand(selectShape, Double.parseDouble(x));
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
    }

    @FXML
    private void undoCommand(ActionEvent event) {
        invoker.startUndo();
        drawAll();
    }

    @FXML
    private void zoom(ScrollEvent event) {
        Zoom.zoom(scale, event.getX(), event.getY(), event.getDeltaY());
    }

    @FXML
    private void enableGrid(ActionEvent event) {

        Iterator<Shape> it = listShape.iterator();

        String g = gridSize.getText();
        Integer grid = new Integer(g);
        component.setGridSizeInput(grid.intValue());
        gridDecorator.execute();
        System.out.println(grid.intValue());

        while (it.hasNext()) {
            Shape elem = it.next();
            elem.draw();
        }
    }

    @FXML
    private void disableGrid(ActionEvent event) {
        gc.clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
        drawAll();
    }

    @FXML
    private void addText(ActionEvent event) {
        mod = "Text";
    }
}
