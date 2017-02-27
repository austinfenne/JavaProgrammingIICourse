/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.scene.control.TextField;
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
    private Label skillerr;
    @FXML
    private Label deleteerr;
    @FXML
    private TextField txtSkills;
    @FXML
    private Button delete;
    
    @FXML
    private ObservableList tableData;
    @FXML
    private TableView<UserDetails> tableUser;
    @FXML
    private TableColumn<UserDetails, String> columnSkill;
    @FXML
    private Button btnLoad;
    private ObservableList<UserDetails> data;
    private DbConnection dc;
    @FXML
    private Connection con;
    Database db = new Database();
    String noError = "";
    ResultSet rs = null;
    
    public int ID = 0;
    
    private PreparedStatement pst;
   
    
    
    
    
    
    @FXML
    private void AddButton(ActionEvent e) throws IOException{
         
                        
                ID = db.getUser_ID();
                System.out.println(txtSkills.getText().trim());
                
  //              set insert query string
                String query = "INSERT INTO Skills (skill, USER_ID) VALUES ("+
                    "'" + txtSkills.getText()+ "'," +
                    ID + ");";
                
 //               call insert query
                db.insertQuery(query);
              
                loadDataFromDatabase(e);
                

            }
    



      
            
    
     @FXML 
    private void NextPage(ActionEvent e) throws IOException{
       
              ChangePage pgChange = new ChangePage();
          // pgChange.nextPage(e, pgNum);aus
    }
    
        @FXML
    private void loadDataFromDatabase(ActionEvent event) {
        
        
        try {
            Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
             //Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Skills WHERE USER_ID = " + db.getUser_ID());
          
            
            while (rs.next()) {
               // get string from db,whichever way 
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
    
    
   
   

    public Connection Connect() {
        try {
          // database url string,ensure it is correct
            String url = "jdbc:sqlite:first.db";


            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);
            return conn;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    @FXML
    private void deleteBtn(ActionEvent event) {
        
        String sql = "DELETE FROM Skills WHERE USER_ID = ?";
        //delete seleted row
        UserDetails selectedItem = tableUser.getSelectionModel().getSelectedItem();
        tableUser.getItems().remove(selectedItem);
        
        //String deleteQuery(deleteQuery);
         
    }
    
 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dc = new DbConnection();
       
    }    
  
}
