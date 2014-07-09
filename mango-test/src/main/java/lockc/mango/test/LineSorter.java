package lockc.mango.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class LineSorter {

    private static final String DELIMETER = ",";
    
    public List<String> sortLines(List<String> lines) {
        List<String> reversedLines = new ArrayList<>();
        
        for(String line : lines) {
            List<String> splitLine = splitLine(line);
            sortStringsReverseOrder(splitLine);
            List<String> reversedLine = splitLine;
            reversedLines.add(assembleLine(reversedLine));
        }
        
        return reversedLines;
    }
    
    private List<String> splitLine(String line) {
        String[] lineSplit = line.split(DELIMETER);
        return Arrays.asList(lineSplit);
    }
    
    private void sortStringsReverseOrder(List<String> strings) {
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String arg1, String arg2) {
                int compareResult = arg1.compareTo(arg2);
                return compareResult * -1;
            }
        });
    }
    
    private String assembleLine(List<String> line) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = line.iterator();
        while(it.hasNext()) {
            sb.append(it.next());
            if(it.hasNext()) {
                sb.append(DELIMETER);
            }
        }
        return sb.toString();
    }
    
}
