package lockc.java.concurrency.notthreadsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * Race condition exists getting the counter and adding 1.  thread A increments counter 
 * and is currently at 7 at same time thread B increments counter which is sees as 7 
 * thread A adds one and thread B adds one, they both set to 8.
 * 
 * Another race condition thread A is incrementing the counter but thread B calls getCounter
 * as same time, thread B gets stale data as thread A is in the middle of updating the counter.
 * 
 * counter = counter + 1 is not atomic!
 * 
 * @author lockc
 *
 */
@NotThreadSafe
public class Counter {

	private int counter;

	public int getCounter() {
		return counter;
	}

	public void incrementCounter() throws InterruptedException {
		counter = counter + 1;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		final Counter counter = new Counter();
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		for(int x = 0; x < 10; x++) {
			service.execute(new Runnable() {
				public void run() {
					while(counter.getCounter() < 100) {
						try {
							counter.incrementCounter();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(counter.getCounter());
					}
				}
			});
		}
		
		service.shutdown();
	}

}
