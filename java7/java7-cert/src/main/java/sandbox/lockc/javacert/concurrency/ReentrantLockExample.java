package sandbox.lockc.javacert.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		
		try {
			lock.lock();
			lock.lock();
			lock.lock();
			lock.lock();
			lock.unlock();
			lock.unlock();
			lock.unlock();
		} finally {
			
		}
		
		
		UserThread user1 = new UserThread(lock, "Kate");
		UserThread user2 = new UserThread(lock, "Heath");
		UserThread user3 = new UserThread(lock, "Abigail");
		user1.start();
		user2.start();
		user3.start();
	}
	
	public static class UserThread extends Thread {

		private Lock lock;
		private String name;
		
		public UserThread(Lock lock, String name) {
			this.lock = lock;
			this.name = name;
		}

		@Override
		public void run() {
			try {
				
				System.out.println(name + " wants the lock");
				lock.lock();
				System.out.println(name + " has the lock");
				Thread.sleep(3000);
				lock.unlock();
				System.out.println(name + " has released the lock");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
