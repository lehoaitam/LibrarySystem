package LibrarySystemPackage.DataLayer;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import LibrarySystemPackage.Model.LibraryMember;
import LibrarySystemPackage.Model.User;
import LibrarySystemPackage.Model.UserRole;

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
            prep.setString(4, member.phoneNumber);            prep.setString(5, member.address.street);

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
            System.out.println("Error creating or running statement: " + e1.getMessage());
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
            String sql = "SELECT * FROM LibraryMember WHERE memberId = " + String.valueOf(id);
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

    public User loginUser(String usrName, String password){
        Connection conn = SQLiteJDBCDriverConnection.getInstance().conn;
        Statement stmt;
        ResultSet res;
        User user = null;
        try
        {
            String sql = "SELECT * FROM User WHERE userName = '" + usrName + "'";
            stmt = conn.createStatement();
            res = stmt.executeQuery(sql);
            while (res.next()) {
                String uName = res.getString("userName");
                String pwrd = res.getString("password");
                user = new User(uName,pwrd);
                //int roleId = res.getInt("roleId");
                //roleList.add(urole);

                break;
            }

            if(user==null)
                return null;
String p=user.getPassword();
            if(user.getPassword().equalsIgnoreCase(password)){
                List<String> roleIds=new ArrayList<String>();
                String sql3 = "SELECT * FROM User_UserRole WHERE userName = '" + usrName + "'";
                stmt = conn.createStatement();
                res = stmt.executeQuery(sql3);
                while (res.next()) {
                    String roleId = res.getString("roleId");

                    roleIds.add(roleId);
                }

                List<UserRole> roleList = new ArrayList<UserRole>();
                if(!roleIds.isEmpty()) {
                    String joinedRoleIds = String.join("','", roleIds);
                    String sql4 = "SELECT * FROM UserRole WHERE roleId IN ('" + joinedRoleIds +"'"+")";
                    stmt = conn.createStatement();
                    res = stmt.executeQuery(sql4);
                    while (res.next()) {
                        int roleId = res.getInt("roleId");
                        String roleName = res.getString("roleName");
                        //String uName = res.getString("userName");
                        UserRole urole = new UserRole(roleId, roleName);

                        roleList.add(urole);
                    }

                }
                return new User(usrName, password, roleList);
            }
            else{
                return null;
        }

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
