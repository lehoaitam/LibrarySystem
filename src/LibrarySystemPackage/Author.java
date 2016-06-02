package LibrarySystemPackage;

import java.util.List;

/**
 * Created by lehoaitam on 6/1/16.
 */
public class Author extends Person {
    private String credential;
    private String shortBio;
    List<Book> listBook;
    public Author(String credential, String shortBio){
        this.credential = credential;
        this.shortBio = shortBio;
    }
}
