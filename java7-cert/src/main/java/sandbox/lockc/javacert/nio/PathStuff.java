package sandbox.lockc.javacert.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
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

		System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).format(5.99));

		long someLong = 1__2L;
		
//		Conc
//		
//		FileSystems.getDefault().getPathMatcher("");
//		
//		
//		List<Map<String, Integer>> list = new ArrayList<>();
//		
//		/* --------------------------------
//		 * Type mismatch: cannot convert from ArrayList<HashMap<String,Integer>> to List<Map<String,Integer>>
//		 */
//		// List<Map<String, Integer>> list2 = new ArrayList<HashMap<String, Integer>>();
//		// --------------------------------
//		
//		
//		new PathMatcher() {
//			
//			@Override
//			public boolean matches(Path path) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//		};
//		
//		List<? extends Number> numbers = Arrays.asList(1.2, 3d, 3.9E14); 
//		
//		for(Number number : numbers) {
//			System.out.println(number);
//		}
//	
//		new RecursiveAction() {
//			
//			@Override
//			protected void compute() {
//				// TODO Auto-generated method stub
//				
//			}
//		};
//		
//		
//		new RecursiveTask<String>() {
//
//			@Override
//			protected String compute() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
//		
//		new ForkJoinTask<String>() {
//
//			@Override
//			public String getRawResult() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			protected void setRawResult(String value) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			protected boolean exec() {
//				// TODO Auto-generated method stub
//				return false;
//			}
//		};
//		
//			try {
//				test();
//			} catch (IOException  e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//		
	}
	
	public static void test() throws IOException, FileNotFoundException, SQLException {
		
	}
	
	

}
