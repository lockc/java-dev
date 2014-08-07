package sandbox.lockc.javacert.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FindingFiles {

	public static void main(String[] args) throws IOException {

		
		Files.walkFileTree(Paths.get("."), new FileFinderVisitor("glob:*.java"));
		
		Files.walkFileTree(Paths.get("."), new FileFinderVisitor("glob:FindingFiles.java"));
		
		Files.walkFileTree(Paths.get("."), new FileFinderVisitor("regex:FindingFiles.java"));
		
		Files.walkFileTree(Paths.get("."), new FileFinderVisitor("blah:FindingFiles.java"));
		
	}
	
	
	
	
	public static class FileFinderVisitor extends SimpleFileVisitor<Path> {
		
		public FileFinderVisitor(String pattern) {
			this.matcher = FileSystems.getDefault().getPathMatcher(pattern);
		}

		private PathMatcher matcher;
		
		@Override
		public FileVisitResult preVisitDirectory(Path path,
				BasicFileAttributes attrs) throws IOException {
			find(path);
			return FileVisitResult.CONTINUE;
		}
		
		@Override
		public FileVisitResult visitFile(Path path,
				BasicFileAttributes attrs) throws IOException {
			find(path);			
			return FileVisitResult.CONTINUE;
		}
		
		
		
		public void find(Path path) {
			Path name = path.getFileName();
			if(matcher.matches(name)) {
				System.out.println("Found : " + path.toString());
			}
		}
	}

}
