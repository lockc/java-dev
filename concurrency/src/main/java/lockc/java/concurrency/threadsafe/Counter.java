package lockc.java.concurrency.threadsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/**
 * An example of an intrinsic lock, using the 'synchronized' statement uses the 
 * object itself as the lock.  This doesn't block access to the object it only stop 
 * other threads acquiring the same lock.   
 * 
 * @author lockc
 *
 */
@ThreadSafe
public class Counter {

	/**
	 * The volatile statement ensures the latest write to counter will be visible to 
	 * all calling threads, without this writes from one thread are not guaranteed
	 * to be visible to other consuming threads
	 */
	@GuardedBy("this")
	private volatile int counter;

	public synchronized int getCounter() {
		return counter;
	}

	public synchronized void incrementCounter() throws InterruptedException {
		counter = counter + 1;
	}
	
	
	
	
	public static void main(String[] args) {
		
		final Counter counter = new Counter();
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		for(int x = 0; x < 10; x++) {
			service.execute(new Runnable() {
				public void run() {
					while(counter.getCounter() < 200) {
						try {
							counter.incrementCounter();
							System.out.println(this.hashCode() + " " + counter.getCounter());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			});
		}
		
		service.shutdown();
	}
}
