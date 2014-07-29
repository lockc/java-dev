package sandbox.lockc.javacert.enhancements;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Exceptions {
	
	
	
	/*
	 * Can catch a wider exception and throw it as long as the declared exceptions 
	 * are sub types of thrown exception
	 * 
	 */
	public static void method1() throws IOException, IllegalArgumentException {
		try {
			throwsIOException();
			throwsIllegal();
		} catch(Exception ex) {
			throw(ex);
		}
	}
	
	/*
	 * But ... cannot throw a wider exception from a caught sub type
	 */
	public static void method2() throws IOException, IllegalArgumentException {
		try {
			throwsIOException();
			throwsIllegal();
		} catch(IOException | IllegalArgumentException ex) {
			throw new Exception();
		}
	}
	
	/*
	 * But .... can throw a sub type of the declared exception
	 */
	public static void method3() throws IOException, IllegalArgumentException {
		
		try {
			throwsIOException();
			throwsIllegal();
		} catch(IOException ex) {
			throw new FileNotFoundException();
		}
		
	}
	
	/*
	 * thrown exceptions must be declared
	 */
	public static void methodX() throws IOException, IllegalArgumentException {
		try {
			throwsExecutionException();
			throwsIOException();
			throwsIllegal();
			
		} catch(IOException | ExecutionException ex) {
			throw(ex);
		}
	}
	
	
	
	/*
	 * Cannot have sub types in multi-catch block
	 */
	public static void method4() throws IOException, IllegalArgumentException {
		
		try {
			throwsIOException();
			throwsIllegal();
		} catch(Exception | IOException ex) {
			throw(ex);
		}
		
	}

	
	
	/*
	 * Cannot re-assign the caught exception in a multi-catch block
	 */
	public static void method5() throws IOException, IllegalArgumentException {
		
		try {
			throwsIOException();
			throwsIllegal();
		} catch(IOException | IllegalArgumentException ex) {
			
			ex = new IOException();
			throw(ex);
		}
		
	}
	

	private static void throwsExecutionException() throws ExecutionException {
		
	}
	
	private static void throwsIOException() throws IOException {
		
	}
	
	private static void throwsIllegal() throws IllegalArgumentException {
		
	}
}
