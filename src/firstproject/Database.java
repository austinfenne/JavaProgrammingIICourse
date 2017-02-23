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
import java.sql.Statement;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;

/**
 *
 * @author rondo017
 * SE 2070
 */
public class Database {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement stmt = null;
    
    public void dbConnect()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:first.db");
            con.setAutoCommit(false);
        }
        catch (Exception e)
        {
            errorOutput(e);
        }
    }
    
    public void dbClose()
    {
        try
        {
            stmt.close();
            con.commit();
            con.close();
        }
        catch (Exception e)
        {
            errorOutput(e);
        }
    }
    public void errorOutput(Exception e)
    {
        e.printStackTrace();
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage()); 
    }
    public void stmtQuery (String query)
    {
        try { 
                dbConnect();
                stmt = con.createStatement();
                stmt.executeUpdate(query);
                dbClose();
            } 
            catch (Exception e){
                errorOutput(e);
            }
    }
    public void insertQuery (String insert_query)
    {
        stmtQuery(insert_query);
    }
    public void deleteQuery (String delete_query)
    {
        stmtQuery(delete_query);
    }
    public ResultSet selectStatement (String select_query)
        {
            try {
                dbConnect();
                rs = con.createStatement().executeQuery(select_query);
                return rs;
            } 
            catch (Exception e){
                errorOutput(e);
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
            }catch (Exception e){
                errorOutput(e);
            }
        return user_id;
    }
    @FXML
    public ResultSet selectFromTable (String dbTableName, String ID){
        
        try{   
            // set select query string
            String selectQuery = "SELECT * FROM " + dbTableName + " where User_ID = " + ID;
            
            //execute query
            rs = selectStatement(selectQuery);
            
        }catch (Exception e){
            errorOutput(e);
        }
        finally {
           return rs; 
    }
        
    }
}
