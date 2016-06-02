package LibrarySystemPackage.Model;

/**
 * Created by 985261 on 6/2/2016.
 */
public enum EnumRole {
    Admin("Administrator"),Lib("Librarian");

    private String value;
    private EnumRole(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
