package LibrarySystemPackage.Controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Created by lehoaitam on 6/1/16.
 */
public class LoginController {

    @FXML
    private TextField loginUserName;
    @FXML
    private PasswordField loginPWRD;

    public void handelLoginUser(Event event) {
String userName=loginUserName.getText();
        String pwrd = loginPWRD.getText();

        System.out.println(userName);
        System.out.println(pwrd);

    }
}
