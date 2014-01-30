package lockc.java.concurrency.threadsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;

/**
 * 
 * A class is immutable when:
 * 
 *  - Its state cannot be modified after construction
 *  - All its fields are final
 *  - It is properly constructed i.e. the this reference does not escape during construction
 * 
 * @author lockc
 *
 */
@Immutable
@ThreadSafe
public class ImmutableCounter {

	
	private final int counter;
	
	public ImmutableCounter(int counter) {
		this.counter = counter;
	}
	
	public int getCounter() {
		return counter;
	}
	
	
	
	public static void main(String[] args) {
		new CounterWatch().run();
	}

	@NotThreadSafe
	private static class CounterWatch  {
		
		private static volatile ImmutableCounter staticCounter;

		public void run() {
			
			ExecutorService service = Executors.newFixedThreadPool(10);
			
			staticCounter = new ImmutableCounter(0);
			
			for(int x = 0; x < 10; x++) {
				service.execute(new Runnable() {
					public void run() {
						while(staticCounter.getCounter() < 200) {
							
							staticCounter = new ImmutableCounter(staticCounter.getCounter() + 1);
							System.out.println(this.hashCode() + " " + staticCounter.getCounter());
						}
					}
				});
			}
			
			service.shutdown();
		}
		
	}
	
}
