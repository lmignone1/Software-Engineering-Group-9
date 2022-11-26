/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workspace;

import Shapes.ConcreteCreatorLine;
import Shapes.ConcreteCreatorRectangle;
import Shapes.ConcreteShapeLines;
import Shapes.ConcreteShapeRectangles;

import Shapes.ConcreteCreatorEllipse;
import Shapes.ConcreteShapeEllipses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    private String mod;
    private GraphicsContext gc;
    private ConcreteCreatorLine Line;
    private ConcreteShapeLines line;
    private ConcreteCreatorRectangle Rect;
    private ConcreteShapeRectangles rect;
    @FXML
    private ColorPicker selectedContourColour;
    @FXML
    private ColorPicker selectedFullColour;
    
    private ConcreteShapeEllipses ellipse;
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    private void ResizeCanvas(MouseEvent event){
      
        drawingCanvas.setWidth(pane.getWidth());
        drawingCanvas.setHeight(pane.getHeight());
        drawingCanvas.setLayoutX(pane.getScaleX());
        drawingCanvas.setLayoutY(pane.getScaleY());
    }
    @FXML
    private void MakeDraw(MouseEvent event){
        gc = drawingCanvas.getGraphicsContext2D();
        if (mod == "Line"){
            Line = new ConcreteCreatorLine();
            line = Line.createShape();
            line.setGraphicsContext(gc);
            line.setStart(event.getX(),event.getY());
            line.setLineColor(selectedContourColour);
            line.drawShape();
        }
        else if(mod == "Rectangle"){
            Rect = new ConcreteCreatorRectangle();
            rect = Rect.createShape();
            rect.setGraphicsContext(gc);
            rect.setLineColor(selectedContourColour);
            rect.setFillColor(selectedFullColour);
            rect.setStart(event.getX(), event.getY());
            rect.setHeight();
            rect.setWidth();
            rect.drawShape();
        }
        else if (mod == "Ellipse") {
            ConcreteCreatorEllipse ccel = new ConcreteCreatorEllipse();
            ellipse = ccel.createShape();
            ellipse.setGraphicsContext(gc);
            ellipse.setRadius();    // must be before setCenter
            ellipse.setCenter(event.getX(), event.getY());
            ellipse.setLineColor(selectedContourColour);
            ellipse.setFillColor(selectedFullColour);
            ellipse.drawShape();
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





    
}
