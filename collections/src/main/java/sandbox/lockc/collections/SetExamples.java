package sandbox.lockc.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * A Set is a Collection that cannot contain duplicate elements. It models the mathematical set abstraction. 
 * The Set interface contains only methods inherited from Collection and adds the restriction that duplicate 
 * elements are prohibited. Set also adds a stronger contract on the behaviour of the equals and hashCode 
 * operations, allowing Set instances to be compared meaningfully even if their implementation types differ. 
 * Two Set instances are equal if they contain the same elements.
 * 
 * @author lockc
 *
 */
public class SetExamples {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        SetExamples examples = new SetExamples();
//        examples.example1();
//        examples.example2();
//        examples.example3();
//        examples.example4();
//        examples.example5();
//        examples.example6();
          examples.example7();
    }
    
    /*
     * Example of ordering (or lack of) for custom objects within a HashSet overriding the hashCode method
     * 
     * THERE IS NO ORDERING IN HASH COLLECTIONS  
     */
    public void example7() {
    	Collection<Person> people = new HashSet<Person>();
    	people.add(new Person("a", "b", 31));
    	people.add(new Person("a", "b", 32));
    	people.add(new Person("a", "b", 30));
        people.add(new Person("Kate", "Lock", 31));
        people.add(new Person("Katea", "Lock", 31));
        people.add(new Person("Kateb", "Lock", 31));
        print(people);
    }
    
    /*
     * Illustrates ordering of custom objects within a TreeSet
     */
    public void example6() {
        
        /*
         * Illustrates using the Comparator interface as a constructor arg
         */
    	Collection<Person> people = new TreeSet<Person>(new PersonComparator());
        people.add(new Person("Chris", "Lock", 31));
        people.add(new Person("Kate", "Lock", 31));
        people.add(new Person("Abigail", "Lock", 2));
        people.add(new Person("Heath", "Lock", 0));
        people.add(new Person("Chris", "Lock", 32));
        people.add(new Person("Chris", "Lock", 30));
        people.add(new Person("Chris", "Block", 30));
        print(people);
        
        /*
         * Illustrates using the Comparable interface implemented by the Person class
         */
        Collection<Person> people2 = new TreeSet<Person>();
        people2.add(new Person("Chris", "Lock", 31));
        people2.add(new Person("Kate", "Lock", 31));
        people2.add(new Person("Abigail", "Lock", 2));
        people2.add(new Person("Heath", "Lock", 0));
        people2.add(new Person("Chris", "Lock", 32));
        people2.add(new Person("Chris", "Lock", 30));
        people2.add(new Person("Chris", "Block", 30));
        print(people2);
    }
    
    /*
     * declare and initialise in one (annonymous inner class)
     */
    public void example5() {
        Collection<String> linkedHashSet = new LinkedHashSet<String>() {
            { add("a"); }
            { add("b"); }
            { add("c"); }
            { add("a"); }
        };
        System.out.println("LinkedHashSet output: " + linkedHashSet);
        
        
    }
    
    /*
     * Illustrates iterating over collections using for-each construct
     * and using the iterator
     */
    public void example4() {
        Collection<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("abc");
        linkedHashSet.add("000");
        linkedHashSet.add("abd");
        linkedHashSet.add("aba");
        linkedHashSet.add("001");
        System.out.println("LinkedHashSet output: " + linkedHashSet);
        
        for(String s : linkedHashSet) {
            System.out.println(s);
            
            // the following will error
//            linkedHashSet.remove(s); 
        }
        
        /*
         * This is essentially the long version of the above 
         */
        for(Iterator<String> it = linkedHashSet.iterator() ; it.hasNext(); ){
            System.out.println("LinkedHashSet output: " + linkedHashSet);
            System.out.println(it.next());
            /*
             * Using the Iterator is the only time you can modify the ollection whilst
             * iterating over it.
             */
            it.remove();
        }
        
        
    }
    
    /*
     * Illustrates conversion from a List to a Set collection type, removing duplicates 
     * and ordering the elements
     */
    public void example3() {
        
        Collection<String> arrayList = new ArrayList<String>();
        arrayList.add("abc");
        arrayList.add("000");
        arrayList.add("abd");
        arrayList.add("aba");
        arrayList.add("aba");
        arrayList.add("001");
        arrayList.add("000");
        System.out.println("LinkedHashSet output: " + arrayList);
        
        Collection<String> hashSet = new HashSet<String>(arrayList);
        System.out.println("HashSet output: " + hashSet);
    
        Collection<String> treeSet = new TreeSet<String>(arrayList);
        System.out.println("TreeSet output: " + treeSet);
        
    }
    
    /*
     * Illustrates the ordering of the set elements when converting between set types
     */
    public void example2() {
        
        Collection<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("abc");
        linkedHashSet.add("000");
        linkedHashSet.add("abd");
        linkedHashSet.add("aba");
        linkedHashSet.add("001");
        System.out.println("LinkedHashSet output: " + linkedHashSet);
        
        Collection<String> hashSet = new HashSet<String>(linkedHashSet);
        System.out.println("HashSet output: " + hashSet);
    
        Collection<String> treeSet = new TreeSet<String>(linkedHashSet);
        System.out.println("TreeSet output: " + treeSet);
        
    }
    
    /*
     * Illustrates sets not allowing duplicates and also the natural ordering between the set types
     */
    public void example1(){
        Collection<String> hashSet = new HashSet<String>();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        /*
         * No error is thrown when a duplicate is added, it just doesn't add it - returns false
         */
        hashSet.add("a");
        System.out.println("HashSet output: " + hashSet);
        
        Collection<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("a");
        linkedHashSet.add("b");
        linkedHashSet.add("c");
        linkedHashSet.add("a");
        System.out.println("LinkedHashSet output: " + linkedHashSet);
        
        /*
         * A tree set orders elements based on their values
         */
        Collection<String> treeSet = new TreeSet<String>();
        treeSet.add("b");
        treeSet.add("a");
        treeSet.add("c");
        treeSet.add("a");
        System.out.println("TreeSet output: " + treeSet);
        
        Collection<Integer> treeSet2 = new TreeSet<Integer>();
        treeSet2.add(1);
        treeSet2.add(7);
        treeSet2.add(4);
        System.out.println("TreeSet output: " + treeSet2);
    }

    
    private void print(Collection<Person> c) {
    	for(Person p : c) {
    		System.out.println(String.format("%s %s (%s) %s", p.getFirstName(), p.getLastName(), p.getAge(), p.hashCode()));
    	}
    }
}
