package sandbox.lockc.patterns.behavioural.visitor.domain;

import java.util.Date;

import sandbox.lockc.patterns.behavioural.visitor.api.Visitable;
import sandbox.lockc.patterns.behavioural.visitor.api.Visitor;

public class Picture implements Visitable<Picture> {
    
    private String title;
    private String artist;
    private Date finished;
    private String style;
    
    public Picture(String title, String artist, Date finished, String style) {
    
        super();
        this.title = title;
        this.artist = artist;
        this.finished = finished;
        this.style = style;
    }
    
    public String getTitle() {
    
        return title;
    }
    
    public void setTitle(String title) {
    
        this.title = title;
    }
    
    public String getArtist() {
    
        return artist;
    }
    
    public void setArtist(String artist) {
    
        this.artist = artist;
    }
    
    public Date getFinished() {
    
        return finished;
    }
    
    public void setFinished(Date finished) {
    
        this.finished = finished;
    }
    
    public String getStyle() {
    
        return style;
    }
    
    public void setStyle(String style) {
    
        this.style = style;
    }
    
    @Override
    public void accept(Visitor<Picture> visitor) {
    
        visitor.visit(this);
    }
    
}
