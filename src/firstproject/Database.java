/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;

/**
 *
 * @author rondo017
 */
public class Database {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement stmt = null;

    public void insertQuery (String insert_query)
    {
            try {
                
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:first.db");
                con.setAutoCommit(false);
                stmt = con.createStatement();
                stmt.executeUpdate(insert_query);
                System.out.println("executing insert query "+ insert_query);
                stmt.close();
                con.commit();
                con.close();
                
                
            } 
            catch (Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Insert Statement Error: " + e.getMessage());
            }
    }
    
    public ResultSet selectStatement (String select_query)
        {
            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:first.db");
                con.setAutoCommit(false);
                pst = con.prepareStatement(select_query);
                rs = con.createStatement().executeQuery(select_query);
                pst.close();
                //con.close();
                return rs;
            } 
            catch (Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Select Statement Error: " + e.getMessage());
                return rs;
            }
        }
    public Integer getUser_ID()
    {
        int user_id = 0;
        //set select query string
        String selectQuery = "SELECT max(user_id) as 'user_id' FROM personalinfo;";
            
        //submit query and retrieve result set
        rs = selectStatement(selectQuery);
        
        try{
                if (rs.next()){
                    user_id = (rs.getInt("User_ID"));
                    rs.close();
                    con.close();
                }
            }catch (Exception exc){
                exc.printStackTrace();;
                System.out.println(exc.getMessage());
                JOptionPane.showMessageDialog(null,exc.getMessage());
            }
        return user_id;
    }
    @FXML
    public ResultSet selectFromTable (String dbTableName, String ID){
        
        try{   
            // set select query string
            String selectQuery = "SELECT * FROM " + dbTableName + " where User_ID = " + ID;
            
            //execute query and create metadata object
            rs = selectStatement(selectQuery);
            ResultSetMetaData rsmd = rs.getMetaData();
        }catch (Exception e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        finally {
           return rs; 
    }
        
    }
}
