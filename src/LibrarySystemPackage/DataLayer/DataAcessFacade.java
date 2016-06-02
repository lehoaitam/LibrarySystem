package LibrarySystemPackage.DataLayer;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import LibrarySystemPackage.Model.LibraryMember;

/**
 * Created by 985119 on 6/2/2016.
 */
public class DataAcessFacade implements IDataAcess {
    public void saveLibraryMember(LibraryMember member){
        Connection conn = SQLiteJDBCDriverConnection.getInstance().conn;
        try {
            Statement stat = conn.createStatement();
            PreparedStatement prep = conn.prepareStatement(
                    "insert into LibraryMember values (?, ?, ?, ?, ?, ?, ?, ?, ?);");
            prep.setInt(1, member.memberId);
            prep.setString(2, member.firstName);
            prep.setString(3, member.lastName);
            prep.setString(4, member.phoneNumber);
            prep.setString(5, member.address.street);
            prep.setString(6, member.address.city);
            prep.setString(7, member.address.state);
            prep.setInt(8, member.address.zipCode);
            prep.setInt(9, 1);
            conn.setAutoCommit(false);
            prep.executeUpdate();
            conn.setAutoCommit(true);
        }
        catch(SQLException e1)
        {
            System.out.println("Error creating or running statement: " + e1.toString());
            try
            {
                conn.close();
            }
            catch(Exception e2)
            {
            }
        }
    }
    public LibraryMember readLibraryMember(int id){
        Connection conn = SQLiteJDBCDriverConnection.getInstance().conn;
        Statement stmt;
        ResultSet res;
        LibraryMember result = null;
        try
        {
            String sql = "SELECT * FROM LibraryMember WHERE memberId = 1";
            stmt = conn.createStatement();
            res = stmt.executeQuery(sql);
            while (res.next()) {
                int memberId = Integer.parseInt(res.getString("memberId"));
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String phoneNumber = res.getString("phoneNumber");
                String street = res.getString("street");
                String city = res.getString("city");
                String state = res.getString("state");
                int zipcode = Integer.parseInt(res.getString("zipcode"));
                int roleId = Integer.parseInt(res.getString("roleId"));
                result = new LibraryMember(memberId,firstName,lastName,phoneNumber,street,city,state,zipcode,roleId);

                System.out.println(lastName + "\n");
            }
            return result;
        }
        catch(SQLException e1)
        {
            System.out.println("Error creating or running statement: " + e1.toString());
            try
            {
                conn.close();
            }
            catch(Exception e2)
            {
            }
            return null;
        }
    }
}
