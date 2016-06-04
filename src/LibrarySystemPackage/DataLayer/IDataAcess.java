package LibrarySystemPackage.DataLayer;

import LibrarySystemPackage.Model.LibraryMember;
import LibrarySystemPackage.Model.User;

/**
 * Created by 985119 on 6/2/2016.
 */
public interface IDataAcess {
    boolean saveLibraryMember(LibraryMember member);
    LibraryMember readLibraryMember(int id);

    User loginUser(String usrName, String password);
}
