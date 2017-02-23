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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lee Rondorf
 * SE 2070 Spring 2017
 */
public class FXMLEducationController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML private Button nextButton;
        @FXML private Button add;
        @FXML private Button delete;
        @FXML private Button previous;
        @FXML private TextField txtSchool;
        @FXML private TextField txtStudy;
        @FXML private DatePicker dpStart;
        @FXML private DatePicker dpEnd;
        @FXML private Label schoolErr;
        @FXML private Label studyErr;
        @FXML private Label startDateErr;
        @FXML private Label endDateErr;
        @FXML private Label deleteErr;
        @FXML private TableView tblEducation;
        
        private ObservableList<ObservableList> tableData;
        String noError = "";
        int pgNum = 5;
        Database db = new Database();
        ResultSet rs = null;
        public int ID = 0;
                
        @FXML
        private void addEd(ActionEvent e) throws IOException
        {
            //retrieve data from input fields, set to variables
            String school = txtSchool.getText().trim();
            String study = txtStudy.getText().trim();
            LocalDate startDate = dpStart.getValue();
            LocalDate endDate = dpEnd.getValue();
            
            //set error variable "false"
            Boolean error = false; 
            
            //evaluate if school data entry field is empty
            if (school.isEmpty())
            {
                //display error message, set error true
                schoolErr.setText("No School Entered.");
                error = true;
            }
            else 
            {
                schoolErr.setText(noError);
            }
            //evaluate if area of study data entry field is empty
            if (study.isEmpty())
            {
                //display error message, set error true
                studyErr.setText("No Area of Study Entered.");
                error = true;
            }
            else
            {
                studyErr.setText(noError);
            }
            //evaluate if start date data entry field is empty
            if (startDate == null)
            {
                //display error message, set error true
                startDateErr.setText("No Start Date Entered.");
                error = true;
            }//evaluate if end date is before start date
            else if (startDate.compareTo(endDate)>0)
            {
                //display error message, set error true
                startDateErr.setText("End Date is Before Start Date.");
                error = true;
            }
            else
            {
                startDateErr.setText(noError);
            }
            
            //evaluate if end date data entry field is empty
            if (endDate == null)
            {
                //display error message, set error true
                endDateErr.setText("No End Date Entered");
                error = true;
            }//evaluate if end date is before start date
            else if (startDate.compareTo(endDate)>0)
            {
                //display error message, set error true
                endDateErr.setText("End Date is Before Start Date.");
                error = true;
            }   
            else 
            {
                endDateErr.setText(noError);
            }
           
            //all fields are populated and valid
           if (error == false) 
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
                //add data to table
                refreshTable("Education");
                //close db connection
                try {
                    db.con.close();
                } catch (Exception exc)
                {
                    db.errorOutput(exc);
                }
                //reset error labels
                resetLabels();
           }   
        }
        
        @FXML
        private void deleteEd(ActionEvent e) throws IOException
        {
            //get selected index number
            int selectedIndex = tblEducation.getSelectionModel().getSelectedIndex();
            
            if (selectedIndex >= 0) 
            {
                schoolErr.setText(noError);                
               if (tblEducation.getSelectionModel().getSelectedItem() != null) 
                {
                    //place row data into observable list 
                    ObservableList rowList = (ObservableList) tblEducation.getItems().get(selectedIndex);
                    //T_ID column index
                    int columnIndex = 5;
                   //retrieve T_ID from obsevable list. Place into query and pass string to deleteQuery method for execution
                    String value = (rowList.get(columnIndex).toString());
                    String deleteQuery = "DELETE FROM Education WHERE T_ID = " + value + ";";
                    db.deleteQuery(deleteQuery);
                    refreshTable("Education");
                } 
            }
            else 
            {
                // nothing selected. Display error
                deleteErr.setText("No Institution Selected.");
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
            ChangePage pgChange = new ChangePage();
            pgChange.nextPage(e, pgNum);
       }
            
        @FXML
        public void prevPage(ActionEvent e) throws IOException
        {
            ChangePage pgChange = new ChangePage();
            pgChange.prevPage(e, pgNum);
        }
        
    @FXML
    public void refreshTable(String dbTableName)
    {        
        tableData = FXCollections.observableArrayList();
        
        try{
            tblEducation.getItems().clear();
            tblEducation.getColumns().clear();
            tblEducation.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            
            //retrieve user ID
            ID = db.getUser_ID();   
            //call data from table
            rs = db.selectFromTable(dbTableName, Integer.toString(ID));
            
            ResultSetMetaData rsmd = rs.getMetaData();
            
            //get column count from result set meta data
            int col = rsmd.getColumnCount();

            //add columns dynamically
            for (int i = 0; i < col; i++)
            {
                final int j = i;
                TableColumn tc = new TableColumn(rsmd.getColumnName(i+1));
                tc.setCellValueFactory(new 
                    Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>()
                        {
                            public ObservableValue<String>
                            call (TableColumn.CellDataFeatures<ObservableList, String> param)
                                {
                                    return new 
                                        SimpleStringProperty(param.getValue().get(j).toString());
                                }
                        });
                    //add column to table
                    tblEducation.getColumns().addAll(tc);
                    
            }
            col = rsmd.getColumnCount();//retrieve final column count
            
            
            while (rs.next())
            {
                //place data from result set into observablearraylist
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= col; i++)
                {
                    row.add(rs.getString(i));   
                }
                //add row
                tableData.add(row);
            }
            //set data items into javafx table
            tblEducation.setItems(tableData);
            
            //hide "ID" columns from users - right to left - (left to right generates error and doesn't hide both)
            tblEducation.getVisibleLeafColumn(5).setVisible(false);
            tblEducation.getVisibleLeafColumn(4).setVisible(false);
            
            //close result set and db connection
            rs.close();
            db.con.close();
        } catch (Exception e){
            db.errorOutput(e);
       }        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refreshTable("Education");
    }    
    
}
