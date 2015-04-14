package sandbox.lockc.patterns.behavioural.strategy;


public class SimpleCalculator {
    
    public void calculate(double a, double b, CalculatorStrategy strategy) {
        
        double res = strategy.calculate(a, b);
        
        System.out.println(res);
        
    }
}
