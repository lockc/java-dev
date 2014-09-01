package lockc.java8;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class HelloStream {
	
	private static BlockingQueue<String> queue = new SynchronousQueue<>();
	private static Set<ClientSession> sessions = new HashSet<>();
	private static ExecutorService threadpool = Executors.newFixedThreadPool(50);
	
	
	public static void main(String[] args) {
		for(int x = 0; x < 10000; x++) {
			sessions.add(new ClientSession());
		}
		
		Thread in = new Thread(new DataIn());
		in.start();

		Thread out = new Thread(new DataOut());
		out.start();
		
		
		
		
	}

	/*
	 * represents a stream of data coming from kafka module
	 */
	public static class DataIn implements Runnable {

		@Override
		public void run() {
			for(;;) {
				String data = String.valueOf(ThreadLocalRandom.current().nextLong());
				System.out.println("put " + data);
				
				try {
					queue.put(data);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
			
		}	
	}
	
	/*
	 * represents 
	 */
	public static class DataOut implements Runnable {

		@Override
		public void run() {
			System.out.println("DataOut ");
			ExecutorService service = Executors.newSingleThreadExecutor();
			for(;;) {
								
				try {
					String data = queue.take();
					System.out.println("take " + data);
					
					
					long start = System.currentTimeMillis();
					Future<Void> future = service.submit(new FanOutStream(data));
//					Future<Void> future = service.submit(new FanOutIterate(data));
					future.get();
					long elapsed = System.currentTimeMillis() - start;
					
					System.out.println("This fan out of messages took " + elapsed);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
				
			}
		}	
		
		
	}
	
	
	public static class FanOutStream implements Callable<Void> {

		private final String message;
		
		public FanOutStream(String message) {
			this.message = message;
		}

		@Override
		public Void call() throws Exception {
			Stream<ClientSession> clientStream = sessions.parallelStream();
			clientStream.forEach(cs -> cs.push(message));
			return null;
		}
		
	}
	
	public static class FanOutIterate implements Callable<Void> {

		private final String message;
		
		public FanOutIterate(String message) {
			this.message = message;
		}

		@Override
		public Void call() throws Exception {
			for(ClientSession cs : sessions) {
				cs.push(message);
			}
			return null;
		}
		
		
	}
}
