/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author fenne113
 */
public class FXMLExperienceController implements Initializable {

    @FXML
    private Button NextBtn;
    @FXML
    public void nextPage(ActionEvent e) throws IOException
    {
           Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLEducation.fxml"));
           Scene home_page_scene = new Scene(home_page_parent);
           Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
           app_stage.setScene(home_page_scene);
           app_stage.show();
    }   
    //@FXML
    //private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        labels.setText("Hello World");
        NextBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                System.out.println("Hello World");
            }
        });
        //Scene scene = new Scene(root, 500, 300);
    }
}
