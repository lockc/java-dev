package sandbox.lockc.generics;

import java.util.List;
import java.util.Map;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeArgumentExample {
    
    public static void main(String[] args) {
    
        Class<?> pojoClass = Pojo.class;
        Field[] fields = pojoClass.getDeclaredFields();
        
        for (Field field : fields) {
            System.out.println("Field: " + field.getName());
            Type t = field.getGenericType();
            displayTypes(t);
        }
    }
    
    public static void displayTypes(Type type) {
    
        System.out.println(type.toString());
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            
            for (Type typeArg : pt.getActualTypeArguments()) {
                displayTypes(typeArg);
            }
        }
    }
    
    private static class Pojo {
        
        private List<String> strings;
        
        private List<List<Integer>> intergers;
        
        private Map<String, String> stringMap;
        
    }
}
