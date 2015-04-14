package sandbox.lockc.patterns.behavioural.visitor;

import sandbox.lockc.patterns.behavioural.visitor.api.Visitor;
import sandbox.lockc.patterns.behavioural.visitor.domain.Picture;


public class PicturePrettyPrintVisitor implements Visitor<Picture> {

    @Override
    public void visit(Picture picture) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Title: ").append(picture.getTitle()).append("\n")
        .append("Author: ").append(picture.getArtist()).append("\n")
        .append("ISBN: ").append(picture.getStyle()).append("\n")
        .append("Published: ").append(picture.getFinished()).append("\n");
        
        System.out.println(sb.toString());
    }
    
}
