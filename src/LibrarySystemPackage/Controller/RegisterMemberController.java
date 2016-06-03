package LibrarySystemPackage.Controller;

import LibrarySystemPackage.DataLayer.DataAcessFacade;
import LibrarySystemPackage.Model.LibraryMember;
import javafx.event.Event;

/**
 * Created by lehoaitam on 6/1/16.
 */
public class RegisterMemberController {
    public void handelCancelRegisterMember(Event event) {
        //read from db sample
        DataAcessFacade dataAcess = new DataAcessFacade();
        LibraryMember member = dataAcess.readLibraryMember(3);
        System.out.println(member.firstName);
    }

    public void handelRegisterMember(Event event) {
        //save to db sample code
        LibraryMember member = new LibraryMember(4,"firstName", "lastName", "phoneNumber", "street", "city", "state", 52556, 2);
        DataAcessFacade dataAcess = new DataAcessFacade();
        dataAcess.saveLibraryMember(member);

    }
}
