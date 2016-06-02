package LibrarySystemPackage.Model;

import java.util.List;

/**
 * Created by lehoaitam on 6/1/16.
 */
public class Person {
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public Address address;
    public List<UserRole> listUserRole;
    public Person(){

    }
    public Person(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;

    }
}
