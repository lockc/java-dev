package sandbox.lockc.patterns.structural.decorator;

/**
 * A basic text component
 *
 */
public class TextComponent implements Component {
    
    private String text;
    
    public TextComponent(String text) {
    
        this.text = text;
    }
    
    @Override
    public void print() {
    
        System.out.print(text);
        
    }

    @Override
    public void draw() {
    
        int borderLength = text.length() + 4;
        String border = "";
        for(int i = 0; i < borderLength; i++) {
            border = border + "*"; 
        }
        
        System.out.println("\n");
        System.out.println(border);
        System.out.println("* " + text + " *");
        System.out.println(border);
        
    }
    
}
