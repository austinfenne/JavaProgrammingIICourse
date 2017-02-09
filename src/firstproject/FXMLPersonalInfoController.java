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
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class FXMLPersonalInfoController implements Initializable {
    Database db = new Database();
  //  ResultSet rs = null;
    public int ID = 0;
    
    @FXML
    private Button nextButton;
    @FXML
    private TextField fName;
    @FXML
    private TextField lName;
    @FXML
    private DatePicker bDate;
    @FXML
    private TextField email;
    @FXML
    private TextField homePhone;
    @FXML
    private TextField cellPhone;
    @FXML
    private TextField streetAddress;
    @FXML
    private TextField city;
    @FXML
    private TextField state;
    @FXML
    private TextField zip;
    @FXML
    private TextField country;
    
    public void nextPage(ActionEvent e) throws IOException
       {
           //get max user id 
          ID = db.getUser_ID();
          //increment for new entry
          ID = ID + 1;
          
           String firstName = fName.getText();
           String lastName = lName.getText();
           LocalDate birthday = bDate.getValue();
           String email_address = email.getText();
           String hPhone = homePhone.getText();
           String cPhone = cellPhone.getText();
           String street_address = streetAddress.getText();
           String town = city.getText();
           String province = state.getText();
           String zipCode = zip.getText();
           String nation = country.getText();
           
           int error = 0;
           if ("".equals(firstName) || "".equals(lastName) || "".equals(email_address) || "".equals(hPhone) || "".equals(cPhone) || "".equals(street_address) || "".equals(town) || "".equals(province) || "".equals(zipCode) || "".equals(nation) || bDate.getValue() == null)
           {
               System.out.println("nope");
               error = 1;
           }
           if (error == 0)
           {
           String query = "INSERT INTO PersonalInfo (FIRSTNAME,LASTNAME,BIRTHDAY,EMAILADDRESS,HPHONE,CPHONE,STREETADDRESS,TOWN,PROVINCE,ZIPCODE,NATION,USER_ID) VALUES (" + "'" + firstName + "'," + "'" + lastName + "'," + "'" + birthday + "'," + "'" + email_address + "'," + "'" + hPhone + "'," + "'" + cPhone + "'," + "'" + street_address + "'," + "'" + town + "'," + "'" + province + "'," + "'" + zipCode + "'," + "'" + nation + "'," + ID + ");";
           
           System.out.println("Inserting\n" + query);
           
           insertStatement(query);
           
           Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLOnlinePrecense.fxml"));
           Scene home_page_scene = new Scene(home_page_parent);
           Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
           app_stage.setScene(home_page_scene);
           app_stage.show();
           }
           else if (error == 1)
           {
               JOptionPane.showMessageDialog(null, "Please enter all information.", "Error", JOptionPane.WARNING_MESSAGE);
           }
       }
    
    public void insertStatement(String insert_query)
    {
        Connection c = null;
        Statement stmt = null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:first.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            System.out.println("Our query was: " + insert_query);
            stmt.executeUpdate(insert_query);
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
