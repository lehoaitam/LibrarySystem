package LibrarySystemPackage.Controller;

import LibrarySystemPackage.DataLayer.DataAcessFacade;
import LibrarySystemPackage.Model.LibraryMember;
import javafx.event.Event;

/**
 * Created by lehoaitam on 6/1/16.
 */
public class RegisterMemberController {
    public void handelCancelRegisterMember(Event event) {
    }

    public void handelRegisterMember(Event event) {
        LibraryMember member = new LibraryMember(3,"firstName", "lastName", "phoneNumber", "street", "city", "state", 52556, 2);
        DataAcessFacade dataAcess = new DataAcessFacade();
        dataAcess.saveLibraryMember(member);
    }
}
