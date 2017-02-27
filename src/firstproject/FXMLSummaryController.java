/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author kimx5154
 */
public class FXMLSummaryController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button Add;
    @FXML
    private TextArea txt;
    @FXML
    private Button Next;
    @FXML
    Database db = new Database();
    public int ID = db.getUser_ID();
          
      int pgNum = 7;
    
    @FXML
    private void AddBtn(ActionEvent e){
               
                System.out.println(txt.getText().trim());
                
  //            set insert query string
                String query = "INSERT INTO Summary (Sum, USER_ID) VALUES ("+
                    "'" + txt.getText()+ "'," +
                    ID + ");";
                
 //             call insert query
                db.insertQuery(query);
    }
    
    @FXML 
    private void NextPage(ActionEvent e) throws IOException{
       
              ChangePage pgChange = new ChangePage();
              pgChange.nextPage(e, pgNum);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}