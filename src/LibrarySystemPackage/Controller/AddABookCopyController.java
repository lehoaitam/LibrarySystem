package LibrarySystemPackage.Controller;

import LibrarySystemPackage.AbstractView;
import LibrarySystemPackage.Model.Author;
import LibrarySystemPackage.Model.Book;
import LibrarySystemPackage.Model.BookCopy;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.stage.*;

import java.util.Collections;
import java.util.List;

public class AddABookCopyController extends AbstractView {

    @FXML
    private TextField txtISBN;

    @FXML
    private Button btnCancel;

    @FXML
    private Label lbISBN;

    @FXML
    private Label lbTitle;

    @FXML
    private Label lbAuthors;

    @FXML
    private TextField txtCopyNumber;

    private int isbn;


    /// Constructor of controller
    public AddABookCopyController() {

        // title of dialog
        this.title = "Add a book copy";

        // path to fxml file
        this.viewPath = "../View/AddABookCopyView.fxml";
    }

    private int generateNewCopyNumber(String isbn)
    {
        List<Integer> copyNumber = this.dataAcessFacade.getBookCopiesOfBook(isbn);
        if(copyNumber.isEmpty())
            return  1;

        return Collections.max(copyNumber) + 1;
    }

    /// handling click event on search button
    public void btnSearchClicked(){

        // get book information from database by ISBN
        Book book = this.dataAcessFacade.getBook(txtISBN.getText());

        // if existing
        if(book!=null) {
            lbISBN.setText("ISBN: " + book.getZsbn());
            lbTitle.setText("Title: " + book.getTitle());
            this.isbn = Integer.parseInt(book.getZsbn());
            List<Author> authors = this.dataAcessFacade.getAuthorsOfBook(txtISBN.getText());

            String authorList = "";
            for(Author a:authors)
            {
                authorList += a.getFirstName()+ " " + a.getLastName() + "; ";
            }
            lbAuthors.setText("Authors: "+ authorList);

            txtCopyNumber.setText("" + generateNewCopyNumber(lbISBN.getText().substring(5)));
        }
        else
        {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Book Not Found");
            alert.setContentText("The ISBN '" + txtISBN.getText() + "' does not exist.");

            alert.showAndWait();
        }
    }

    /// handling click event on ok button
    public void btnOkClicked(){

        //
        this.dataAcessFacade.addBookCopy(new BookCopy(generateNewCopyNumber(isbn + ""), isbn));

        // show inform dialog
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Successfully");
        alert.setContentText("Book copy has been created successfully");

        alert.showAndWait();
        int copyNumber = Integer.parseInt(txtCopyNumber.getText());
        txtCopyNumber.setText(copyNumber+1+"");
    }

    /// handling click event on cancel button
    public void btnCancelClicked(){

        // close current stage
        ((Stage) btnCancel.getScene().getWindow()).close();
    }
}
