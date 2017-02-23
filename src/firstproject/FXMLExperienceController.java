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
import javax.swing.JOptionPane;


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
   
    //NextPage
    @FXML
    public void nextPage(ActionEvent e) throws IOException
    {     
        int pgNum = 4;
             
              ChangePage pgChange = new ChangePage();
              pgChange.nextPage(e, pgNum);
              
              
    }
    
    // Previous page
    @FXML
    public void PrevPage(ActionEvent e) throws IOException
    {     
        int pgNum = 4;
             
           
           
//       ChangePage changePage = new ChangePage;
//           pgChange = prevPage(e,pgNum);
    }
    
    @FXML
    private void AddButton (ActionEvent event) throws IOException   {
        
        // get Date value
        LocalDate startDate = Date_from_picker.getValue();
        LocalDate endDate = Date_to_picker.getValue();
        
       
        
        //description validation
        String description = Description_text.getText();
        String descriptP = "\\d{5}(-\\d{4})?"; 
        
     
        boolean a = false;

        //Postion error 
        if (Position_text.getText().isEmpty()){
            Position_err.setText("Enter a value");  
        }
        else {
            Position_err.setText("");
        }
        
        //Name of Company error
        if ( Name_of_Company_text.getText().isEmpty()){
            CompanyName_err.setText("Enter a value");
        }
        else{
            CompanyName_err.setText(""); 
        }
        
        //Description error
        if ( Description_text.getText().isEmpty()){
            Description_err.setText("Enter a value");
        }
        else{
            Description_err.setText("");
        } 
        
        //Date error
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
        
        //Date error
        if (endDate == null){
            EndDate_err.setText("Click a Date");
        }
        else {
            EndDate_err.setText("");
        }
        
        //description validation
        if (descriptP.matches(descriptP) == false)
        {
           Description_err.setText("please enter proper variable"); 
        }
        
        if (description.matches(".*\\d.*") || description.matches("\\d{500}(-\\d{0})?")){ 
            Description_err.setText("");
            JOptionPane.showMessageDialog(null, "please enter proper variable in 500 letters");
        }
        
        //
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
