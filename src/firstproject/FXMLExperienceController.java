/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. fenne113
 */
package firstproject;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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


/**
 * FXML Controller class
 *
 * @author fenne113
 */
public class FXMLExperienceController implements Initializable {
    
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
    private Button PrevBtn;
  
    @FXML
    private DatePicker Date_from_picker;
    
    @FXML
    private DatePicker Date_to_picker;
    
    @FXML 
    private Label error_label;
    
    @FXML
    private Label error_label1;
    
    @FXML
    private Label error_label2;
    
    @FXML
    private Label error_label3;
    
    @FXML
    private Label error_label4;
        Database db = new Database();
    public int ID = 0;
    @FXML
    public void nextPage(ActionEvent e) throws IOException
    {     
        int pgNum = 4;
             
              ChangePage pgChange = new ChangePage();
              pgChange.nextPage(e, pgNum);
              
              
    }
    @FXML
    public void PrevPage(ActionEvent e) throws IOException
    {     
        int pgNum = 4;
             
           
           
//       ChangePage changePage = new ChangePage;
//           pgChange = prevPage(e,pgNum);
    }
    
    @FXML
    private void AddButton (ActionEvent event) throws IOException   {
        
        LocalDate startDate = Date_from_picker.getValue();
        LocalDate endDate = Date_to_picker.getValue();
        
        
        boolean a = false;

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
        
        if (startDate == null){
            error_label2.setText("Clikc a Date");
        }
        else if (startDate.compareTo(endDate)>0)
        {
            error_label2.setText("End Date is before Start Date");
        }
        else{
            error_label2.setText("");
        }
        
        if (endDate == null){
            error_label3.setText("Click a Date");
        }
        else {
            error_label3.setText("");
        }
        
        
        
      
        
        

        if (!Position_text.getText().isEmpty() && !Name_of_Company_text.getText().isEmpty() && !Description_text.getText().isEmpty()){
           String query = "INSERT INTO WorkExp( Company, Position, FromDate, EndDate, Description, USER_ID) VALUES ("+
                   "'" +  Name_of_Company_text.getText() + "'," +
                   "'" +  Position_text.getText() + "'," +
                   "'" +  Date_from_picker.getValue()+ "'," +
                   "'" +  Date_to_picker.getValue() + "'," +
                   "'" +  Description_text.getText() +     
                   "'," + ID + ");";
                   db.insertQuery(query);
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
    
        

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        
    }

      
           
    
}
