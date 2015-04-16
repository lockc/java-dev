package sandbox.lockc.patterns.creational.singleton;


public class Client {
    
    public static void main(String[] args) {
        
        SingletonClass singletonClass = SingletonClass.getInstance();
        SingletonClass singletonClass2 = SingletonClass.getInstance();
        
        System.out.println(singletonClass);
        System.out.println(singletonClass2);
        System.out.println(singletonClass.equals(singletonClass2));
    }
}
