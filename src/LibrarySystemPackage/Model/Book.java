package LibrarySystemPackage.Model;

import java.util.List;

/**
 * Created by lehoaitam on 6/1/16.
 */
public class Book {
    private String title;
    private String zsbn;
    private int maxCheckOutLength;
    private List<BookCopy> listBookCopy;
    public Book(String title, String zsbn, int maxCheckOutLength){
        this.title = title;
        this.zsbn = zsbn;
        this.maxCheckOutLength = maxCheckOutLength;
    }

    @Override
    public String toString(){
        return "ISBN: " + zsbn + " Title:'" + title + "' ";
    }
    public String getZsbn(){
        return zsbn;
    }
}
