/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package workspace;

import Command.Select;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author artem
 */
public class Workspace extends Application {

    /**
     * @param args the command line arguments
     */
    
    public static Stage stage;
    static public Select selectShape;   
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
        primaryStage.show();
    }
    
}
