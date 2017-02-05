/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject.Templates;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author kimx5154
 */
public class FXMLTemplate2Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private Label YourName;
    @FXML private Label City;
    @FXML private Label State;
    @FXML private Label Summary;
    @FXML private Label WorkExp;
    @FXML private Label Education;
    @FXML private Label AddInfo;
    
    @FXML private TextArea Sum_Text;
    @FXML private TextArea WorkExp_Text;
    @FXML private TextArea Edu_Text;
    @FXML private TextArea AddInfo_Text;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
