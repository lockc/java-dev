package lockc.mango.test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileHandler {

    private FileHandler() { }
    
    public static List<String> readLines(Path path) throws IOException {
        return Files.readAllLines(path, Charset.defaultCharset());
    }
    
    public static void writeLines(Path path, List<String> lines) throws IOException {
        Files.write(path, lines, Charset.defaultCharset(), StandardOpenOption.CREATE);
    }
    
    public static void printLines(List<String> lines) {
        for(String line : lines) {
            System.out.println(line);
        }
    }
}
