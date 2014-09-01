package sandbox.lockc.javacert.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.WatchService;
import java.sql.SQLException;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class PathStuff {

	public static void main(String[] args) {

		/* ********************************
		 * normalize
		 * ********************************/
		
		/*
		 * prints '/home'
		 */
		Path p = Paths.get("/home/lockc/../.");
		System.out.println(p.normalize());
		
		
		/* ********************************
		 * relativize
		 * ********************************/
		
		/*
		 * prints 'git'
		 */
		Path p1 = Paths.get("/home/lockc/");
		Path p2 = Paths.get("/home/lockc/git");
		System.out.println(p1.relativize(p2));
		
		/*
		 * prints '..'
		 */
		p1 = Paths.get("/home/lockc/git");
		p2 = Paths.get("/home/lockc/");
		System.out.println(p1.relativize(p2));
		
		/*
		 * prints 'sub'
		 */
		p1 = Paths.get("target");
		p2 = Paths.get("target/sub");
		System.out.println(p1.relativize(p2));
		
		
		/*
		 * 
		 */
		System.out.println(p1.resolve(p2));
		
	}


}
