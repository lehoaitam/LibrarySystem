package LibrarySystemPackage.Model;

/**
 * Created by lehoaitam on 6/1/16.
 */
public class BookCopy {
    private int copyNumber;
    private int zsbn;
    public BookCopy(int copyNumber,int zsbn){
        this.copyNumber = copyNumber;
        this.zsbn = zsbn;
    }
    @Override
    public String toString(){
        return "ISBN: " + zsbn + " Copy Number: " + copyNumber;
    }

    public int getCopyNumber(){return copyNumber;}
    public int getISBN(){return  zsbn;}
}
