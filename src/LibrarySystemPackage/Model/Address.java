package LibrarySystemPackage.Model;

/**
 * Created by lehoaitam on 6/1/16.
 */
public class Address {
    public String street;
    public String city;
    public String state;
    public int zipCode;
    public Address(String street, String city, String state, int zipCode){
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

}
