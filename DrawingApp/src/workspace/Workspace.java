/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package workspace;

import Command.Select;
import com.sun.javaws.Main;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Workspace extends Application {

    /**
     * @param args the command line arguments
     */
    
    public static Stage stage;
    //static public Select selectShape;   
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("InitialInterface.fxml"));
        primaryStage.setTitle("Paint It!");
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("hiddenHyperLink.css").toExternalForm());
        primaryStage.setScene(scene);
        

        primaryStage.show();

        
        ChangeListener<Number> listener = new ChangeListener<Number>() {
            private Point2D stageSize = null ;
            private Point2D previousStageSize = new Point2D(primaryStage.getWidth(), primaryStage.getHeight());
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                if (stageSize == null) {
                    Platform.runLater(() -> {

                        if((stageSize.getX() < 1200) && (stageSize.getY() < 700) ){
                            WorkspaceController.componentBorderPane.addProperty();
                        }
                        previousStageSize = stageSize;
                        stageSize = null;
                    });
                }
                stageSize = new Point2D(primaryStage.getWidth(), primaryStage.getHeight());                
            }


        };

        primaryStage.widthProperty().addListener(listener);
        primaryStage.heightProperty().addListener(listener);

    }
 
}
