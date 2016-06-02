package LibrarySystemPackage.Model;

import java.util.List;

/**
 * Created by 985261 on 6/2/2016.
 */
public class User {
    String userName;
    String password;
    List<UserRole> roleList;

    public User(){

    }
    User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
}
