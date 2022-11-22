/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workspace;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.MenuItem;

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
    private MenuItem contourColourMenu;
    @FXML
    private MenuItem fullShapeColourMenu;
    @FXML
    private Canvas drawingCanvas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void newProject(ActionEvent event) { //metodo per creare un nuovo progetto
    }

    @FXML
    private void loadProject(ActionEvent event) { //metodo per aprire un progetto esistente
    }

    @FXML
    private void saveProject(ActionEvent event) { //metodo per salvare il progetto
    }

    @FXML
    private void lineSegment(ActionEvent event) { //metodo per selezionare la linea tra le forme
    }

    @FXML
    private void rectangle(ActionEvent event) { //metodo per selezionare il rettangolo tra le forme
    }

    @FXML
    private void ellipse(ActionEvent event) { //metodo per selezionare l'ellisse tra le forme
    }

    @FXML
    private void contourColour(ActionEvent event) { //metodo per colorare il contorno della forma
    }

    @FXML
    private void fullShapeColour(ActionEvent event) { //metodo per colorare l'interno della forma
    }
    
}
