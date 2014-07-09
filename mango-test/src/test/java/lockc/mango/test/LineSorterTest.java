package lockc.mango.test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LineSorterTest {
    
    @Test(dataProvider="lineSorterData")
    public void testLineSorter(List<String> input, List<String> expected) {
        LineSorter lineSorter = new LineSorter();
        List<String> actual = lineSorter.sortLines(input);
        assertEquals(actual, expected);
    }
    
    @DataProvider
    public Object[][] lineSorterData() throws IOException {
        return new Object[][] {
            {
                FileHandler.readLines(Paths.get("src/main/resources/input.txt")), 
                FileHandler.readLines(Paths.get("src/main/resources/expectedOutput.txt"))
            }
        };
    }
}
