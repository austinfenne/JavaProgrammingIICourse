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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        @FXML
        private Button nextButton;
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
        private Button add;
        @FXML
        private void addEd(ActionEvent e) throws IOException
        {
            //add education
        }
    
        @FXML
        private Button previous;
        @FXML
        public void prevPage(ActionEvent e) throws IOException
        {
           Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLExperienceLevel.fxml"));//change this to next page when complete
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
