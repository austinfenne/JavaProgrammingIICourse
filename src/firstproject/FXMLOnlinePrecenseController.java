/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fenne113
 */
public class FXMLOnlinePrecenseController implements Initializable {

    @FXML TextField www;
    @FXML TextField twitter;
    @FXML TextField linkedin;
    @FXML
    private Button nextButton;
    @FXML
        private void nextPage(ActionEvent e) throws IOException
       {
            
           
           Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLExperienceLevel.fxml"));
           Scene home_page_scene = new Scene(home_page_parent);
           Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
           app_stage.setScene(home_page_scene);
           app_stage.show();
          
           
           
                String query = "INSERT INTO onlineprecense (WWW,TWITTER,LINKEDIN) VALUES (" + "'" + www.getText() + 
                "'," + "'" + twitter.getText() + "'," + "'" + linkedin.getText() + "');";
           
                insertStatement(query);
                    
       }
     

        private void insertStatement(String insert_query){
        
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:first.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");
      stmt = c.createStatement(); 
      System.out.println("Our query was: " + insert_query);
      stmt.executeUpdate(insert_query);
      stmt.close();
      c.commit();
      c.close();
    }catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);  
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
