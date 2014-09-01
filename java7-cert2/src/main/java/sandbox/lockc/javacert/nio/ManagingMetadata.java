package sandbox.lockc.javacert.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;


public class ManagingMetadata {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		Path file = Paths.get("test.txt");
		
		PosixFileAttributes attr = Files.readAttributes(file, PosixFileAttributes.class);
		
		/*
		 * Common 
		 */
		System.out.println("BasicFileAttributes - creationTime: " + attr.creationTime());
		System.out.println("BasicFileAttributes - lastAccessTime: " + attr.lastAccessTime());
		System.out.println("BasicFileAttributes - lastModifiedTime: " + attr.lastModifiedTime());
		System.out.println("BasicFileAttributes - isDirectory: " + attr.isDirectory());
		System.out.println("BasicFileAttributes - isOther: " + attr.isOther());
		System.out.println("BasicFileAttributes - isRegularFile: " + attr.isRegularFile());
		System.out.println("BasicFileAttributes - isSymbolicLink: " + attr.isSymbolicLink());
		System.out.println("BasicFileAttributes - size: " + attr.size());
		
		/*
		 * UNIX
		 */
		System.out.println("PosixFileAttributes - owner: " + attr.owner());
		System.out.println("PosixFileAttributes - group: " + attr.group());
		System.out.println("PosixFileAttributes - permissions: " + attr.permissions());
		System.out.format("%s %s %s%n",
			    attr.owner().getName(),
			    attr.group().getName(),
			    PosixFilePermissions.toString(attr.permissions()));

		/*
		 * DOS
		 * 
		System.out.println("DosFileAttributes - isArchive: " + attr.isArchive());
		System.out.println("DosFileAttributes - isHidden: " + attr.isHidden());
		System.out.println("DosFileAttributes - isReadOnly: " + attr.isReadOnly());
		System.out.println("DosFileAttributes - isSystem: " + attr.isSystem());
		 */
		
		
		
		
		String newPermissions = "rwxrwxr--";
		FileAttribute<Set<PosixFilePermission>> attributes = 
				PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString(newPermissions));
		
		Path file2 = Files.createFile(Paths.get("test2.txt"), attributes);
		
		PosixFileAttributes attr2 = Files.readAttributes(file2, PosixFileAttributes.class);
		
		System.out.println("PosixFileAttributes - owner: " + attr2.owner());
		System.out.println("PosixFileAttributes - group: " + attr2.group());
		System.out.println("PosixFileAttributes - permissions: " + attr2.permissions());
		System.out.format("%s %s %s%n",
				attr2.owner().getName(),
			    attr2.group().getName(),
			    PosixFilePermissions.toString(attr2.permissions()));
		
	}

}
