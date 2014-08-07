package sandbox.lockc.javacert.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DirectoryStreams {

	public static void main(String[] args) throws IOException {
		
		Files.newDirectoryStream(Paths.get(""), "*.{class,java}");

	}

}
