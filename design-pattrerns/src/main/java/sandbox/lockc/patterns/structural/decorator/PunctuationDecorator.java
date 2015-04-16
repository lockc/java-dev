package sandbox.lockc.patterns.structural.decorator;

/**
 * A decorator to add punctuation to a Component
 * 
 * The abstract ComponentDecorator handles the draw method
 * otherwise each decorator would need to implement it.  
 *
 */
public class PunctuationDecorator extends ComponentDecorator {
    
    public PunctuationDecorator(Component component) {
    
        super(component);
    }
    
    /**
     * forwards the print call onto the Component and adds
     * some punctuation at the end.
     */
    @Override
    public void print() {
        
        component.print();
        
        System.out.print(".  ");
    }
    
}
