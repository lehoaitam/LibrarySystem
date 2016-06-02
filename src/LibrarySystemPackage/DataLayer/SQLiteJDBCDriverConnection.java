package LibrarySystemPackage.DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Created by 985119 on 6/2/2016.
 */
public class SQLiteJDBCDriverConnection {
    public Connection conn = null;
    private static SQLiteJDBCDriverConnection instance = new SQLiteJDBCDriverConnection();
    private SQLiteJDBCDriverConnection(){

        try {
            // db parameters
            String url = "jdbc:sqlite:C:/Users/985119/LibrarySystem";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static SQLiteJDBCDriverConnection getInstance(){
        return instance;
    }
}
