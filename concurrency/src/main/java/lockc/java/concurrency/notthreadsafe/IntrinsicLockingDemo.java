package lockc.java.concurrency.notthreadsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IntrinsicLockingDemo {

	private int state = 0;
	
	public int getStateUnsafe() {
		return this.state;
	}
	
	public synchronized int getState() {
		System.out.println("get " + state);
		return this.state;
	}
	
	public synchronized void setState(int state) throws InterruptedException {
		System.out.println("set " + state);
		Thread.currentThread().sleep(50);
		this.state = state;
	}
	
	
	public static void main(String[] args) {
		
		final IntrinsicLockingDemo shared = new IntrinsicLockingDemo();
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		executorService.execute(new Runnable() {
			public void run() {
				while(true)
					shared.getStateUnsafe();
			}
		});
		
		executorService.execute(new Runnable() {
			public void run() {
				while(true)
					try {
						shared.setState(shared.getState() + 1);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}	
			}
		});
	}

}
