package sandbox.lockc.generics.bounded;

import java.util.Objects;

/**
 * 
 * PECS:
 * 
 * Producer
 * Extends
 * Consumer
 * Super
 * 
 * 
 * @author lockc
 *
 * @param <T> Is a 'type parameter' and with <code>Box\<String\></code> 'String' is a 'type argument'.
 */
public class BoundedBox<T extends Number> {
    
    private T t;
    
    public T getT() {
    
        return t;
    }
    
    public void setT(T t) {
    
        this.t = t;
    }
    
    
    /**
     * A generic bounded method
     * 
     * @param u
     */
    public void inspect() {
    
        System.out.println(">>>>");
        
        if (Objects.nonNull(t)) System.out.println("T: " + t.getClass().getName() + " Int Value: " + t);
        
        System.out.println("<<<<");
    }
    
}
