package sandbox.lockc.generics.bounded;

public abstract class BoxUtility {
    
    /**
     * Requires an exact type argument match with Number so 
     * passing a BoundedBox<Integer> or BoundedBox<Double> 
     * will not compile.
     * 
     * Having an exact match means the box argument can be 
     * both producer and consumer.
     * 
     * @param box
     */
    public static void updateNumberBox(BoundedBox<Number> box) {
    
        box.setT(10);
        
        box.inspect();
    }
    
    /**
     * Requires an exact type argument match with Integer so 
     * passing a BoundedBox<Number> or BoundedBox<Double> 
     * will not compile.
     * 
     * Having an exact match means the box argument can be 
     * both producer and consumer.
     * 
     * @param box
     */
    public static void updateIntegerBox(BoundedBox<Integer> box) {
        
        box.setT(11);
        
        box.inspect();
    }  
    
    /**
     * Requires a type argument that is either a Number or sub type 
     * of Number.  
     * 
     * Passing a BoundedBox<Integer> or BoundedBox<Double> is fine
     * but the box argument is a producer only.
     * 
     * @param box
     */
    public static void updateBoxBoundedProducer(BoundedBox<? extends Number> box) {
    
        // box.setT(12); // compiler error
                        
        box.inspect();
    }
    
    /**
     * {@link BoundedBox} is declared as a consumer so it can be updated.
     * 
     * Only passing a BoundedBox<Integer> argument is valid though, passing
     * a BoundedBox<Number> will not compile
     * 
     * @param box
     */
    public static void updateBoxBoundedConsumer(BoundedBox<? super Integer> box) {
    
        box.setT(13);
        
        box.inspect();
    }
  
    /**
     * Looks like an unbounded wildcard is treated the same as a
     * producer by the compiler.
     * 
     * @param box
     * @param num
     */
    public static void updateBoxUnbounded(BoundedBox<?> box, Number num) {
    
        // box.setT(num); // compiler error
        
        updateBoxUnboundedHelper(box, num);
        
        box.inspect();
    }
    
    
    /**
     * A generic helper method to capture wildcards through type inference.
     * 
     * In this example we are updating the box's number and we can ignore the 
     * 'unchecked' warning as the BoundedBox's type parameter is bounded by Number
     * so we know the box will always be a number.
     * 
     * But this method does allow you to alter the parameterised type at runtime, 
     * A BoundedBox<Integer> can end up holding a Double as its data and a
     * declared BoundedBox<Double> can end up holding an Integer. 
     * 
     * @param box
     * @param num
     */
    public static <T extends Number> void updateBoxUnboundedHelper(BoundedBox<T> box, Number num) {
        
        @SuppressWarnings("unchecked")
        T num2 = (T) num;
        box.setT(num2);
        
    }
    
    // Compiler error as T is not T extends Number as governed by the BoundedBox type parameter
//    public static <T> void updateBoxUnboundedHelper2(BoundedBox<T> box, String str) {
//        
//        @SuppressWarnings("unchecked")
//        T num2 = (T) str;
//        box.setT(num2);
//        
//    }
    
    
    
    
    
    
    
    /*
     * Wildcard capture helper method through type inference
     */
    
    
    public static void wildcardCapture(Box<?> box) {
        
        // box.setT(box.getT()); // compiler error
        
        wildcardCaptureHelper(box);
        
    }
    
    public static <T> void wildcardCaptureHelper(Box<T> box) {
    
        // Obviously dangerous as Box may be a Box<Double>
        box.setT((T) new Integer(11));
        
        // this is safe
        box.setT(box.getT());
    }
    
    // public static void wildcardCapture(Box<?> box1, Box<?> box2) {
    // wildcardCaptureHelper(box1, box2);
    // }
    //
    // public static <T> void wildcardCaptureHelper(Box<T> box1, Box<T> box2) {
    // box1.setT(box2.getT());
    // }
    //
}
