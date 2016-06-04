package LibrarySystemPackage.Model;

import java.util.List;

/**
 * Created by lehoaitam on 6/1/16.
 */
public class Author extends Person {
    private String credential;
    private String shortBio;
    private String firstName;
    private String lastName;
    List<Book> listBook;
    public Author(String firstName, String lastName, String credential, String shortBio){
        this.credential = credential;
        this.shortBio = shortBio;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
}
