package LibrarySystemPackage.Controller;

import LibrarySystemPackage.Main;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
            stage.setTitle("Add Member");
            stage.getIcons().add(new Image(Main.class.getResourceAsStream("Images/books.png")));
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void handleCheckoutBookLinkAction(Event event) {
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

    public void handleLogoutAction(Event event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setTitle("Library System - Login Page");
            Scene scene = new Scene(parent, 400, 220);

            stage.setScene(scene);
            stage.sizeToScene();

            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void handleAddCopyBookButtonAction()
    {
        new AddABookCopyController().showView();
    }

    public void handleAddBookButtonAction()
    {
        new AddABookController().showView();
    }
}