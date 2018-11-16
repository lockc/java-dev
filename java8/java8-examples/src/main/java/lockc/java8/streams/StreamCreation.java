package lockc.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * This class shows some examples of how to generate a stream
 *
 * @author clock
 */
public class StreamCreation {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
        example5();
    }

    /**
     * Example using {@link Stream#of(Object[])} varargs to create a stream
     */
    public static void example1() {
        Stream<String> stream = Stream.of("one", "two", "three", "four");
        doSomethingWithStream(stream, 't');
    }

    /**
     * Example using {@link Stream#of(Object[])} with an Array to create a stream
     */
    public static void example2() {
        String[] strings = {"one", "two", "three", "four"};
        Stream<String> stream = Stream.of(strings);
        doSomethingWithStream(stream, 'f');
    }

    /**
     * Example using {@link Stream#builder()}
     */
    public static void example3() {
        Stream<Object> stream = Stream.builder().add("one").add("two").add("three").add("four").add("five").build();
        doSomethingWithStream(stream, 'o');
    }

    /**
     * Example using the {@link Collection#stream()} method
     */
    public static void example4() {
        List<String> numbers = new ArrayList<>();
        numbers.add("one");
        numbers.add("two");
        numbers.add("three");
        numbers.add("four");

        Stream<String> stream = numbers.stream();
        doSomethingWithStream(stream, 'o');

        numbers.spliterator();
    }

    public static void example5() {
        String[] strings = {"one", "two", "three", "four"};
        Stream<Object> stream = Arrays.stream(strings);
        doSomethingWithStream(stream, 'o');
    }

    public static void doSomethingWithStream(Stream<?> stream, char c) {

        long startsWithT = stream.filter(s -> {
            if(s instanceof String) {
                return ((String) s).charAt(0) == c;
            }
            return false;
        }).count();
        System.out.println(String.format("Numbers that start with 't' : %s", startsWithT));
    }

    /**
     * This actually creates a continuous stream and will never complete execution
     */
    public static void exampleX() {

        Stream<String> stream = Stream.generate(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("StreamCreation.get");
                return "One";
            }
        });
        doSomethingWithStream(stream, 'f');
    }
}
