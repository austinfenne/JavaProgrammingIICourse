/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

import java.sql.Statement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        
        @FXML
        private void addEd(ActionEvent e) throws IOException
        {
            String school = txtSchool.getText().trim();
            String study = txtStudy.getText().trim();
            LocalDate startDate = dpStart.getValue();
            LocalDate endDate = dpEnd.getValue();
            
            int error = 0;
            if (school.isEmpty())
            {
                schoolErr.setText("No School Entered.");
                error = 1;
            }
            else 
                schoolErr.setText(noError);

            if (study.isEmpty())
            {
                studyErr.setText("No Area of Study Entered.");
                error = 1;
            }
            else
                studyErr.setText(noError);

            if (startDate == null)
            {
                startDateErr.setText("No Start Date Entered.");
                error = 1;
            }
            else
                startDateErr.setText(noError);
            
            if (endDate == null)
            {
                endDateErr.setText("No End Date Entered");
                error = 1;
            }   
            else
                endDateErr.setText(noError);
            
           if (error == 0) 
           {
               Education newEducation = new Education(school, study, startDate, endDate);
               
               
//               String selectQuery = "SELECT max(user_id) as \"user id\" FROM education;";
//               selectStatement(selectQuery);
               
                //add education to database
                String query = "INSERT INTO Education (SCHOOL, STUDY, START_DATE, END_DATE) VALUES ("+
                    "'" + newEducation.getSchool()+ "'," +
                    "'" + newEducation.getStudy()+ "', " + 
                    "'" + newEducation.getStartDate() + "',"+
                    "'" + newEducation.getEndDate()+"');";
            
                insertStatement(query);
            
                //clear form
                clear();
            
                //reset error labels
                resetLabels();
            
           }
           
            
        }
        
//        private ResultSet selectStatement (String select_query)
//        {
//            Connection c = null;
//            Statement stmt = null;
//            ResultSet something = null;
//            try {
//                Class.forName("org.sqlite.JDBC");
//                c = DriverManager.getConnection("jdbc:sqlite:first.db");
//                c.setAutoCommit(false);
//                stmt = c.createStatement();
//                something = stmt.executeQuery(select_query);
//                stmt.close();
//                c.commit();
//                c.close();
//                System.out.printf("MAX id is %s", something);
//                return something;
//            } 
//            catch (Exception e){
//                System.err.println(e.getClass().getName() + ": " + e.getMessage());
//                System.out.printf("MAX id is %s", something);
//                return something;
//            }
//        }
        
        private void insertStatement (String insert_query)
        {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:first.db");
                c.setAutoCommit(false);
                stmt = c.createStatement();
                stmt.executeUpdate(insert_query);
                stmt.close();
                c.commit();
                c.close();
            } 
            catch (Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        }
        
        @FXML
        private void clear()
        {
            txtSchool.clear();
            txtStudy.clear();
            dpStart.getEditor().clear();
            dpEnd.getEditor().clear();
        }
        
        private void resetLabels()
        {
            schoolErr.setText(noError);
            studyErr.setText(noError);
            startDateErr.setText(noError);
            endDateErr.setText(noError);
        }
    
        @FXML
        public void nextPage(ActionEvent e) throws IOException
       {
           Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLEducation.fxml"));//change this to next page when complete
           Scene home_page_scene = new Scene(home_page_parent);
           Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
           app_stage.setScene(home_page_scene);
           app_stage.show();
          
       }
            
        @FXML
        public void prevPage(ActionEvent e) throws IOException
        {
           Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLExperience.fxml"));
           Scene home_page_scene = new Scene(home_page_parent);
           Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
           app_stage.setScene(home_page_scene);
           app_stage.show();
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
