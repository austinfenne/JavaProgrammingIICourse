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
import java.sql.ResultSet;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author fenne113
 */
public class FXMLOnlinePrecenseController implements Initializable {
    Database db = new Database();
    ResultSet rs = null;
    public int ID = db.getUser_ID();
    
    @FXML TextField www;
    @FXML TextField twitter;
    @FXML TextField linkedin;
    @FXML
    private Button nextButton;
    @FXML
 
        private void nextPage(ActionEvent e) throws IOException
       {
              int pgNum = 2;
          
              ChangePage pgChange = new ChangePage();
              pgChange.nextPage(e, pgNum);
 
           
                String query = "INSERT INTO onlineprecense (WWW,TWITTER,LINKEDIN,USER_ID) VALUES (" + "'" + www.getText() + 
                "'," + "'" + twitter.getText() + "'," + "'" + linkedin.getText() + "'," + ID + ");";
           
                db.insertQuery(query);
                    
       }
     

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
