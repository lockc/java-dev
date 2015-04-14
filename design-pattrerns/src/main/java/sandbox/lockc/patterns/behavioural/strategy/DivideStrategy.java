package sandbox.lockc.patterns.behavioural.strategy;


public class DivideStrategy implements CalculatorStrategy {
    
    @Override
    public double calculate(double a, double b) {
    
        return a / b;
    }
    
}
