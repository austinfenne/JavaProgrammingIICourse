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
    private Label CompanyName_err;
    
    @FXML
    private Label Position_err;
    
    @FXML
    private Label StartDate_err;
    
    @FXML
    private Label EndDate_err;
    
    @FXML
    private Label Description_err;
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
        
       
        

        String description = Description_text.getText();
        String descriptP = "\\d{5}(-\\d{4})?";
        
     
        boolean a = false;

        if (Position_text.getText().isEmpty()){
            Position_err.setText("Enter a value");//Postion label   
        }
        else {
            Position_err.setText("");
        }
        
        if ( Name_of_Company_text.getText().isEmpty()){
            CompanyName_err.setText("Enter a value");//Name of Company label
        }
        else{
            CompanyName_err.setText("");//Name of Company label
        }
        
        if ( Description_text.getText().isEmpty()){
            Description_err.setText("Enter a value");//Description label
        }
        else{
            Description_err.setText("");//Description label
        } 
        
        if (startDate == null){
            StartDate_err.setText("Clikc a Date");
        }
        else if (startDate.compareTo(endDate)>0)
        {
            StartDate_err.setText("End Date is before Start Date");
        }
        else{
            StartDate_err.setText("");
        }
        
        if (endDate == null){
            EndDate_err.setText("Click a Date");
        }
        else {
            EndDate_err.setText("");
        }
        
        if (descriptP.matches(descriptP) == false)
        {
           Description_err.setText("please enter proper variable");
        }
        
        if (description.matches(".*\\d.*") || description.matches("\\d{5}(-\\d{0})?")){
            Description_err.setText("please enter proper variable");
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
