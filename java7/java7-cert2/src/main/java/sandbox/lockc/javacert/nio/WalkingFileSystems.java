package sandbox.lockc.javacert.nio;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkingFileSystems {

	public static void main(String[] args) throws Exception {
		
		Path source = Paths.get("/home/lockc/git/java-dev/java7-cert");
//		walkDirectory(source);
		
		source = Paths.get("/home/lockc/git/java-dev/java7-cert");
		Path destination = Paths.get("/home/lockc/git/java-dev/java7-cert2/");
		
		copy(source, destination);
	}
	
	public static void copy(Path source, Path destination) throws IOException {
		
		
		Files.walkFileTree(source, new CopyFileVisitor(source, destination));
		
		
		
	}
	
	public static class CopyFileVisitor extends SimpleFileVisitor<Path> {
		
		public CopyFileVisitor(Path source, Path destination) {
			super();
			this.source = source;
			this.destination = destination;
		}

		private Path source, destination;
		
		@Override
		public FileVisitResult preVisitDirectory(Path path,
				BasicFileAttributes attrs) throws IOException {
			
			Path target = destination.resolve(source.relativize(path));
			Files.copy(path, target, StandardCopyOption.REPLACE_EXISTING);
			return FileVisitResult.CONTINUE;
		}
		
		@Override
		public FileVisitResult visitFile(Path path,
				BasicFileAttributes attrs) throws IOException {
			Path target = destination.resolve(source.relativize(path));
			Files.copy(path, target, StandardCopyOption.REPLACE_EXISTING);			
			return FileVisitResult.CONTINUE;
		}
		
	}
	
	
	public static void walkDirectory(Path source) throws IOException {
		Files.walkFileTree(source, new FileVisitor<Path>() {

			@Override
			public FileVisitResult preVisitDirectory(Path dir,
					BasicFileAttributes attrs) throws IOException {
				
				System.out.println(dir.toString());
				
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(Path file,
					BasicFileAttributes attrs) throws IOException {
				
				System.out.println(file.toString());
				
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc)
					throws IOException {
				System.out.println(exc.toString());
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc)
					throws IOException {
				return FileVisitResult.CONTINUE;
			}
		});
	}
	
	

}
