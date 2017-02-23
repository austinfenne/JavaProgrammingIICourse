/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author rondo017
 */
public class DB_Test_ResumeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private ObservableList<ObservableList> data;
    String dbPath = "jdbc:sqlite:first.db";
    @FXML private TableView tblEducation;
    @FXML private Button btnTblRefresh;
    @FXML private Button btnLblRefresh;
    @FXML private Label fName;
    @FXML private Label lName;
    
    Database db = new Database();
    ResultSet rs = null;
//    FirstProject fp = new FirstProject();
//    String id = Integer.toString(fp.ID);
    
    
    @FXML void clickTableBtn(){
        refreshTable("education");
//        System.out.printf(id + "%n");
    }
    
    @FXML void clickFieldBtn(){
        //addToTextFields("personalinfo", id);
//        System.out.printf(id + "%n");
    }
    
    @FXML
    public void refreshTable(String dbTableName)
    {        
        data = FXCollections.observableArrayList();
        
        try{
            // set select query string
            String selectQuery = "SELECT * FROM " + dbTableName;
            
            //submit query and retrieve result set
            rs = db.selectStatement(selectQuery);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            //get column count from db table
            int col = rsmd.getColumnCount();

            //add columns dynamically
            for (int i = 0; i < col; i++)
            {
                final int j = i;
                TableColumn tc = new TableColumn(rsmd.getColumnName(i+1));
                tc.setCellValueFactory(new 
                    Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>()
                        {
                            public ObservableValue<String>
                            call (CellDataFeatures<ObservableList, String> param)
                                {
                                    return new 
                                        SimpleStringProperty(param.getValue().get(j).toString());
                                }
                        });
                    tblEducation.getColumns().addAll(tc);//add column to table
            }
            col = rsmd.getColumnCount();//retrieve column count
            
            //place data added to observable list into arraylist
            while (rs.next())
            {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= col; i++)
                {
                    row.add(rs.getString(i));   
                }
                data.add(row);
            }
            //set items into javafx table
            tblEducation.setItems(data);
            rs.close();
        } catch (Exception e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
       }        
    }
    
    @FXML
    public void addToTextFields(String dbTableName, String ID){
        
        try{   
            // set select query string
            String selectQuery = "SELECT * FROM " + dbTableName + " where User_ID = " + ID;
            
            //execute query and create metadata object
            rs = db.selectStatement(selectQuery);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            try{
                if (rs.next()){
                    fName.setText(rs.getString("firstname"));
                    lName.setText(rs.getString("lastname"));
                }
            }catch (Exception e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
