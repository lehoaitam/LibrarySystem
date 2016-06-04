package LibrarySystemPackage.Controller;

import LibrarySystemPackage.AbstractView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * Created by 985259 on 6/2/2016.
 */
public class AddABookController extends AbstractView {


    @FXML
    private Button btnCancel;

    public AddABookController() {
        this.title = "Add Book";
        this.viewPath = "../View/AddABookView.fxml";
    }


    public void btnOkClicked(){

    }

    public void btnCancelClicked(){
        ((Stage) btnCancel.getScene().getWindow()).close();
    }

}
