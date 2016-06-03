package LibrarySystemPackage.Controller;

import LibrarySystemPackage.AbstractView;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.*;


/**
 * Created by 985259 on 6/2/2016.
 */
public class AddABookCopyController extends AbstractView {

    @FXML
    private TextField txtISBN;

    @FXML
    private Button btnCancel;

    public AddABookCopyController() {
        this.title = "Add a book copy";
        this.viewPath = "../View/AddABookCopyView.fxml";
    }

    public void btnSearchClicked(){
        System.out.print(txtISBN.getText());
    }

    public void btnOkClicked(){

    }
    public void btnCancelClicked(){
        ((Stage) btnCancel.getScene().getWindow()).close();
    }
}
