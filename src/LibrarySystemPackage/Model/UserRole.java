package LibrarySystemPackage.Model;

/**
 * Created by lehoaitam on 6/1/16.
 */
public class UserRole {
    private int roleId;
    private String roleName;
    private String userName;
    public UserRole(int roleId, String roleName, String userName){
        this.roleId = roleId;
        this.roleName = roleName;
        this.userName = userName;
    }
    public String getRoleName(){return roleName;}
    public String getUserName(){return userName;}
    public int getRoleId(){return roleId;}
}
