package LibrarySystemPackage.Controller;
import java.net.URL;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import LibrarySystemPackage.Model.BookCopy;
import LibrarySystemPackage.Model.LibraryMember;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

import LibrarySystemPackage.DataLayer.SQLiteJDBCDriverConnection;

import LibrarySystemPackage.Model.Book;

/**
 * Created by Issac on 6/2/16.
 */
public class CheckoutController implements Initializable {
    @FXML
    private Button addBook;
    @FXML
    private TextField searchMember,searchBook;//addBook;
    @FXML
    private ListView membersList,booksList,checkoutBookList;
    @FXML
    private Label memberName,bookSelected;
    @FXML
    private ComboBox bookCopiesList;

    @FXML
    private void handleMemberSearcAction() {
        try {
            ArrayList<LibraryMember> lbM = searchLibraryMember(searchMember.getText());
            if(lbM!=null)
                membersList.setItems(FXCollections.observableArrayList(lbM));
            else
                membersList.getItems().clear();
        }
        catch(Exception E) {
            E.printStackTrace();
        }
    }
    @FXML
    private void handleBookSearchAction() {
        try {
            ArrayList<BookAvailable> lbM = searchLibraryBook(searchBook.getText());
            if(lbM!=null)
                booksList.setItems(FXCollections.observableArrayList(lbM));
            else
                booksList.getItems().clear();
        }
        catch(Exception E) {
            E.printStackTrace();
        }
    }
    @FXML
    private void handleAddBookAction() {
        try{
            Object selectedBook=booksList.getSelectionModel().getSelectedItem();
            boolean BookIsSelected = false;
            for(Object item:checkoutBookList.getItems()){
                if(item.equals(selectedBook)){
                    BookIsSelected = true;
                    break;
                }
            }
            if(!BookIsSelected)
                checkoutBookList.getItems().add(selectedBook);
        }
        catch(Exception E) {
            E.printStackTrace();
        }
    }
    @FXML
    private void handleRemoveBookAction() {
        Object selectedBook=booksList.getSelectionModel().getSelectedItem();
        checkoutBookList.getItems().remove(selectedBook);
    }
    @FXML
    private void handleCheckOutAction() {
        if(!searchMember.getSelection().equals(null) && !checkoutBookList.getItems().isEmpty()){

        }
    }
    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert membersList != null : "fx:id=\"memberTTV\" was not injected: check your FXML file 'Checkout.fxml'.";

