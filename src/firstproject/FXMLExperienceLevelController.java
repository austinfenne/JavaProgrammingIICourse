/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;
import java.lang.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author fenne113
 */
public class FXMLExperienceLevelController implements Initializable {
    Database db = new Database();
    ResultSet rs = null;
    public int ID = db.getUser_ID();
    
    private int pgNum = 3;
    
    @FXML private Button nextButton;
    @FXML private Button studentButton;
    @FXML private Label error;
    @FXML private Button entrylevelButton;
    @FXML private Button experiencedButton;
    @FXML private Button managerButton;
    @FXML private Button executiveButton;
    @FXML private String experience= "";
    
    Thread t = new Thread();

    
    @FXML
    private void nextPage(ActionEvent e) throws IOException
       {

              
            if (!"".equals(experience)){
           
            String query = "INSERT INTO level (EXPERIENCE,USER_ID) VALUES (" + "'" + experience +  "',"+ID+");";
           
            db.insertQuery(query);

            ChangePage pgChange = new ChangePage();
            pgChange.nextPage(e, pgNum);

            }
           
       }

    
    
    @FXML   private void clickedStudent(ActionEvent event) throws IOException {
          experience = "student";
       }
    @FXML  private void clickedEntrylevel(ActionEvent event) throws IOException {
           experience = "Entrylevel";
       }
    @FXML   private void clickedExperienced(ActionEvent event) throws IOException {
           experience = "Experienced";
       }
    @FXML   private void clickedManager(ActionEvent event) throws IOException {
           experience = "Manager";
       }
    @FXML   private void clickedExecutive(ActionEvent event) throws IOException{
           experience = "Executive";
       }
    


////    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}