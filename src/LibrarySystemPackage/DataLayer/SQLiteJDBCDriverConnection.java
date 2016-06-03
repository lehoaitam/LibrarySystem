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
            String url = "jdbc:sqlite:F:MUM/AMUM/MPP/workspace/workshop/LibrarySystem.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static SQLiteJDBCDriverConnection getInstance(){
        return instance;
    }
}
