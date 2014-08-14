package sandbox.lockc.javacert.concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreSyncroniser {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);
	
		UserThread user1 = new UserThread(semaphore, "Kate");
		UserThread user2 = new UserThread(semaphore, "Heath");
		UserThread user3 = new UserThread(semaphore, "Abigail");
		UserThread user4 = new UserThread(semaphore, "Riff");
		
		user1.start();
		user2.start();
		user3.start();
		user4.start();
	}
	
	public static class UserThread extends Thread {

		private Semaphore resource;
		private String name;
		
		public UserThread(Semaphore resource, String name) {
			this.resource = resource;
			this.name = name;
		}

		@Override
		public void run() {
			try {
				System.out.println(name + " is waiting to use the resource.");
				resource.acquire();
				System.out.println(name + " is using the resource.");
				Thread.sleep(3000);
				resource.release();
				System.out.println(name + " has finished using the resource.");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	
}
