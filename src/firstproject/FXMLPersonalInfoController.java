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
    public int ID = 0;
    
    String prob;
    
    @FXML
    private Button nextButton;
    @FXML
    private Button prevButton;
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
           ID = db.getUser_ID();
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
           
           int pgNum = 1;
           
           int error = 0;
           if ("".equals(firstName) || "".equals(lastName) || "".equals(email_address) || "".equals(hPhone) || "".equals(cPhone) || "".equals(street_address) || "".equals(town) || "".equals(province) || "".equals(zipCode) || "".equals(nation) || bDate.getValue() == null)
           {
               System.err.println("Not all fields entered");
               error = 1;
           }
           
           // ZipCode length test
           // Regex help: http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
           if (zipCode.matches("\\d{5}(-\\d{4})?") == false)
           {
               System.err.println("Zip fail");
               error = 2;
           }
           
           // No numbers allowed test
           if (firstName.matches(".*\\d.*") || lastName.matches(".*\\d.*") || town.matches(".*\\d.*") || province.matches(".*\\d.*") || nation.matches(".*\\d.*"))
           {
               if (firstName.matches(".*\\d.*"))
               {
                   prob = "First name";
               }
               else if (lastName.matches(".*\\d.*"))
               {
                   prob = "Last name";
               }
               else if (town.matches(".*\\d.*"))
               {
                   prob = "City name";
               }
               else if (province.matches(".*\\d.*"))
               {
                   prob = "State/province name";
               }
               else if (nation.matches(".*\\d.*"))
               {
                   prob = "Country name";
               }
               
               
               System.err.println("No numbers!");
               error = 3;
           }
           
           
        switch (error) {
            case 0:
                String query = "INSERT INTO PersonalInfo(FIRSTNAME,LASTNAME,BIRTHDAY,EMAILADDRESS,HPHONE,CPHONE,STREETADDRESS,TOWN,PROVINCE,ZIPCODE,NATION,USER_ID) VALUES (" + "'" + firstName + "'," + "'" + lastName + "'," + "'" + birthday + "'," + "'" + email_address + "'," + "'" + hPhone + "'," + "'" + cPhone + "'," + "'" + street_address + "'," + "'" + town + "'," + "'" + province + "'," + "'" + zipCode + "'," + "'" + nation + "'," + ID + ");";                
                System.out.println("Inserting\n" + query);
                
                db.insertQuery(query);
                
                ChangePage pgChange = new ChangePage();
                pgChange.nextPage(e, pgNum);
                
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Please enter all information.", "Error", JOptionPane.WARNING_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Zip code should be five digits.", "Error", JOptionPane.WARNING_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, prob + " should not contain numbers.", "Error", JOptionPane.WARNING_MESSAGE);
        }
       }
    
    public void prevPage(ActionEvent e) throws IOException
    {
        int pgNum = 1;
        
        ChangePage pgChange = new ChangePage();
        pgChange.prevPage(e, pgNum);
    }
    
    public void autoFillState(String autoState)
    {
        //US States Check
        if ("AK".equalsIgnoreCase(autoState) || "Alaska".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("AL".equalsIgnoreCase(autoState) || "Alabama".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("AR".equalsIgnoreCase(autoState) || "Arkansas".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("AZ".equalsIgnoreCase(autoState) || "Arizona".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("CA".equalsIgnoreCase(autoState) || "California".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("CO".equalsIgnoreCase(autoState) || "Colorado".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("CT".equalsIgnoreCase(autoState) || "Connecticut".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("DE".equalsIgnoreCase(autoState) || "Delaware".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("FL".equalsIgnoreCase(autoState) || "Florida".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("GA".equalsIgnoreCase(autoState) || "Georgia".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("Hawaii".equalsIgnoreCase(autoState) || "Hawaii".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("IA".equalsIgnoreCase(autoState) || "Iowa".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("ID".equalsIgnoreCase(autoState) || "Idaho".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("IL".equalsIgnoreCase(autoState) || "Illinois".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("IN".equalsIgnoreCase(autoState) || "Indiana".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("KS".equalsIgnoreCase(autoState) || "Kansas".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("KY".equalsIgnoreCase(autoState) || "Kentucky".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("LA".equalsIgnoreCase(autoState) || "Louisiana".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("MA".equalsIgnoreCase(autoState) || "Massachusetts".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("MD".equalsIgnoreCase(autoState) || "Maryland".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("ME".equalsIgnoreCase(autoState) || "Maine".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("MI".equalsIgnoreCase(autoState) || "Michigan".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("MN".equalsIgnoreCase(autoState) || "Minnesota".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("MO".equalsIgnoreCase(autoState) || "Missouri".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("MS".equalsIgnoreCase(autoState) || "Mississippi".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("MT".equalsIgnoreCase(autoState) || "Montana".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("NC".equalsIgnoreCase(autoState) || "North Carolina".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("ND".equalsIgnoreCase(autoState) || "North Dakota".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("NE".equalsIgnoreCase(autoState) || "Nebraska".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("NH".equalsIgnoreCase(autoState) || "New Hampshire".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("NJ".equalsIgnoreCase(autoState) || "New Jersey".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("NM".equalsIgnoreCase(autoState) || "New Mexico".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("NV".equalsIgnoreCase(autoState) || "Nevada".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("NY".equalsIgnoreCase(autoState) || "New York".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("OH".equalsIgnoreCase(autoState) || "Ohio".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("OK".equalsIgnoreCase(autoState) || "Oklahoma".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("OR".equalsIgnoreCase(autoState) || "Oregon".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("PA".equalsIgnoreCase(autoState) || "Pennsylvania".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("RI".equalsIgnoreCase(autoState) || "Rhode Island".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("SC".equalsIgnoreCase(autoState) || "South Carolina".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("SD".equalsIgnoreCase(autoState) || "South Dakota".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("TN".equalsIgnoreCase(autoState) || "Tennessee".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("TX".equalsIgnoreCase(autoState) || "Texas".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("UT".equalsIgnoreCase(autoState) || "Utah".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("VA".equalsIgnoreCase(autoState) || "Virginia".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("VT".equalsIgnoreCase(autoState) || "Vermont".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("WA".equalsIgnoreCase(autoState) || "Washington".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("WI".equalsIgnoreCase(autoState) || "Wisconsin".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("WV".equalsIgnoreCase(autoState) || "West Virginia".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("WY".equalsIgnoreCase(autoState) || "Wyoming".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("DC".equalsIgnoreCase(autoState) || "Washington DC".equalsIgnoreCase(autoState) || "District of Columbia".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("AS".equalsIgnoreCase(autoState) || "American Samoa".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("GU".equalsIgnoreCase(autoState) || "Guam".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("MP".equalsIgnoreCase(autoState) || "Northern Mariana Islands".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("PR".equalsIgnoreCase(autoState) || "Puerto Rico".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        else if ("VI".equalsIgnoreCase(autoState) || "U.S. Virgin Islands".equalsIgnoreCase(autoState) || "US Virgin Islands".equalsIgnoreCase(autoState))
        {
            country.setText("United States");
        }
        //Canada Provinces Check
        else if ("AB".equalsIgnoreCase(autoState) || "Alberta".equalsIgnoreCase(autoState))
        {
            country.setText("Canada");
        }
        else if ("BC".equalsIgnoreCase(autoState) || "British Columbia".equalsIgnoreCase(autoState))
        {
            country.setText("Canada");
        }
        else if ("MB".equalsIgnoreCase(autoState) || "Manitoba".equalsIgnoreCase(autoState))
        {
            country.setText("Canada");
        }
        else if ("NB".equalsIgnoreCase(autoState) || "New Brunswick".equalsIgnoreCase(autoState))
        {
            country.setText("Canada");
        }
        else if ("NL".equalsIgnoreCase(autoState) || "Newfoundland".equalsIgnoreCase(autoState) || "Labrador".equalsIgnoreCase(autoState) || "Newfoundland and Labrador".equalsIgnoreCase(autoState))
        {
            country.setText("Canada");
        }
        else if ("NT".equalsIgnoreCase(autoState) || "Northwest Territories".equalsIgnoreCase(autoState))
        {
            country.setText("Canada");
        }
        else if ("NS".equalsIgnoreCase(autoState) || "Nova Scotia".equalsIgnoreCase(autoState))
        {
            country.setText("Canada");
        }
        else if ("NU".equalsIgnoreCase(autoState) || "Nunavut".equalsIgnoreCase(autoState))
        {
            country.setText("Canada");
        }
        else if ("ON".equalsIgnoreCase(autoState) || "Ontario".equalsIgnoreCase(autoState))
        {
            country.setText("Canada");
        }
        else if ("PE".equalsIgnoreCase(autoState) || "Prince Edward Island".equalsIgnoreCase(autoState) || "PEI".equalsIgnoreCase(autoState))
        {
            country.setText("Canada");
        }
        else if ("QC".equalsIgnoreCase(autoState) || "Quebec".equalsIgnoreCase(autoState))
        {
            country.setText("Canada");
        }
        else if ("SK".equalsIgnoreCase(autoState) || "Saskatchewan".equalsIgnoreCase(autoState))
        {
            country.setText("Canada");
        }
        else if ("YT".equalsIgnoreCase(autoState) || "Yukon".equalsIgnoreCase(autoState))
        {
            country.setText("Canada");
        }
        else
        {
            country.setText("");
        }
    }
    
    public void autoFillCity(String autoCity)
    {
        if ("New York".equalsIgnoreCase(autoCity))
        {
            state.setText("NY");
        }
        else if ("Los Angeles".equalsIgnoreCase(autoCity) || "LA".equalsIgnoreCase(autoCity))
        {
            state.setText("CA");
        }
        else if ("Chicago".equalsIgnoreCase(autoCity))
        {
            state.setText("IL");
        }
        else if ("Houston".equalsIgnoreCase(autoCity))
        {
            state.setText("TX");
        }
        else if ("Philadelphia".equalsIgnoreCase(autoCity))
        {
            state.setText("PA");
        }
        else if ("Phoenix".equalsIgnoreCase(autoCity))
        {
            state.setText("AZ");
        }
        else if ("San Antonio".equalsIgnoreCase(autoCity))
        {
            state.setText("TX");
        }
        else if ("San Diego".equalsIgnoreCase(autoCity))
        {
            state.setText("CA");
        }
        else if ("Dallas".equalsIgnoreCase(autoCity))
        {
            state.setText("TX");
        }
        else if ("San Jose".equalsIgnoreCase(autoCity))
        {
            state.setText("CA");
        }
        else if ("Austin".equalsIgnoreCase(autoCity))
        {
            state.setText("TX");
        }
        else if ("Jacksonville".equalsIgnoreCase(autoCity))
        {
            state.setText("FL");
        }
        else if ("San Francisco".equalsIgnoreCase(autoCity))
        {
            state.setText("CA");
        }
        else if ("Indianapolis".equalsIgnoreCase(autoCity))
        {
            state.setText("IN");
        }
        else if ("Columbus".equalsIgnoreCase(autoCity))
        {
            state.setText("OH");
        }
        else if ("Fort Worth".equalsIgnoreCase(autoCity))
        {
            state.setText("TX");
        }
        else if ("Charlotte".equalsIgnoreCase(autoCity))
        {
            state.setText("NC");
        }
        else if ("Seattle".equalsIgnoreCase(autoCity))
        {
            state.setText("WA");
        }
        else if ("Denver".equalsIgnoreCase(autoCity))
        {
            state.setText("CO");
        }
        else if ("El Paso".equalsIgnoreCase(autoCity))
        {
            state.setText("TX");
        }
        else if ("Toronto".equalsIgnoreCase(autoCity))
        {
            state.setText("ON");
        }
        else if ("Montreal".equalsIgnoreCase(autoCity))
        {
            state.setText("QC");
        }
        else if ("Calgary".equalsIgnoreCase(autoCity))
        {
            state.setText("AB");
        }
        else if ("Ottawa".equalsIgnoreCase(autoCity))
        {
            state.setText("ON");
        }
        else if ("Edmonton".equalsIgnoreCase(autoCity))
        {
            state.setText("AB");
        }
        else
        {
            state.setText("");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        state.textProperty().addListener((observable, oldValue, newValue) ->
        {
            String autoState = state.getText();
            autoFillState(autoState);
        }
        );
        
        city.textProperty().addListener((observable, oldValue, newValue) ->
        {
            String autoCity = city.getText();
            autoFillCity(autoCity);
        }
        );
        
    }    
    
}
