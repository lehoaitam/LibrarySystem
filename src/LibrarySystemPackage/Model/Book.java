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
    private List<Author> listAuthors;
    public Book(String title, String zsbn, int maxCheckOutLength){
        this.title = title;
        this.zsbn = zsbn;
        this.maxCheckOutLength = maxCheckOutLength;
    }
    public Book(String title, String zsbn, int maxCheckOutLength, List<BookCopy> bookCopies, List<Author> authors)
    {
        this.title = title;
        this.zsbn = zsbn;
        this.maxCheckOutLength = maxCheckOutLength;
        this.listBookCopy = bookCopies;
        this.listAuthors = authors;
    }

    @Override
    public String toString(){
        return "ISBN: " + zsbn + " Title:'" + title + "' ";
    }
    public String getZsbn(){
        return zsbn;
    }
    public String getTitle()
    {
        return title;
    }
    public List<BookCopy> getListBookCopy()
    {
        return listBookCopy;
    }
    public List<Author> getListAuthors()
    {
        return  listAuthors;
    }
}
