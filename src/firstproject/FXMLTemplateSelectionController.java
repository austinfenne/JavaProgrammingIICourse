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
import javafx.scene.control.Button;
/**
 * FXML Controller class
 *
 * @author fenne113
 */


      
public class FXMLTemplateSelectionController implements Initializable {


    
    
        @FXML
        public void clickedTemplate(ActionEvent e) throws IOException
       {
             resumeGenerator resume = new resumeGenerator();
             resume.createResume();
       }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