        SQLiteJDBCDriverConnection.getInstance();
        membersList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<LibraryMember>() {
            @Override
            public void changed(ObservableValue<? extends LibraryMember> observable, LibraryMember oldValue, LibraryMember newValue) {
                if(newValue!=null)
                    addBook.setDisable(true);
                else
                    addBook.setDisable(false);
            }
        });

        bookCopiesList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BookCopy>() {
            @Override
            public void changed(ObservableValue<? extends BookCopy> observable, BookCopy oldValue, BookCopy newValue) {
                if(newValue!=null)
                    System.out.println(newValue.toString());
                else
                    System.out.println("null");
            }
        });

        booksList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BookAvailable>() {
            @Override
            public void changed(ObservableValue<? extends BookAvailable> observable, BookAvailable oldValue, BookAvailable newValue) {
                if(newValue!=null){
                    if(newValue.available!=0){
                        bookSelected.setText(newValue.book.toString());
                        Connection conn = SQLiteJDBCDriverConnection.getInstance().conn;
                        try {
                            Statement stmt = conn.createStatement();
                            ResultSet availableCopies = stmt.executeQuery("select BookCopy.zsbn,BookCopy.ID from BookCopy  where BookCopy.zsbn=" + newValue.book.getZsbn()+" except select BookCopy.zsbn,BookCopy.ID from BookCopy  join CheckoutEntry on BookCopy.ID = CheckoutEntry.checkoutId where BookCopy.zsbn=" + newValue.book.getZsbn());
                            ArrayList<BookCopy> bookCopies = null;
                            if(availableCopies.next()){
                                if(bookCopies==null)
                                    bookCopies = new ArrayList<>();
                                bookCopies.add(new BookCopy(Integer.parseInt(availableCopies.getString("BookCopy.ID")),Integer.parseInt(availableCopies.getString("BookCopy.zsbn"))));
                            }
                            if(bookCopies!=null)
                                bookCopiesList.setItems(FXCollections.observableArrayList(bookCopies));
                            else
                                bookCopiesList.getItems().clear();
                        }
                        catch(SQLException e1) {
                            System.out.println("Error creating or running statement: " + e1.toString());
                            try {
                                conn.close();
                            } catch (Exception e2) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
    }

    public void checkOut(LibraryMember lm, ArrayList<Book> books){

    }

    public int getNoBooKCopies(Book book){
        //"select count(*) as count from BookCopy group by BookID having BookID=1"
        return 1;
    }

    public ArrayList<LibraryMember> searchLibraryMember(String searchTerm){
        Connection conn = SQLiteJDBCDriverConnection.getInstance().conn;
        Statement stmt;
        ResultSet res;
        ArrayList<LibraryMember> result = null;
        try
        {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM LibraryMember WHERE memberId like '%" + searchTerm + "%' OR firstName like '%" + searchTerm + "%' OR lastName like '%" + searchTerm + "%'";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                int memberId = Integer.parseInt(res.getString("memberId"));
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String phoneNumber = res.getString("phoneNumber");
                String street = res.getString("street");
                String city = res.getString("city");
                String state = res.getString("state");
                int zipcode = Integer.parseInt(res.getString("zipcode"));
                int roleId = Integer.parseInt(res.getString("roleId"));
                if(result==null)
                    result = new ArrayList<LibraryMember>();
                LibraryMember newMem = new LibraryMember(memberId,firstName,lastName,phoneNumber,street,city,state,zipcode,roleId);
                result.add(newMem );
            }
            return result;
        }
        catch(SQLException e1){
            System.out.println("Error creating or running statement: " + e1.toString());
            try{
                conn.close();
            }
            catch(Exception e2){
                e1.printStackTrace();
            }
            return null;
        }
    }

    public ArrayList<BookAvailable> searchLibraryBook(String searchTerm){
        Connection conn = SQLiteJDBCDriverConnection.getInstance().conn;
        Statement stmt1,stmt2;
        ResultSet res;
        ArrayList<BookAvailable> result = null;
        try
        {
            stmt1 = conn.createStatement();
            stmt2 = conn.createStatement();
            String sql = "SELECT * FROM Book WHERE zsbn like '%" + searchTerm + "%' OR title like '%" + searchTerm + "%' OR authorId like '%" + searchTerm + "%'";
            res = stmt1.executeQuery(sql);
            while (res.next()) {
                String zsbn = res.getString("zsbn");
                String title = res.getString("title");
                int maxCheckOutLength = Integer.parseInt(res.getString("maxCheckOutLength"));
                Book newMem = new Book(title,zsbn,maxCheckOutLength);
                int copies=0;
                ResultSet resCopies = conn.createStatement().executeQuery("select count(*) as countB from BookCopy group by zsbn having zsbn=" + zsbn);
                ResultSet borrowedCopies = conn.createStatement().executeQuery("select count(*) as countB from CheckoutEntry group by zsbn having zsbn=" + zsbn + " and returned=0");
                if(resCopies.next())
                    copies = Integer.parseInt(resCopies.getString("countB"));
                if(borrowedCopies.next())
                    copies = copies - Integer.parseInt(borrowedCopies.getString("countB"));
                if(result==null)
                    result = new ArrayList<BookAvailable>();
                result.add(new BookAvailable(newMem,copies,null));
            }
            return result;
        }
        catch(SQLException e1){
            System.out.println("Error creating or running statement: " + e1.toString());
            try{
                conn.close();
            }
            catch(Exception e2){
                e1.printStackTrace();
            }
            return null;
        }
    }

    class BookAvailable{
        Book book;
        int available;
        BookCopy selectedCopy;
        public BookAvailable(Book book, int available,BookCopy selectedCopy){
            this.book = book;
            this.available = available;
            this.selectedCopy = selectedCopy;
        }
        @Override
        public String toString() {
            return book.toString() + " Available: " + available;
        }
    }
}



