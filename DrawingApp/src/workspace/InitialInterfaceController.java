/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workspace;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author artem
 */
public class InitialInterfaceController implements Initializable {

    @FXML
    private StackPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new InitialScreen().start();
    }

    class InitialScreen extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(3000);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("Workspace.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(InitialInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Scene scene = new Scene(root);
                        scene.getStylesheets().add(this.getClass().getResource("hiddenHyperLink.css").toExternalForm());
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();

                        ChangeListener<Number> listener = new ChangeListener<Number>() {
                            private Point2D stageSize = null;
                            private Point2D previousStageSize = new Point2D(stage.getWidth(), stage.getHeight());

                            @Override
                            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                                if (stageSize == null) {
                                    Platform.runLater(() -> {

                                        if ((stageSize.getX() < 1200) && (stageSize.getY() < 700)) {
                                            WorkspaceController.componentBorderPane.addProperty();
                                        }
                                        previousStageSize = stageSize;
                                        stageSize = null;
                                    });
                                }
                                stageSize = new Point2D(stage.getWidth(), stage.getHeight());
                            }

                        };

                        stage.widthProperty().addListener(listener);
                        stage.heightProperty().addListener(listener);

                        rootPane.getScene().getWindow().hide();
                    }

                });

            } catch (InterruptedException ex) {
                Logger.getLogger(InitialInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
