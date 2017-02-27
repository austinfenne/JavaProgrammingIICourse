
package firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DbConnection {

    public Connection Connect() {
        try {
            //Your database url string,ensure it is correct
            String url = "jdbc:sqlite:first.db";


            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);
            return conn;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}