package LibrarySystemPackage.Controller;

import LibrarySystemPackage.DataLayer.DataAcessFacade;
import LibrarySystemPackage.Model.LibraryMember;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by lehoaitam on 6/1/16.
 */
public class RegisterMemberController {
    @FXML
    private TextField memberId,firstName,lastName,street,city,state,phone,zip;
    @FXML
    private Label successLabel, failLabel;
//    @Override
//    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
//        assert memberId != null : "fx:id=\"memberTTV\" was not injected: check your FXML file 'Checkout.fxml'.";
//        // initialize your logic here: all @FXML variables will have been injected
//    }
    public void handelCancelRegisterMember(Event event) {
        //read from db sample
        DataAcessFacade dataAcess = new DataAcessFacade();
        LibraryMember member = dataAcess.readLibraryMember(3);
        System.out.println(member.firstName);
    }
    @FXML
    public void handelRegisterMember(Event event) {
        //save to db sample code
        int memberIdValue = Integer.parseInt(memberId.getText());
        String firstNameValue = firstName.getText();
        String lastNameValue = lastName.getText();
        String streetValue = street.getText();
        String cityValue = city.getText();
        String stateValue = state.getText();
        String phoneValue = phone.getText();
        int zipValue = Integer.parseInt(zip.getText());
        LibraryMember member = new LibraryMember(memberIdValue,firstNameValue, lastNameValue,phoneValue, streetValue, cityValue, stateValue, zipValue, 2);
        DataAcessFacade dataAcess = new DataAcessFacade();

        if(dataAcess.saveLibraryMember(member)){
            successLabel.setVisible(true);
            failLabel.setVisible(false);
        }else{
            successLabel.setVisible(false);
            failLabel.setVisible(true);
        }

    }

}
