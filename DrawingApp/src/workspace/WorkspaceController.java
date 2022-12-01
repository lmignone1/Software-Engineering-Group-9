/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workspace;

import Factory.ConcreteCreatorLine;
import Factory.ConcreteCreatorRectangle;
import Shapes.ConcreteShapeLines;
import Shapes.ConcreteShapeRectangles;
import Factory.ConcreteCreatorEllipse;
import Shapes.ConcreteShapeEllipses;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
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
    private List<Shape> shape = null;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shape = new ArrayList<>();
        gc = drawingCanvas.getGraphicsContext2D();
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
        
        Creator c = new Creator();
        
        if (mod.equals("Line")){
            
            if (event.isSecondaryButtonDown()) {
                select(event);
            }
        else {
             Shape line = c.createShape(mod);
            line.setGraphicsContext(gc);
            
            line.setXY(event.getX(),event.getY());
            line.setLineColor(selectedContourColour);
            shape.add(line);
            line.draw();
        }
            
           
        }
        
        else if(mod.equals("Rectangle")){
            if (event.isSecondaryButtonDown()) {
                select(event);
            } else {
                Shape rect = c.createShape(mod);
           
            rect.setGraphicsContext(gc);
            rect.setXY(event.getX(), event.getY());
            
            rect.setLineColor(selectedContourColour);
            rect.setFillColor(selectedFullColour);
            shape.add(rect);
            rect.draw();
            }
            
            
        }
        else if(mod.equals("Ellipse")) {
            if (event.isSecondaryButtonDown()) {
                select(event);
            }
            else {
                Shape ellipse = c.createShape(mod);
           
                ellipse.setGraphicsContext(gc);
                ellipse.setXY(event.getX(), event.getY());
                
                ellipse.setLineColor(selectedContourColour);
                ellipse.setFillColor(selectedFullColour);
                shape.add(ellipse);
                ellipse.draw();
            }
            
            
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
        Point2D mousePoint = new Point2D(event.getX(), event.getY());
        
        for(Shape elem : shape) {
            if(elem.containsPoint(event.getX(), event.getY())) {
                elem.setLineColor(new ColorPicker(Color.RED));
                elem.draw();
            }
        }
        
        /*
        Point2D min = new Point2D(999999, 9999999);
        ConcreteShapeEllipses s = null;
        for(Shape elem : shape) {
            if (mousePoint.distance(elem.getPoint()) < mousePoint.distance(min)) {
                min = elem.getPoint();
                s = (ConcreteShapeEllipses) elem;
            }
        }
        
        if(min.distance(mousePoint) < Math.abs(s.getRadiusX()) && min.distance(mousePoint) < Math.abs(s.getRadiusY())) {
            s.setLineColor(new ColorPicker(Color.RED));
            s.draw();
        }
        */
    }
    
    
}
