package sandbox.lockc.javacert.concurrency;

import java.util.concurrent.Exchanger;

public class ExchangerSynchroniser {

	public static void main(String[] args) throws InterruptedException {
		Exchanger<String> synchroniser = new Exchanger<>();
		UserThread user1 = new UserThread(synchroniser, "Kate");
		UserThread user2 = new UserThread(synchroniser, "Heath");
		
		user1.start();
		Thread.sleep(5000);
		user2.start();
	}

	
	public static class UserThread extends Thread {

		private Exchanger<String> synchroniser;
		private String name;
		
		public UserThread(Exchanger<String> synchroniser, String name) {
			this.synchroniser = synchroniser;
			this.name = name;
		}

		@Override
		public void run() {
			try {
				System.out.println(name + " is waiting to exchange names with somebody");
				String theirName = synchroniser.exchange(name);
				System.out.println(name + " and " + theirName + " have exchanged names.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
