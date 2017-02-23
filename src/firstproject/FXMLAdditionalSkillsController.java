/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

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
    private VBox Vbox;
    @FXML
    private TextArea Textarea;
    @FXML
    private ListView Listview;
    @FXML
    private Label label;
    
    @FXML
    private void AddButton(){
        VBox box2 = new VBox();
        
        Textarea = new TextArea();
        Textarea.setMaxHeight(200);
        
        Next.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent AE){
                label.setText(Textarea.getText());
            }
        });
    
        
    }
    
    
    @FXML 
    private void NextButton(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
