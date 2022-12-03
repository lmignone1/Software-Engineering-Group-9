/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workspace;

import Command.Command;
import Command.DeleteCommand;
import Command.Invoker;
import Command.Select;
import Command.changeColorCommand;
import Command.copyCommand;
import Command.pasteCommand;
import Command.cutCommand;
import Factory.Creator;
import Shapes.Shape;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;

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
    private MenuItem newProjectMenu;
    @FXML
    private MenuItem loadProjectMenu;
    @FXML
    private MenuItem saveProjectMenu;
    @FXML
    private MenuItem lineSegmentMenu;
    @FXML
    private MenuItem rectangleMenu;
    @FXML
    private MenuItem ellipseMenu;
    @FXML
    private AnchorPane pane;
    
    private String mod;
    private GraphicsContext gc;

    public List<Shape> shape = null;
    
    private Invoker invoker;
    private static Select selectShape;
    private Command command = null;
    private double pasteX,pasteY;
    
    ContextMenu contextMenu = new ContextMenu();
    MenuItem deleteMenu = new MenuItem("Delete");
    MenuItem moveMenu = new MenuItem("Move");
    MenuItem copyMenu = new MenuItem("Copy");
    MenuItem pasteMenu = new MenuItem("Paste");
    MenuItem cutMenu = new MenuItem("Cut");
    MenuItem colorMenu = new MenuItem("Change colour");
    MenuItem sizeMenu = new MenuItem("Change size");
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shape = new ArrayList<>();
        invoker = new Invoker();
        pasteMenu.setDisable(true);
        selectShape = new Select(shape,null);
    } 
    
    private void loadWindow(String location, String title) throws IOException{ //metodo per far apparire una nuova finestra. Usato per la creazione di nuovi progetti
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
    private void loadProject(ActionEvent event) { //metodo per aprire un progetto esistente
        FileChooser openFile = new FileChooser();
        openFile.setTitle("Open File");
        File file = openFile.showOpenDialog(Workspace.stage);
        if (file != null) {
            try {
                InputStream io = new FileInputStream(file);
                Image img = new Image(io);
                drawingCanvas.getGraphicsContext2D().drawImage(img, 0, 0);
            } catch (IOException ex) {
                System.out.println("Error!");
            }
        }
    }
     
    @FXML
    private void saveProject(ActionEvent event) throws IOException { //metodo per salvare il progetto
        FileChooser save = new FileChooser();
        save.setTitle("Save Image");
        File file = save.showSaveDialog(Workspace.stage);
        if (file != null) {
            try {
                WritableImage image = new WritableImage(1400, 1000); //empty image
                drawingCanvas.snapshot(null, image); //screenshot saved in the image
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);  // save an image after that the image object has been converted from a javafx image 
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }
    @FXML
    private void resizeCanvas(MouseEvent event){
        drawingCanvas.setWidth(pane.getWidth());
        drawingCanvas.setHeight(pane.getHeight());
        drawingCanvas.setLayoutX(pane.getScaleX());
        drawingCanvas.setLayoutY(pane.getScaleY());
        
    }

    @FXML
    private void makeDraw(MouseEvent event){
        gc = drawingCanvas.getGraphicsContext2D();
        Creator c = new Creator();
        
        if(event.isPrimaryButtonDown() ){
            Shape shapeCreated = c.createShape(mod, gc, event.getX(), event.getY() ,selectedContourColour, selectedFullColour);
            shape.add(shapeCreated);
            shapeCreated.draw();
        }
        if(event.isSecondaryButtonDown()){
            select(event);
        }
    }
    
    @FXML
    private void lineSegment(ActionEvent event) {
        mod = "Line";
        selectedFullColour.setDisable(true);
    }

    @FXML
    private void rectangle(ActionEvent event) {
        mod = "Rectangle";
        selectedFullColour.setDisable(false);
    }

    @FXML
    private void ellipse(ActionEvent event) {
        mod = "Ellipse";
        selectedFullColour.setDisable(false);
    }
    
    private void select(MouseEvent event) {
        Iterator<Shape> it = shape.iterator();
        while (it.hasNext()) {
            Shape elem = it.next();
            if (elem.containsPoint(event.getX(), event.getY())) {
                selectShape.setSelectedShape(elem);
                initContextMenu();
            }       
        }
        pasteX = event.getX();
        pasteY = event.getY();
    }
    
    private void drawAll(){
        Iterator<Shape> it = shape.iterator();
        System.out.println("drawAll" + shape);
        gc.clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
        while (it.hasNext()) {
                Shape elem = it.next();
                elem.draw();
        }
    }
    private Select oldSelectShape = null;
    private void initContextMenu(){
        contextMenu.getItems().addAll(deleteMenu, moveMenu, copyMenu, pasteMenu, cutMenu, colorMenu, sizeMenu);
        drawingCanvas.setOnContextMenuRequested(e -> contextMenu.show(drawingCanvas, e.getScreenX(), e.getScreenY()));
        
        
        
        deleteMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the deleteMenu item
         public void handle(ActionEvent event) {
            delete();
         }
        });
        
        moveMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the moveMenu item
         public void handle(ActionEvent event) {
            //move();
            mod = "move";
         }
        });
        
        copyMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the copyMenu item
         public void handle(ActionEvent event) {
            copy();
            pasteMenu.setDisable(false);
         }
        });
        
        moveMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the moveMenu item
         public void handle(ActionEvent event) {
            //move();
            mod = "move";
         }
        });
        
        pasteMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the moveMenu item
         public void handle(ActionEvent event) {
            //move();
            paste(pasteX,pasteY);
            
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
       
    }
    
    public void delete(){
        command = new DeleteCommand(selectShape);
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
    }
    
    public void move(){
        System.out.println("faccio la move");
    }
    
    public void copy(){
        command = new copyCommand(selectShape);
        invoker.setCommand(command);
        invoker.startCommand();
        
    }
    
    public void paste(double x, double y){
        command = new pasteCommand(selectShape, x ,y);
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
    }
    
    public void cut(){
        command = new cutCommand(selectShape);
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
    }
    
    public void changeColor(){
        command = new changeColorCommand(selectShape, selectedContourColour, selectedFullColour);
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
        
    }   
   
    
    public void changeSize(){
        
    }

    @FXML
    private void undoCommand(ActionEvent event) {
        invoker.startUndo();
        drawAll();
    }
}    
