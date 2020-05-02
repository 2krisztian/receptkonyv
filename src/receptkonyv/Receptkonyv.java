/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receptkonyv;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Krissz
 */
public class Receptkonyv extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Receptkönyv");
        stage.setResizable(false);
        stage.getIcons().add(new Image("ikon.png"));
        stage.setScene(scene);
        stage.show();
        
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
