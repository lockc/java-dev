package lockc.java8.interfaces;

/**
 * Created by Chris on 26/02/2017.
 */
public interface DefaultMethods {

    int add(int firstNumber, int secondNumber);

    int subtract(int firstNumber, int secondNumber);

    default int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    default int divide(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }
}
