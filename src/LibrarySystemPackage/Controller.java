package LibrarySystemPackage;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    public void handleRegisterMemberButtonAction(Event event) {
        try {
            //tam code
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/RegisterUser.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Register User");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void handelLoginButtonAction(Event event) {
        //dtakele code
    }

    public void handelCheckOutButtonAction(Event event) {
        //esaago code
    }

    public void handleAddCopyBookButton(Event event) {
        //sang code
    }
}