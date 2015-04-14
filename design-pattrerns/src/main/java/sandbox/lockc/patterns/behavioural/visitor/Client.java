package sandbox.lockc.patterns.behavioural.visitor;

import java.util.Calendar;

import sandbox.lockc.patterns.behavioural.visitor.domain.Book;
import sandbox.lockc.patterns.behavioural.visitor.domain.Picture;


public class Client {
    
    public static void main(String[] args) {
    
        Calendar c = Calendar.getInstance();
        
        c.set(2007, 6, 5);
        Book book = new Book("The Lord of The Rings", "0261103253", "J.R.R. Tolkien", c.getTime());
        book.accept(new BookPrettyPrintVisitor());
        book.accept(new BookSimplePrintVisitor());
        
        
        c.set(1517, 1, 1);
        Picture picture = new Picture("Mona Lisa", "Leonardo da Vinci", c.getTime(), "Oil on popular");
        picture.accept(new PicturePrettyPrintVisitor());
        
        
        
    }
    
}
