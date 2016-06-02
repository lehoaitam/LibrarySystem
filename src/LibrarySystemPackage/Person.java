package LibrarySystemPackage;

import java.util.List;

/**
 * Created by lehoaitam on 6/1/16.
 */
public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<UserRole> listUserRole;
    public Person(){

    }
    public Person(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;

    }
}
