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
    private Label label;
    @FXML
    private TextArea txt;
    @FXML
    private Button delete;
    @FXML
    private ListView listview;
    
////////    @FXML
////////    private void AddButton(){
////////        
////////        Add.setOnAction(new EventHandler<ActionEvent>(){
////////            
////////            @Override
////////            public void handle(ActionEvent event) {
////////                label.setText(txt.getText());
////////                
////////               
////////            }
////////            
////////        });
////////        
////////         System.out.println(txt.getText());
////////    }
////////    
////////    
////////    @FXML 
////////    private void NextButton(){
////////        
////////    }
    
    
    
        @FXML
        private void deleteEd(ActionEvent e) throws IOException
        {
            //get selected index number
            int selectedIndex = list.getSelectionModel().getSelectedIndex();
            
            if (selectedIndex >= 0) 
            {
                schoolErr.setText(noError);                
               if (tblEducation.getSelectionModel().getSelectedItem() != null) 
                {
                    //place row data into observable list 
                    ObservableList rowList = (ObservableList) tblEducation.getItems().get(selectedIndex);
                    //T_ID column index
                    int columnIndex = 5;
                   //retrieve T_ID from obsevable list. Place into query and pass string to deleteQuery method for execution
                    String value = (rowList.get(columnIndex).toString());
                    String deleteQuery = "DELETE FROM Education WHERE T_ID = " + value + ";";
                    db.deleteQuery(deleteQuery);
                    refreshTable("Education");
                } 
            }
            else 
            {
                // nothing selected. Display error
                deleteErr.setText("No Institution Selected.");
            }
        }
    
//     public void refreshTable(String dbTableName)
//    {        
//        tableData = FXCollections.observableArrayList();
//        
//        try{
//            tblEducation.getItems().clear();
//            tblEducation.getColumns().clear();
//            tblEducation.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//            
//            //retrieve user ID
//            ID = db.getUser_ID();   
//            //call data from table
//            rs = db.selectFromTable(dbTableName, Integer.toString(ID));
//            
//            ResultSetMetaData rsmd = rs.getMetaData();
//            
//            //get column count from result set meta data
//            int col = rsmd.getColumnCount();
//
//            //add columns dynamically
//            for (int i = 0; i < col; i++)
//            {
//                final int j = i;
//                TableColumn tc = new TableColumn(rsmd.getColumnName(i+1));
//                tc.setCellValueFactory(new 
//                    Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>()
//                        {
//                            public ObservableValue<String>
//                            call (TableColumn.CellDataFeatures<ObservableList, String> param)
//                                {
//                                    return new 
//                                        SimpleStringProperty(param.getValue().get(j).toString());
//                                }
//                        });
//                    //add column to table
//                    tblEducation.getColumns().addAll(tc);
//                    
//            }
//            col = rsmd.getColumnCount();//retrieve final column count
//            
//            
//            while (rs.next())
//            {
//                //place data from result set into observablearraylist
//                ObservableList<String> row = FXCollections.observableArrayList();
//                for (int i = 1; i <= col; i++)
//                {
//                    row.add(rs.getString(i));   
//                }
//                //add row
//                tableData.add(row);
//            }
//            //set data items into javafx table
//            tblEducation.setItems(tableData);
//            
//            //hide "ID" columns from users - right to left - (left to right generates error and doesn't hide both)
//            tblEducation.getVisibleLeafColumn(5).setVisible(false);
//            tblEducation.getVisibleLeafColumn(4).setVisible(false);
//            
//            //close result set and db connection
//            rs.close();
//            db.con.close();
//        } catch (Exception e){
//            db.errorOutput(e);
//       }        
//    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
