package sandbox.lockc.javacert.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchSynchroniser {

	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch latch = new CountDownLatch(10);
		
		UserThread user1 = new UserThread(latch, "Kate");
		UserThread user2 = new UserThread(latch, "Heath");
		UserThread user3 = new UserThread(latch, "Abigail");
		UserThread user4 = new UserThread(latch, "Riff");
		
		user1.start();
		user2.start();
		user3.start();
		user4.start();
		
		long init = latch.getCount();
		for(long x = 0; x < init; x++) {
			
			System.out.println("latch is at " + latch.getCount());
			
			Thread.sleep(3000);
			
			latch.countDown();
		}

	}

	public static class UserThread extends Thread {

		private CountDownLatch latch;
		private String name;
		
		public UserThread(CountDownLatch latch, String name) {
			this.latch = latch;
			this.name = name;
		}

		@Override
		public void run() {
			try {
				System.out.println(name + " is waiting to start");
				latch.await();
				System.out.println(name + " has started.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
