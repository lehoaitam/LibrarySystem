package LibrarySystemPackage.Controller;

import LibrarySystemPackage.AbstractView;
import LibrarySystemPackage.Model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.stage.*;

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


    /// Constructor of controller
    public AddABookCopyController() {

        // title of dialog
        this.title = "Add a book copy";

        // path to fxml file
        this.viewPath = "../View/AddABookCopyView.fxml";
    }

    /// handling click event on search button
    public void btnSearchClicked(){

        // get book information from database by ISBN
        Book book = this.dataAcessFacade.getBook(txtISBN.getText());

        // if existing
        if(book!=null) {
            lbISBN.setText("ISBN: " + book.getZsbn());
            lbTitle.setText("Title: " + book.getTitle());
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

        // insert to database
    }

    /// handling click event on cancel button
    public void btnCancelClicked(){

        // close current stage
        ((Stage) btnCancel.getScene().getWindow()).close();
    }
}
