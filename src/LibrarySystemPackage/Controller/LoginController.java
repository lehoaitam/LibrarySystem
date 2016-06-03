package LibrarySystemPackage.Controller;

import LibrarySystemPackage.DataLayer.DataAcessFacade;
import LibrarySystemPackage.Model.User;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Created by dtakele on 6/2/16.
 */
public class LoginController {

    @FXML
    private TextField loginUserName;
    @FXML
    private PasswordField loginPWRD;
    @FXML
    private Label lblErrorMsg;

    public void handleLoginUser(Event event) {
        String userName=loginUserName.getText();
        String pwrd = loginPWRD.getText();

        //call loginUser(username,pwrd) in User
        try {

            DataAcessFacade dataAcess = new DataAcessFacade();
            User user = dataAcess.loginUser(userName,pwrd);

            if(user==null) {
               lblErrorMsg.setText("Incorrect User name/password. Try again.");
            }
            else {
                Parent parent=null;

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                if(user.getRoleList().size()>1)//more than 1 role ... both admin and lib
                {
                    parent = FXMLLoader.load(getClass().getResource("../View/BothRoleHomePage.fxml"));

                    stage.setTitle("Library System - admin/lib roles");
                }
                else if(user.getRoleList().size()==1)//both admin or lib
                {
                    if(user.getRoleList().get(0).getRoleName()=="Administrator") {
                        parent = FXMLLoader.load(getClass().getResource("../View/AdminHomePage.fxml"));
                        stage.setTitle("Library System - admin");
                    }
                    else//(user.getRoleList().get(0).getRoleName()=="Administrator")
                        {
                        parent = FXMLLoader.load(getClass().getResource("../View/LibrarianHomePage.fxml"));
                        stage.setTitle("Library System - Librarian");
                    }
                }
                else {
                    parent = FXMLLoader.load(getClass().getResource("../View/NoRoleHomePage.fxml"));
                    stage.setTitle("Library System - No Role is identified");
                }
                 //parent = FXMLLoader.load(getClass().getResource("../View/Main.fxml"));
                Scene scene = new Scene(parent, 600, 375);

                stage.setScene(scene);
                //stage.setTitle("new page");
                stage.sizeToScene();

                stage.show();
            }

        }catch (Exception ex){}

    }
}
