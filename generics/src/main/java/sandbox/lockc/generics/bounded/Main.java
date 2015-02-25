package sandbox.lockc.generics.bounded;

public class Main {
    
    public static void main(String[] args) {
    
        BoundedBox<Double> doubleBox = new BoundedBox<>();
        doubleBox.setT(new Double(1.1));
        
        BoundedBox<Number> numberBox = new BoundedBox<>();
        numberBox.setT(new Double(1.1));
        
        BoundedBox<Integer> integerBox = new BoundedBox<>();
        integerBox.setT(new Integer(2));
        
        BoundedBox<?> unboundedWildcardBox = new BoundedBox<Integer>();
        // unboundedWildcardBox.setT(3); // compiler error
        unboundedWildcardBox.setT(null);
        
        BoundedBox<? extends Number> boundedWildcardProducerBox = new BoundedBox<>();
        // boundedWildcardProducerBox.setT(new Integer(3)); // compiler error
        boundedWildcardProducerBox.setT(null); // Can do this
        
        /*
         * The BoundedBox is a consumer here as we are setting it's type argument to be an Number, it's
         * consuming an integer for it's type argument
         * 
         * Not sure why this works because Number is a lower bound so only Number and
         * super types should be allowed.
         */
        BoundedBox<? super Integer> boundedWildcardConsumerBox = new BoundedBox<>();
        boundedWildcardConsumerBox.setT(new Integer(3));
//        boundedWildcardConsumerBox.setT(new Object()); // compiler error
        Object temp1 = boundedWildcardConsumerBox.getT();
//        Integer temp2 = boundedWildcardConsumerBox.getT(); // compiler error
        
        
      
        
        
        BoxUtility.updateBoxUnbounded(numberBox, 2);
        BoxUtility.updateBoxUnbounded(integerBox, 3);
        BoxUtility.updateBoxUnbounded(unboundedWildcardBox, 4);
        
        // BoxUtility.updateBoxBoundedProducer(numberBox); // compiler error
        BoxUtility.updateBoxBoundedProducer(integerBox);
        // BoxUtility.updateBoxBoundedProducer(unboundedWildcardBox); // compiler error
        
        BoxUtility.updateBoxBoundedConsumer(numberBox);
        BoxUtility.updateBoxBoundedConsumer(integerBox);
        // BoxUtility.updateBoxBoundedConsumer(unboundedWildcardBox); // compiler error
               
        
        /*
         * Prime example of type erasure.  At runtime the BoundedBox is BoundedBox<Object>
         */
        integerBox.inspect();
        BoxUtility.updateBoxUnbounded(integerBox, 14.1);
        
        doubleBox.inspect();
        BoxUtility.updateBoxUnbounded(doubleBox, 2);
        
    }
    
}
