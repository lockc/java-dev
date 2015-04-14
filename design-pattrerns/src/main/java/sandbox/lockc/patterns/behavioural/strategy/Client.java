package sandbox.lockc.patterns.behavioural.strategy;

public class Client {
    
    public static void main(String[] args) {
    
        SimpleCalculator calc = new SimpleCalculator();
        
        calc.calculate(10, 2, new DivideStrategy());
        
        calc.calculate(10, 2, new MultiplyStrategy());
        
        calc.calculate(10, 2, new AddStrategy());
        
        calc.calculate(10, 2, new SubtractStrategy());
        
    }
    
}
