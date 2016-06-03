package LibrarySystemPackage;

import LibrarySystemPackage.DataLayer.SQLiteJDBCDriverConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/Login.fxml"));
        primaryStage.setTitle("Library System - Login Page");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("Images/books.png")));
        primaryStage.setScene(new Scene(root, 400, 220));
        primaryStage.sizeToScene();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
