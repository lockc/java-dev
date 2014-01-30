package lockc.java.concurrency.notthreadsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class Counter {

	private int counter;

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) throws InterruptedException {
		if(counter == 50 ) {
			Thread.sleep(1000);
		}
		this.counter = counter;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		final Counter counter = new Counter();
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		for(int x = 0; x < 10; x++) {
			service.execute(new Runnable() {
				public void run() {
					while(counter.getCounter() < 100) {
						try {
							counter.setCounter(counter.getCounter() + 1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(counter.getCounter());
					}
				}
			});
		}
		
		
	}

}
