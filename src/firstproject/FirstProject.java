/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//test tset test test test
//more test more test more test
/**
 *
 * @author fenne113
 */
public class FirstProject extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
     
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));        
        Scene scene = new Scene(root);        
        String css = FirstProject.class.getResource("format.css").toExternalForm();
        scene.getStylesheets().add(css);      
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
