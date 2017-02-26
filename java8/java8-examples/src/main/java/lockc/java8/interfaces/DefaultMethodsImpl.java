package lockc.java8.interfaces;

/**
 * Created by Chris on 26/02/2017.
 *
 * The {@link DefaultMethods#multiply(int, int)} doesn't need to be implemented as
 * it has a default implementation
 *
 *
 */
public class DefaultMethodsImpl implements DefaultMethods {

    @Override
    public int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public int subtract(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    /**
     * Overridden the default implementation with our own
     *
     * @param firstNumber
     * @param secondNumber
     * @return
     */
    @Override
    public int divide(int firstNumber, int secondNumber) {
        return secondNumber / firstNumber;
    }
}
