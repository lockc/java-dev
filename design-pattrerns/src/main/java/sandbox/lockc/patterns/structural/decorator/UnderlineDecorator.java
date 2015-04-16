package sandbox.lockc.patterns.structural.decorator;

/**
 * A decorator to underline a Component
 * 
 * The abstract ComponentDecorator handles the draw method
 * otherwise each decorator would need to implement it.  
 *
 */
public class UnderlineDecorator extends ComponentDecorator {
    
    public UnderlineDecorator(Component component) {
    
        super(component);
    }
    
    /**
     * forwards the print call onto the Component and 
     * adds an underline 
     */
    @Override
    public void print() {
        
        component.print();
        
        System.out.print("\n-----------------------------");
    }
    
}
