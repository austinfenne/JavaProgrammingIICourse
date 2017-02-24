/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableListValue;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author kimx5154
 */
public class FXMLAdditionalSkillsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button Add;
    @FXML
    private Button Next;
    @FXML
    private Label label;
    @FXML
    private TextArea txt;
    @FXML
    private Button delete;
    @FXML
    private ListView listview;
 
    @FXML
    private TableView<UserDetails> tableUser;
    @FXML
    private TableColumn<UserDetails, String> columnSkill;
    @FXML
    private Button btnLoad;
    private ObservableList<UserDetails> data;
    private DbConnection dc;
 
    
    
    @FXML
    private void AddButton(ActionEvent e){
        
      
            loadDataFromDatabase(e);
        
         
    }
    
        @FXML
    private void loadDataFromDatabase(ActionEvent event) {
        
        
        try {
            Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Skills");
          
            
            while (rs.next()) {
                //get string from db,whichever way 
                data.add(new UserDetails(rs.getString(1)));
               
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        
        
        //Set cell value factory to tableview.
        //NB.PropertyValue Factory must be the same with the one set in model class.
        columnSkill.setCellValueFactory(new PropertyValueFactory<>("skill"));
        
       
         
        tableUser.setItems(null);
        tableUser.setItems(data);

    }
    
    
    @FXML 
    private void NextButton(){
        
    }
        
        
        
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dc = new DbConnection();
     
    }    
    
}