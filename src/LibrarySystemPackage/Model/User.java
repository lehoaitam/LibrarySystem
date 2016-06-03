package LibrarySystemPackage.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 985261 on 6/2/2016.
 */
public class User extends Person {
    String userName;
    String password;
    List<UserRole> roleList;

    public User(){
        this.roleList = new ArrayList<>();
    }

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    public User(String userName, String password, List<UserRole> userRoles){
        this.userName = userName;
        this.password = password;
        this.roleList = userRoles;
    }
    public User(List<UserRole> roles){
        this.roleList = roles;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public List<UserRole> getRoleList(){return roleList;}
}
