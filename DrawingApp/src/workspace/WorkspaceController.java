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
import Command.Select;
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
import javafx.scene.control.TextField;
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
    private AnchorPane pane;

    private String mod;
    private GraphicsContext gc;
    private Creator creator;
    public List<Shape> shape = null;
    private String oldMod; 
    private Invoker invoker;
    private static Select selectShape;
    private Command command = null;
    private double pastX, pastY;
    

    ContextMenu contextMenu = new ContextMenu();
    MenuItem deleteMenu = new MenuItem("Delete");
    MenuItem moveMenu = new MenuItem("Move");
    MenuItem copyMenu = new MenuItem("Copy");
    MenuItem pasteMenu = new MenuItem("Paste");
    MenuItem cutMenu = new MenuItem("Cut");
    MenuItem colorMenu = new MenuItem("Change colour");
    MenuItem sizeMenu = new MenuItem("Change size");
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
    @FXML
    private MenuItem lineSegmentMenu;
    @FXML
    private MenuItem rectangleMenu;
    @FXML
    private MenuItem ellipseMenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = drawingCanvas.getGraphicsContext2D();
        creator = new Creator();
        shape = new ArrayList<>();
        invoker = new Invoker();
        pasteMenu.setDisable(true);
        selectShape = new Select(shape, null);
        oldMod = null;
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
    private void resizeCanvas(MouseEvent event) {
        drawingCanvas.setWidth(pane.getWidth());
        drawingCanvas.setHeight(pane.getHeight());
        drawingCanvas.setLayoutX(pane.getScaleX());
        drawingCanvas.setLayoutY(pane.getScaleY());

    }

    @FXML
    private void makeDraw(MouseEvent event) {
       
        

        if (event.isPrimaryButtonDown() && (mod == "Rectangle" || mod == "Ellipse" || mod == "Line")) {

            if (oldMod != null) {
                mod = oldMod;
                oldMod = null;
            }
            Shape shapeCreated = creator.createShape(mod, gc, event.getX(), event.getY(), selectedContourColour, selectedFullColour);
            shape.add(shapeCreated);
            shapeCreated.draw();
        }
        if (event.isSecondaryButtonDown()) {
            select(event);

        }
        if (event.isPrimaryButtonDown() && mod == "Move") {
            move(event.getX(), event.getY());
            mod = oldMod;
            oldMod = null;
        }

    }

    @FXML
    private void lineSegment(ActionEvent event) {
        mod = "Line";
        selectedFullColour.setDisable(true);
        sizeY.setDisable(true);
    }

    @FXML
    private void rectangle(ActionEvent event) {
        mod = "Rectangle";
        selectedFullColour.setDisable(false);
        sizeY.setDisable(false);
    }

    @FXML
    private void ellipse(ActionEvent event) {
        mod = "Ellipse";
        selectedFullColour.setDisable(false);
        sizeY.setDisable(false);
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
        pastX = event.getX();
        pastY = event.getY();
    }

    private void drawAll() {
        Iterator<Shape> it = shape.iterator();
        gc.clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
        while (it.hasNext()) {
            Shape elem = it.next();
            elem.draw();
        }
    }

    private void initContextMenu() {
        contextMenu.getItems().addAll(deleteMenu, moveMenu, copyMenu, pasteMenu, cutMenu, colorMenu, sizeMenu);
        drawingCanvas.setOnContextMenuRequested(e -> contextMenu.show(drawingCanvas, e.getScreenX(), e.getScreenY()));

        deleteMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the deleteMenu item
            public void handle(ActionEvent event) {
                delete();
            }
        });

        moveMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the moveMenu item
            public void handle(ActionEvent event) {
                if (mod.equals("Line") || mod.equals("Rectangle") || mod.equals("Ellipse")) {
                    oldMod = mod;
                }

                mod = "Move";

            }
        });

        copyMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the copyMenu item
            public void handle(ActionEvent event) {
                /*
            if(mod.equals("Line") || mod.equals("Rectangle") || mod.equals("Ellipse")){
                oldMod = mod;
            }
                 */
                copy();
                pasteMenu.setDisable(false);
                //mod = "copy";
            }
        });

        pasteMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the moveMenu item
            public void handle(ActionEvent event) {
                //move();
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
                changeShape = new Select(shape, selectShape.getSelectedShape());
                changeColor();

            }
        });

        sizeMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the sizeMenu item
            public void handle(ActionEvent event) {
                changeSize();

            }
        });

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
        command = new ChangeColorCommand(selectShape, selectedContourColour, selectedFullColour);
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();

    }

    public void changeSize() {
        String x1 = sizeX.getText();
        String y1 = sizeY.getText();
        Double x = new Double(x1);
        
        if (Select.getSelectedShape().getType().equals("Line")) {
            command = new ChangeSizeCommand(selectShape, x.doubleValue());
        } else {
            Double y = new Double(y1);
            command = new ChangeSizeCommand(selectShape, x.doubleValue(), y.doubleValue());
        }
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
    }

    @FXML
    private void undoCommand(ActionEvent event) {
        invoker.startUndo();
        drawAll();
    }
}
