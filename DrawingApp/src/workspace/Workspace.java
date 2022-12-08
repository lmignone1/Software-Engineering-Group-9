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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
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
        Parent root = FXMLLoader.load(getClass().getResource("Workspace.fxml"));
        primaryStage.setTitle("Paint It!");
        
        //primaryStage.getIcons().add(new Image("/workspace.image/uni.png"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("hiddenHyperLink.css").toExternalForm());
        primaryStage.setScene(scene);
        
        //stageSizeChageListener(primaryStage);
        primaryStage.show();
        
    }
    /*
    private void stageSizeChageListener(Stage stage) throws IOException,InvocationTargetException{
        
        //FXMLLoader loader = new FXMLLoader(Main.class.getResource("Workspace.fxml"));
        //Parent sceneFXML = loader.load();
        WorkspaceController ctrl = (WorkspaceController)FXMLLoader.load(getClass().getResource("Workspace.fxml"));
        
            stage.widthProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    if(newValue.intValue() < oldValue.intValue()){
                        ctrl.componentBorderPane.addProperty();
                          //System.out.println("Width changed!!");
                       
                    }

                }
            });

            stage.heightProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(newValue.intValue() < oldValue.intValue()){
                         ctrl.componentBorderPane.addProperty();
                         //System.out.println("Width changed!!");
                    }
                }
            });
        

    }
    */
    
}
