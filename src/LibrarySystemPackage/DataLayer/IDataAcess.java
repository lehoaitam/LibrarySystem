package LibrarySystemPackage.DataLayer;

import LibrarySystemPackage.Model.LibraryMember;

/**
 * Created by 985119 on 6/2/2016.
 */
public interface IDataAcess {
    boolean saveLibraryMember(LibraryMember member);
    LibraryMember readLibraryMember(int id);
}
