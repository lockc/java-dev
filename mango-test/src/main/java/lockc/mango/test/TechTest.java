package lockc.mango.test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TechTest {

    public static void main(String[] args) {
        Path inputPath = Paths.get("src/main/resources/input.txt");
        Path outputPath = Paths.get("src/main/resources/actualOutput.txt");
        LineSorter lineSorter = new LineSorter();
        
        try {
            List<String> lines = FileHandler.readLines(inputPath);
            List<String> sortedLines = lineSorter.sortLines(lines);
            FileHandler.printLines(sortedLines);
            FileHandler.writeLines(outputPath, sortedLines);
                        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
