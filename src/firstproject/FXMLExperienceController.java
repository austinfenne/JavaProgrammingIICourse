/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. fenne113
 */
package firstproject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.temporal.TemporalField;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author fenne113
 */
public class FXMLExperienceController implements Initializable {
    Database db = new Database();
    ResultSet rs = null;
    public int ID = 0;
    
    @FXML
    private Label Position;
    
    @FXML
    private Label Name_of_company;
    
    @FXML
    private Label Description;
    
    @FXML
    private Label Date_from;
    
    @FXML
    private Label Date_to;
    
    @FXML
    private TextField Position_text; 
    
    @FXML
    private TextField Name_of_Company_text;
    
    @FXML
    private TextArea Description_text;
    
    @FXML
    private Button NextBtn;
    
    @FXML
    private Button AddBtn;
    
    @FXML
    private DatePicker Date_from_picker;
    
    @FXML
    private DatePicker Date_to_picker;
    
    @FXML private Label error_label;
    
    @FXML
    private Label error_label1;
    
    @FXML
    private Label error_label4;
    
    @FXML
    public void nextPage(ActionEvent e) throws IOException
    {     
        
           Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLEducation.fxml"));
           Scene home_page_scene = new Scene(home_page_parent);
           Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
           app_stage.setScene(home_page_scene);
           app_stage.show();               
    }
    
    @FXML
    private void AddButton (ActionEvent event) throws IOException   {
        

        if (Position_text.getText().isEmpty()){
            error_label1.setText("Enter a value");//Postion    
        }
        else {
            error_label1.setText("");
        }
        
        
        if ( Name_of_Company_text.getText().isEmpty()){
            error_label.setText("Enter a value");//Name of Company
        }
        else{
            error_label.setText("");//Name of Company
        }
        
        if ( Description_text.getText().isEmpty()){
            error_label4.setText("Enter a value");//Description
        }
        else{
            error_label4.setText("");//Description
        }
        //get user id
        ID = db.getUser_ID();
 
        
        if (!Position_text.getText().isEmpty() && !Name_of_Company_text.getText().isEmpty() && !Description_text.getText().isEmpty()){
           String query = "INSERT INTO WorkEXP( Company, Position, FromDate, EndDate, Description,USER_ID) VALUES ("+
                   "'" +  Name_of_Company_text.getText() + "'," +
                   "'" +  Position_text.getText() + "'," +
                   "'" +  Date_from_picker.getValue()+ "'," +
                   "'" +  Date_to_picker.getValue() + "'," +
                   "'" +  Description_text.getText() +"',"+
                   ID +
                   ");";
                   insertStatement(query);
        }
    }
    
     @FXML
    private void datefrompickerAction (ActionEvent event) throws IOException {
        DatePicker Date_from_picker = (DatePicker) event.getSource();
        System.out.println(Date_from_picker.getValue());
        
    }
    
     @FXML
    private void datetopickerAction (ActionEvent event) throws IOException {
        DatePicker Date_to_picker = (DatePicker) event.getSource();
        System.out.println(Date_to_picker.getValue());
        
    }
    
    private void insertStatement (String insert_query){
        
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
        }catch (Exception e) {
                    System.out.println( e.getClass().getName() + ": " + e.getMessage() );
                    System.exit(0);
        }
        
    }
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
    }

      
           
    
}
