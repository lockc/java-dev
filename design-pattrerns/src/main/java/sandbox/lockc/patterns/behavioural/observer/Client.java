package sandbox.lockc.patterns.behavioural.observer;

public class Client {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
    
        Subject subject = new Subject();
        subject.addObserver(new TellMe());
        subject.addObserver(new TellMe());
        
        subject.setData("I've changed.");
        
        subject.notifyObservers("You're being told.");
        
    }
    
}
