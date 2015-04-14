package sandbox.lockc.patterns.behavioural.visitor;

import sandbox.lockc.patterns.behavioural.visitor.api.Visitor;
import sandbox.lockc.patterns.behavioural.visitor.domain.Book;


public class BookSimplePrintVisitor implements Visitor<Book> {

    
    @Override
    public void visit(Book book) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(book.getTitle()).append(";")
            .append(book.getAuthor()).append(";")
            .append(book.getISBN()).append(";")
            .append(book.getPublised()).append("\n");
        
        System.out.println(sb.toString());
    }
    
}
