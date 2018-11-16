package sandbox.lockc.javacert.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSyncroniser {

	public static void main(String[] args) throws InterruptedException {
		
		CyclicBarrier barrier = new CyclicBarrier(2);
		
		UserThread user1 = new UserThread(barrier, "Kate");
		UserThread user2 = new UserThread(barrier, "Heath");
		UserThread user3 = new UserThread(barrier, "Abigail");
		UserThread user4 = new UserThread(barrier, "Riff");
		
		user1.start();
		
		Thread.sleep(1000);
		System.out.println("Number waiting " + barrier.getNumberWaiting());
		Thread.sleep(3000);
		
		user2.start();
		
		Thread.sleep(1000);
		System.out.println("Number waiting " + barrier.getNumberWaiting());
		Thread.sleep(3000);
		
		user3.start();
		
		Thread.sleep(1000);
		System.out.println("Number waiting " + barrier.getNumberWaiting());
		Thread.sleep(3000);
		
		user4.start();
		
		Thread.sleep(1000);
		System.out.println("Number waiting " + barrier.getNumberWaiting());

	}

	public static class UserThread extends Thread {

		private CyclicBarrier barrier;
		private String name;
		
		public UserThread(CyclicBarrier barrier, String name) {
			this.barrier = barrier;
			this.name = name;
		}

		@Override
		public void run() {
			try {
				System.out.println(name + " has joined the game");
				barrier.await();
				System.out.println(name + " has started the game.");
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			
		}
	}
}
