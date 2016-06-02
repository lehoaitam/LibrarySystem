package LibrarySystemPackage.Model;

/**
 * Created by lehoaitam on 6/1/16.
 */
public class LibraryMember extends Person {
    public int memberId;
    public LibraryMember(int id, String firstName, String lastName, String phoneNumber, String street, String city, String state, int zipcode, int roleId){
        this.memberId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = new Address(street,city,state,zipcode);
    }
    private CheckOutRecord checkOutRecord;
}
