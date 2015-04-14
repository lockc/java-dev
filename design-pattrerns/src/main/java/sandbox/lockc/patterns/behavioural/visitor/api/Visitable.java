package sandbox.lockc.patterns.behavioural.visitor.api;


public interface Visitable<T> {
    
    void accept(Visitor<T> visitor);
}
