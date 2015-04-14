package sandbox.lockc.patterns.behavioural.visitor;

import sandbox.lockc.patterns.behavioural.visitor.api.Visitor;
import sandbox.lockc.patterns.behavioural.visitor.domain.Book;


public class BookPrettyPrintVisitor implements Visitor<Book> {

    
    @Override
    public void visit(Book book) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Title: ").append(book.getTitle()).append("\n")
            .append("Author: ").append(book.getAuthor()).append("\n")
            .append("ISBN: ").append(book.getISBN()).append("\n")
            .append("Published: ").append(book.getPublised()).append("\n");
        
        System.out.println(sb.toString());
    }
    
}
