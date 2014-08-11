package sandbox.lockc.javacert.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreams {

	public static void main(String[] args) throws IOException {
		 
		Path path = Paths.get("src/main/java/sandbox/lockc/javacert/nio");
		DirectoryStream<Path> dirStream = Files.newDirectoryStream(path, "*.{class,java}");
		dirStream.forEach(p -> System.out.println(p.toString()));
		
		

	}

}
