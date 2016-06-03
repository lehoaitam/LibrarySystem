package LibrarySystemPackage.Model;

/**
 * Created by lehoaitam on 6/1/16.
 */
public class BookCopy {
    public int copyNumber;
    private int zsbn;
    public BookCopy(int copyNumber,int zsbn){
        this.copyNumber = copyNumber;
        this.zsbn = zsbn;
    }
    @Override
    public String toString(){
        return "ISBN: " + zsbn + " Copy Number: " + copyNumber;
    }
}
