package lockc.java.examples.sws;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.net.ServerSocketFactory;

public class ServerSocketListener implements Runnable {

	private final ServerSocket serverSocket;
	
	private final LinkedBlockingQueue<Socket> requestQueue;
		
	private volatile boolean shutdownHook;
	
	public ServerSocketListener(int port, int maxQueueSize) throws IOException {
		serverSocket = ServerSocketFactory.getDefault().createServerSocket(port);
		requestQueue = new LinkedBlockingQueue<Socket>(maxQueueSize);
		shutdownHook = true;	
	}
	
	public void run() {
		while(shutdownHook) {
			try {
				Socket socket = serverSocket.accept();
				InetAddress client = socket.getInetAddress();
		        System.out.println(client.getHostName() + " connected to server. " + socket.getPort() + "\n");
		        
		        if(!requestQueue.offer(socket)) {
		        	throw new RuntimeException("Server Busy!");
		        }
			} catch (IOException e) {
				if(shutdownHook) {
					e.printStackTrace();
				} else {
					System.out.println("Server was shutdown, no longer accepting connections.");
				}
			}
			
		}
	}
	
	public void stop() throws IOException {
		shutdownHook = false;
		serverSocket.close();
		requestQueue.drainTo(new ArrayList<Socket>());
	}
	
	public Socket getNextRequest() throws InterruptedException {
		return requestQueue.take();
	}

}
