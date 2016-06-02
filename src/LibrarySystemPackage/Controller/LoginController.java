package LibrarySystemPackage.Controller;

import LibrarySystemPackage.Model.User;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;


/**
 * Created by dtakele on 6/2/16.
 */
public class LoginController {

    @FXML
    private TextField loginUserName;
    @FXML
    private PasswordField loginPWRD;

    public void loginUser(ActionEvent event) {
String userName=loginUserName.getText();
        String pwrd = loginPWRD.getText();

        User user = new User();
        System.out.println(userName);
        System.out.println(pwrd);

    }
    boolean isValidInput(String userName, String password){

        return true;
    }
}
