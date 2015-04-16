package sandbox.lockc.patterns.structural.decorator;


public class Client {
    
    public static void main(String[] args) {
    
        /**
         * A basic text component
         */
        System.out.print("Basic Text Component:\n  >> ");
        Component c = new TextComponent("Hello decorator");
        c.print();
        
        /**
         * Punctuation added to the text component
         */
        System.out.print("\n\nPunctuation Added:\n  >> ");
        c = new PunctuationDecorator(c);
        c.print();
        
        /**
         * Text is now underlined 
         */
        System.out.print("\n\nNow underlined:\n  >> ");
        c = new UnderlineDecorator(c);
        c.print();
        
        /**
         * 
         */
        c.draw();
        
        
    }
    
}
