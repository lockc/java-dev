package sandbox.lockc.patterns.behavioural.visitor.api;


public interface Visitor<T> {
    
    void visit(T object);
}
