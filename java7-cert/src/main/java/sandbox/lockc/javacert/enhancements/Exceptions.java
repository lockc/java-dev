package sandbox.lockc.javacert.enhancements;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Exceptions {
	
	
	
	/*
	 * Can catch a wider exception and throw it as long as the declared exceptions 
	 * are sub types of thrown exception
	 * 
	 */
	public static void method1() throws IOException, IllegalArgumentException {
		
		try {
			
		} catch(Exception ex) {
			throw(ex);
		}
		
	}
	
	/*
	 * But ... cannot throw a wider exception from a caught sub type
	 */
	public static void method2() throws IOException, IllegalArgumentException {
		
		try {
			throw new IOException();
		} catch(IOException | IllegalArgumentException ex) {
			throw new Exception();
		}
		
	}
	
	/*
	 * But .... can throw a sub type of the declared exception
	 */
	public static void method3() throws IOException, IllegalArgumentException {
		
		try {
			throw new IOException();
		} catch(IOException ex) {
			throw new FileNotFoundException();
		}
		
	}
	
	/*
	 * Cannot have sub types in multi-catch block
	 */
	public static void method4() throws IOException, IllegalArgumentException {
		
		try {
			throw new IOException();
		} catch(Exception | IOException ex) {
			throw(ex);
		}
		
	}

	
	
	/*
	 * Cannot re-assign the caught exception in a multi-catch block
	 */
	public static void method5() throws IOException, IllegalArgumentException {
		
		try {
			throw new IOException();
		} catch(IOException | IllegalArgumentException ex) {
			
			ex = new IOException();
			throw(ex);
		}
		
	}
	
	
}
