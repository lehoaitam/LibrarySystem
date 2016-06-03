package LibrarySystemPackage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by 985259 on 6/2/2016.
 */
public abstract class AbstractView {
    protected String title;
    protected String viewPath;
    public void showView(){
        try
        {
            Stage page = new Stage();
            page.setTitle(title);
            page.setScene(new Scene(FXMLLoader.load(this.getClass().getResource(viewPath))));
            page.show();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
