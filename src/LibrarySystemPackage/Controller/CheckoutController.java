package LibrarySystemPackage.Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

import javafx.event.Event;
import javafx.scene.control.TreeTableView;

/**
 * Created by Issac on 6/2/16.
 */
public class CheckoutController implements Initializable {
    //@FXML
    //private Button searchMembers,searchBooks,addBook;
    @FXML
    private ListView membersList,booksList,checkoutBookList;
    @FXML
    private Label memberName;

    @FXML
    private void handleMemberSearcAction() {
        try {
            ObservableList<Object> data = FXCollections.observableArrayList("abc", "def", "jkl", "mno");
            membersList.setItems(data);
        }
        catch(Exception E) {
            E.printStackTrace();
        }
    }
    @FXML
    private void handleBookSearchAction() {
        ObservableList<Object> data = FXCollections.observableArrayList("How to cook meat, by Saron Afewerki","How to eat meat, by Saron Afewerki","Book 3","Book 4");
        booksList.setItems(data);
    }
    @FXML
    private void handleAddBookAction() {
        try{
        Object selectedBook=booksList.getSelectionModel().getSelectedItem();
        boolean BookIsSelected = false;
        for(Object item:checkoutBookList.getItems()){
            if(item.equals(selectedBook)){
                BookIsSelected = true;
                break;
            }
        }
        if(!BookIsSelected)
            checkoutBookList.getItems().add(selectedBook);
        }
        catch(Exception E) {
            E.printStackTrace();
        }
    }
    @FXML
    private void handleRemoveBookAction() {
        Object selectedBook=booksList.getSelectionModel().getSelectedItem();
        checkoutBookList.getItems().remove(selectedBook);
    }

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert membersList != null : "fx:id=\"memberTTV\" was not injected: check your FXML file 'Checkout.fxml'.";
        // initialize your logic here: all @FXML variables will have been injected

        membersList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Your action here
                memberName.setText(newValue);
            }
        });
    }
}

class Person{
    private String FName;

    public void setFName(String FName){
        this.FName = FName;
    }

    public String getFName(){
        return this.FName;
    }
}
