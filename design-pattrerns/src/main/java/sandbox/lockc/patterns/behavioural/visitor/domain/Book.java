package sandbox.lockc.patterns.behavioural.visitor.domain;

import java.util.Date;

import sandbox.lockc.patterns.behavioural.visitor.api.Visitable;
import sandbox.lockc.patterns.behavioural.visitor.api.Visitor;

public class Book implements Visitable<Book> {
    
    private String title;
    private String ISBN;
    private String author;
    private Date publised;
    
    public Book(String title, String iSBN, String author, Date publised) {
    
        super();
        this.title = title;
        ISBN = iSBN;
        this.author = author;
        this.publised = publised;
    }
    
    public String getTitle() {
    
        return title;
    }
    
    public void setTitle(String title) {
    
        this.title = title;
    }
    
    public String getISBN() {
    
        return ISBN;
    }
    
    public void setISBN(String iSBN) {
    
        ISBN = iSBN;
    }
    
    public String getAuthor() {
    
        return author;
    }
    
    public void setAuthor(String author) {
    
        this.author = author;
    }
    
    public Date getPublised() {
    
        return publised;
    }
    
    public void setPublised(Date publised) {
    
        this.publised = publised;
    }
    
    @Override
    public void accept(Visitor<Book> visitor) {
    
        visitor.visit(this);
        
    }
    
}
