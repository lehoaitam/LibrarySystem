package LibrarySystemPackage.Controller;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {
    public void handelLoginButtonAction(Event event) {
        //dtakele code
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/Login.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void handleRegisterMemberButtonAction(Event event) {
        try {
            //tam code
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/RegisterMember.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Register User");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void handelCheckOutButtonAction(Event event) {
        //esaago code
        try {
            //Issac
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/Checkout.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Check out");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void handleAddCopyBookButton(Event event) {
        //sang code
    }
}