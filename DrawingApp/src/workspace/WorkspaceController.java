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
import Command.ToMirrorCommand;
import Decorator.BorderPaneComponent;
import Decorator.ConcreteBorderPane;
import Decorator.ScrollBarsBorderPane;
import Factory.Creator;
import Functions.FileDraw;
import Functions.Zoom;
import Shapes.Shape;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Decorator.CanvasComponent;
import javafx.scene.transform.Affine;

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
    public List<Shape> listPrevious = null;
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
    MenuItem toMirrorMenu = new MenuItem("To Mirror");
    MenuItem rotateMenu = new MenuItem("Rotate");
    private boolean flag = false;
    private int previousPosition;
    @FXML
    private TextField sizeX;
    @FXML
    private TextField sizeY;

    //da cambiare 
    private Select changeShape = null;

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
    private MenuItem newProjectMenu;
    @FXML
    private MenuItem loadProjectMenu;
    @FXML
    private MenuItem saveProjectMenu;
    @FXML
    private Button textButton;

    private boolean flagGrid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = drawingCanvas.getGraphicsContext2D();
        creator = new Creator();
        listShape = new ArrayList<>();
        listPrevious = new ArrayList<>();
        invoker = new Invoker();
        pasteMenu.setDisable(true);
        selectShape = new Select(listShape, null);
        oldMod = null;

        componentBorderPane = new ScrollBarsBorderPane(new ConcreteBorderPane(borderPane), drawingCanvas);
        flagGrid = false;
        gridSize.setText("50");
        component = new ConcreteCanvas(drawingCanvas);
        gridDecorator = new GridDecorator(component);
        scale = new Scale();
        drawingCanvas.getTransforms().add(scale);
        textPicker.setValue(Color.BLACK);

        gc.setTransform(new Affine());
    }

    private void loadWindow(String location, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(location));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle(title);

        stage.show();
    }

    @FXML
    private void newProject(ActionEvent event) throws IOException {
        loadWindow("/workspace/Workspace.fxml", " ");
    }

    @FXML
    private void loadProject(ActionEvent event) throws IOException {
        FileChooser openFile = new FileChooser();
        openFile.setTitle("Open File");
        File file = null;
        do {
            file = openFile.showOpenDialog(Workspace.stage);
        } while (!file.getName().contains(".txt"));
        FileDraw.loadDraw(listShape, file.getAbsolutePath(), gc);
    }

    @FXML
    private void saveProject(ActionEvent event) throws IOException {
        FileChooser save = new FileChooser();
        save.setTitle("Save Image");
        File file = save.showSaveDialog(Workspace.stage);

        if (file != null) {
            FileDraw.saveDraw(listShape, file.getAbsolutePath());
        }

    }

    @FXML
    private void resizeCanvas(MouseEvent event) {
        //CHANGE THE CANVAS SIZE IF THE PANE'S SIZE IS BIGGER THAN THE CANVAS
        if (pane.getWidth() > 1200 && pane.getHeight() > 700) {
            drawingCanvas.setWidth(pane.getWidth());
            drawingCanvas.setHeight(pane.getHeight());
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
            listPrevious.add(shapeCreated);
            if (shapeCreated.getType().equals("IrregularPolygon")) {
                shape = shapeCreated;
                flagIrregular = true;
            } else {
                shapeCreated.draw();
            }

        } else if (event.isPrimaryButtonDown() && mod.equals("Text")) {

            if (oldMod != null) {
                mod = oldMod;
                oldMod = null;
            }

            Shape shapeCreated = creator.createShape(mod, gc, event.getX(), event.getY(), selectedContourColour, textPicker, 10, 10, text.getText(), 0.0);
            listShape.add(shapeCreated);
            listPrevious.add(shapeCreated);
            shapeCreated.draw();
        }
        if (event.isSecondaryButtonDown()) {
            select(event);
        }
        if (event.isPrimaryButtonDown() && mod.equals("Move")) {
            move(event.getX(), event.getY());
            mod = oldMod;
            oldMod = null;
        }

    }

    @FXML
    private void drag(MouseEvent event) {
        if (mod.equals("IrregularPolygon") && !mod.equals("Move")) {
            shape.setXY(event.getX(), event.getY());
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }
    }

    @FXML
    private void endDrawPolygon(MouseEvent event) {

        if (mod.equals("IrregularPolygon") && flagIrregular && !mod.equals("Move")) {

            shape.draw();
            flagIrregular = false;
        }
    }

    private void select(MouseEvent event) {
        Iterator<Shape> it = listShape.iterator();
        while (it.hasNext()) {
            Shape elem = it.next();
            if (elem.containsPoint(event.getX(), event.getY())) {
                selectShape.setSelectedShape(elem);

                if (elem.getType().equals("Text") || elem.getType().equals("IrregularPolygon")) {
                    flag = false;
                    if (elem.getType().equals("Text") || elem.getType().equals("IrregularPolygon")) {
                        sizeMenu.setDisable(true);

                    } else {
                        sizeMenu.setDisable(false);
                    }
                    if (elem.getType().equals("IrregularPolygon")) {
                        moveMenu.setDisable(true);
                    } else {
                        moveMenu.setDisable(false);
                    }
                } else if (selectShape.getSelectedShape() == null) {
                    selectShape.setSelectedShape(null);
                }
            }
        }
        initContextMenu();

        pastX = event.getX();
        pastY = event.getY();
    }

    private void drawAll() {

        Iterator<Shape> it = listShape.iterator();
        gc.clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
        if (flagGrid == true) {
            String g = gridSize.getText();
            Integer grid = new Integer(g);
            if (grid.intValue() <= 0) {
                return;
            }
            component.setGridSizeInput(grid.intValue());
            gridDecorator.execute();
        }
        while (it.hasNext()) {
            Shape elem = it.next();
            elem.draw();
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
        contextMenu.getItems().addAll(deleteMenu, moveMenu, copyMenu, pasteMenu, cutMenu, colorMenu, sizeMenu, rotateMenu, toFrontMenu, toBackMenu, toMirrorMenu);
        drawingCanvas.setOnContextMenuRequested(e -> contextMenu.show(drawingCanvas, e.getScreenX(), e.getScreenY()));

        contextMenu.showingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == false && flag == true) {
                if (mod == "Cut" || mod == "Delete") {
                    listShape.remove(selectShape.getSelectedShape());
                } else if (mod != "Paste") {
                    listShape.remove(selectShape.getSelectedShape());
                    listShape.add(previousPosition, selectShape.getSelectedShape());
                }
                drawAll();

            }
        });

        deleteMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the deleteMenu item
            public void handle(ActionEvent event) {
                delete();
                mod = "Delete";

            }
        });

        moveMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the moveMenu item
            public void handle(ActionEvent event) {
                if (mod.equals("Line") || mod.equals("Rectangle") || mod.equals("Ellipse") || mod.equals("Text") || mod.equals("IrregularPolygon")) {
                    oldMod = mod;
                }
                mod = "Move";
                flag = true;
            }
        });

        copyMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the copyMenu item
            public void handle(ActionEvent event) {
                //I SET THE MODE TO COPY IF I CLICK ON THE COPY OPTION
                copy();
                pasteMenu.setDisable(false);
                flag = true;
                mod = "Copy";
            }
        });

        pasteMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the pasteMenu item
            public void handle(ActionEvent event) {
                paste(pastX, pastY);
                flag = true;
                listPrevious.add(listShape.get(listShape.size() - 1));
                mod = "Paste";
            }
        });

        cutMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the cutMenu item
            public void handle(ActionEvent event) {
                cut();
                pasteMenu.setDisable(false);
                mod = "Cut";

            }
        });

        colorMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the colorMenu item
            public void handle(ActionEvent event) {
                changeColor();
                flag = true;
            }
        });

        sizeMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the sizeMenu item
            public void handle(ActionEvent event) {
                changeSize();
                flag = true;
                mod = "Size";
            }
        });

        toFrontMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the sizeMenu item
            public void handle(ActionEvent event) {
                //I CALL THE TO FRONT FUNCTION AND I PASS THE POSITION OF THE SELECTED SHAPE IN THE LIST OF FIGURES
                //AND THE SIZE OF THE LIST
                toFront(listPrevious.indexOf(selectShape.getSelectedShape()), listShape.size());
                mod = "ToFront";
            }
        });

        toBackMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the toBackMenu item
            public void handle(ActionEvent event) {
                toBack(listPrevious.indexOf(selectShape.getSelectedShape()));

            }
        });
        toMirrorMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the toMirrorMenu item
            public void handle(ActionEvent event) {
                //I CALL THE TO MIRROR FUNCTION
                toMirror();
                mod = "ToMirror";
            }
        });
        rotateMenu.setOnAction(new EventHandler<ActionEvent>() { //set the action of the rotateMenu item
            public void handle(ActionEvent event) {
                rotate();
                mod = "Rotate";
            }
        });
    }

    public void toFront(double index, double size) {
        //I CREATE THE COMMAND TO FRONT BY PASSING THE SELECTED SHAPE,
        //THE POSITION IN THE LIST AND THE SIZE OF THE LIST, AT THE END I INVOKE THE COMMAND
        command = new ToFrontCommand(selectShape, index, size);
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
    }

    public void toMirror() {
        //I CREATE THE COMMAND TO MIRROR BY PASSING THE SELECTED SHAPE 
        //AND THE NEGATIVE DEGREES TO MIRROR IT, AT THE END I INVOKE THE COMMAND
        double deg;
        deg = selectShape.getSelectedShape().getDegrees();
        command = new ToMirrorCommand(selectShape, -deg);
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
    }

    public void toBack(double index) {
        //I CREATE THE COMMAND TO BACK BY PASSING THE SELECTED SHAPE,
        //THE POSITION IN THE LIST, AT THE END I INVOKE THE COMMAND

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
        //I CREATE THE MOVE COMMAND BY PASSING THE SELECTED SHAPE, THE OLD POSITIONS OF THE SHAPE 
        //AND THE THOSE IT MUST ASSUME AFTER THE MOVE, AT THE END I INVOKE THE COMMAND
        command = new MoveCommand(selectShape, x, y, pastX, pastY);
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
    }

    public void copy() {
        //I CREATE THE COPY COMMAND BY PASSING THE SELECTED SHAPE, AT THE END I INVOKE THE COMMAND
        command = new CopyCommand(selectShape);
        invoker.setCommand(command);
        invoker.startCommand();

    }

    public void paste(double x, double y) {
        command = new PasteCommand(selectShape, x, y);
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
        mod = "";
    }

    public void cut() {
        command = new CutCommand(selectShape, listShape.indexOf(selectShape.getSelectedShape()));
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

    public void changeSize() {
        String x1 = sizeX.getText();
        String y1 = sizeY.getText();
        Double x = new Double(x1);

        if (selectShape.getSelectedShape().getType().equals("Line")) {
            command = new ChangeSizeCommand(selectShape, x.doubleValue());
        } else {
            Double y = new Double(y1);
            command = new ChangeSizeCommand(selectShape, x.doubleValue(), y.doubleValue());

        }
        invoker.setCommand(command);
        invoker.startCommand();
        drawAll();
    }

    public void rotate() {
        String x = rotateField.getText();
        double X;
        if (!x.isEmpty()) {
            X = Double.parseDouble(x);
        } else {
            X = 180;
        }
        command = new RotateCommand(selectShape, X);
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
        flagGrid = true;
    }

    @FXML
    private void disableGrid(ActionEvent event) {
        gc.clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
        drawAll();
        flagGrid = false;
    }

    @FXML
    private void addText(ActionEvent event) {
        mod = "Text";
    }

    @FXML
    private void overlapping(MouseEvent event) {
        //WHEN I SELECT A SHAPE IT BRINGS IT TO THE FOREGROUND
        if (event.isSecondaryButtonDown() && flag == false) {
            if (mod == "Cut" || mod == "Delete") {
                listShape.remove(selectShape.getSelectedShape());

            } else if (mod != "Paste") {

                listShape.remove(selectShape.getSelectedShape());
                listShape.add(listShape.size(), selectShape.getSelectedShape());

            }
            drawAll();

        }
    }

}
