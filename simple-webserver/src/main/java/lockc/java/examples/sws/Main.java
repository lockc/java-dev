package lockc.java.examples.sws;

public class Main {

	public static void main(String[] args) throws Exception {
		SimpleHttpServer http = new SimpleHttpServer(8080, 10, 2);
		http.start();
		
//		Thread.sleep(15000);
//		
//		http.stop();
	}

}
