/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author fenne113
 */
public class FXMLEducationController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML private Button nextButton;
        @FXML private Button add;
        @FXML private Button previous;
        @FXML private TextField txtSchool;
        @FXML private TextField txtStudy;
        @FXML private DatePicker dpStart;
        @FXML private DatePicker dpEnd;
        @FXML private Label schoolErr;
        @FXML private Label studyErr;
        @FXML private Label startDateErr;
        @FXML private Label endDateErr;
        String noError = "";
        int pgNum = 5;
        Database db = new Database();
        ResultSet rs = null;
        public int ID = 0;
        
        @FXML
        private void addEd(ActionEvent e) throws IOException
        {
   
            String school = txtSchool.getText().trim();
            String study = txtStudy.getText().trim();
            LocalDate startDate = dpStart.getValue();
            LocalDate endDate = dpEnd.getValue();
            
            int error = 0; 
            
            //evaluate if school data entry field is empty
            if (school.isEmpty())
            {
                schoolErr.setText("No School Entered.");
                error = 1;
            }
            else 
                schoolErr.setText(noError);
            
            //evaluate if area of study data entry field is empty
            if (study.isEmpty())
            {
                studyErr.setText("No Area of Study Entered.");
                error = 1;
            }
            else
                studyErr.setText(noError);
            
            //evaluate if start date data entry field is empty
            if (startDate == null)
            {
                startDateErr.setText("No Start Date Entered.");
                error = 1;
            }//evaluate if end date is before start date
            else if (startDate.compareTo(endDate)>0){
                startDateErr.setText("End Date is Before Start Date.");
                error = 1;
            }
            else{
                startDateErr.setText(noError);
            }
            
            //evaluate if end date data entry field is empty
            if (endDate == null)
            {
                endDateErr.setText("No End Date Entered");
                error = 1;
            }//evaluate if end date is before start date
            else if (startDate.compareTo(endDate)>0){
                endDateErr.setText("End Date is Before Start Date.");
                error = 1;
            }   
            else {
                endDateErr.setText(noError);
            }
           
            //all fields are populated and valid
           if (error == 0) 
           {
               Education newEducation = new Education(school, study, startDate, endDate);
               //get user_id
                ID = db.getUser_ID();   
                //set insert query string
                String query = "INSERT INTO Education (SCHOOL, STUDY, START_DATE, END_DATE, USER_ID) VALUES ("+
                    "'" + newEducation.getSchool()+ "'," +
                    "'" + newEducation.getStudy()+ "', " + 
                    "'" + newEducation.getStartDate() + "',"+
                    "'" + newEducation.getEndDate()+ "'," +
                    ID + ");";
                
                //call insert query
                db.insertQuery(query);
            
                //clear form
                clear();
            
                //reset error labels
                resetLabels();
        
           }   
        }
        
        @FXML
        private void clear() //clear all fields
        {
            txtSchool.clear();
            txtStudy.clear();
            dpStart.getEditor().clear();
            dpEnd.getEditor().clear();
        }
        
        private void resetLabels() //clear all "error" labels
        {
            schoolErr.setText(noError);
            studyErr.setText(noError);
            startDateErr.setText(noError);
            endDateErr.setText(noError);
        }
    
        @FXML
        public void nextPage(ActionEvent e) throws IOException
       {
//           Parent home_page_parent = FXMLLoader.load(getClass().getResource("DB_Test_Resume.fxml"));//change this to resume page when complete
//           Scene home_page_scene = new Scene(home_page_parent);
//           Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//           app_stage.setScene(home_page_scene);
//           app_stage.show();
          ChangePage pgChange = new ChangePage();
            pgChange.nextPage(e, pgNum);
       }
            
        @FXML
        public void prevPage(ActionEvent e) throws IOException
        {
//           Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLExperience.fxml"));//change to resume page
//           Scene home_page_scene = new Scene(home_page_parent);
//           Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//           app_stage.setScene(home_page_scene);
//           app_stage.show();
           ChangePage pgChange = new ChangePage();
            pgChange.prevPage(e, pgNum);
           
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
