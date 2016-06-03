package LibrarySystemPackage.Model;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by lehoaitam on 6/1/16.
 */
public class CheckOutRecord {
    private LibraryMember memberId;
    private LocalDate borrowDate;
    private List<CheckOutRecordEntry> listCheckOutRecordEntry;

    public CheckOutRecord(LibraryMember memberId, LocalDate borrowDate,List<CheckOutRecordEntry> listCheckOutRecordEntry){
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.listCheckOutRecordEntry = listCheckOutRecordEntry;
    }
}
