package LibrarySystemPackage;

import LibrarySystemPackage.DataLayer.DataAcessFacade;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by 985259 on 6/2/2016.
 */
public abstract class AbstractView {
    protected String title;
    protected String viewPath;
    protected DataAcessFacade dataAcessFacade;
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
    public AbstractView(){
        dataAcessFacade = new DataAcessFacade();
    }
}
