package LibrarySystemPackage.Controller;

import LibrarySystemPackage.AbstractView;
import LibrarySystemPackage.Model.Author;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;


public class AddABookController  extends AbstractView implements Initializable
{



    @FXML
    private Button btnCancel;

    @FXML
    private ComboBox cmbAuthors;

    public AddABookController() {
        this.title = "Add Book";
        this.viewPath = "../View/AddABookView.fxml";
    }

   /* @Override
    public void initialize() {

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "1","2"
                );
        //cmbAuthors = new ComboBox<Author>(options);
        cmbAuthors.getItems().addAll("abc","dafd","fdafa");
    }*/


    public void btnOkClicked(){

    }

    public void btnCancelClicked(){
        ((Stage) btnCancel.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Author> options =
                FXCollections.observableArrayList(
                        new Author("a","b","d","f")
                );
        cmbAuthors.setItems(options);// = new ComboBox<String>(options);
    }
}
