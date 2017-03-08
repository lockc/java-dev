package sandbox.lockc.oo;

/**
 * Created by Chris on 26/02/2017.
 *
 * @see "https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html"
 *
 *
 */
public class Polymophism {

    public static void main(String[] args) {

        /**
         * The two objects can take many forms
         */

        //
        ConcreteOne concreteOne = new ConcreteOne();
        ConcreteTwo concreteTwo = new ConcreteTwo();

        //
        TypeOne typeOneA = concreteOne;
        TypeOne typeOneB = concreteTwo;

        //
        ParentClass parentA= concreteOne;
        ParentClass parentB = concreteTwo;

        //
        TypeTwo typeTwo = concreteOne;
        TypeThree typeThree = concreteTwo;

        //
        Object objectOne = concreteOne;
        Object objectTwo = concreteTwo;
    }


    private interface TypeOne {}

    private interface TypeTwo {}

    private interface TypeThree {}

    private static abstract class ParentClass implements TypeOne {

    }

    private static class ConcreteOne extends ParentClass implements TypeTwo {

    }

    private static class ConcreteTwo extends ParentClass implements TypeThree {

    }
}
