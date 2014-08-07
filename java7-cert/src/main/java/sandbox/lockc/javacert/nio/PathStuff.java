package sandbox.lockc.javacert.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathStuff {

	public static void main(String[] args) {

		/* ********************************
		 * normalize - resolves redundant elements
		 * ********************************/
		
		/*
		 * prints '/home'
		 */
		Path p = Paths.get("/home/lockc/../.");
		System.out.println(p.normalize());
		
		
		/* ********************************
		 * relativize - 
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
		
		
		
		/* ********************************
		 * resolve - merges two paths
		 * ********************************/
		
		/*
		 * prints 'a/b/c/d'
		 */
		p1 = Paths.get("a/b/");
		p2 = Paths.get("c/d");
		System.out.println(p1.resolve(p2));
		
		/*
		 * prints '/a/b/c/d'
		 */
		p1 = Paths.get("/a/b/");
		p2 = Paths.get("c/d");
		System.out.println(p1.resolve(p2));
		
		/*
		 * prints '/c/d'
		 */
		p1 = Paths.get("a/b/");
		p2 = Paths.get("/c/d");
		System.out.println(p1.resolve(p2));
		
		/*
		 * prints '/c/d'
		 */
		p1 = Paths.get("/a/b/");
		p2 = Paths.get("/c/d");
		System.out.println(p1.resolve(p2));
		
	}


}
