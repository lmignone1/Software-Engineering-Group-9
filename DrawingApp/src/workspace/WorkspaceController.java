/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workspace;

import java.io.File;
import java.io.IOException;
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
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.image.WritableImage;
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
    private Canvas drawingCanvas;
    @FXML
    private ColorPicker selectedContourColour;
    @FXML
    private ColorPicker selectedFullColour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    }

    @FXML
    private void saveProject(ActionEvent event) throws IOException { //metodo per salvare il progetto
        FileChooser save = new FileChooser();
        save.setTitle("Save Image");
        File file = save.showSaveDialog(Workspace.stage);
        if (file != null) {
            try {
                WritableImage image = new WritableImage(1500, 1500); //empty image
                drawingCanvas.snapshot(null, image); //screenshot saved in the image
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);  // save an image after that the image object has been converted from a javafx image 
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }
    
    //DEFAULT
    
    public ColorPicker contourColor = new ColorPicker(Color.BLACK);
    private String shape;
    
    
    
    //metodo per selezionare la linea tra le forme
    @FXML
    private void lineSegment(ActionEvent event) {
        shape = "segment";
    }
    
    //metodo per selezionare il rettangolo tra le forme
    @FXML
    private void rectangle(ActionEvent event) { 
        shape = "rectangle";
        
    }
    
    //metodo per selezionare l'ellisse tra le forme
    @FXML
    private void ellipse(ActionEvent event) { 
        shape = "ellipse";
    }
    
   
    
    
    
    @FXML
    private void contourColour(ActionEvent event) {
        contourColor = new ColorPicker(selectedContourColour.getValue());
        //System.out.println(selectedContourColour);
    }

    @FXML
    private void fullShapeColour(ActionEvent event) { //metodo per colorare l'interno della forma
    }
    
}
