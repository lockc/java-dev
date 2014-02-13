package lockc.java.examples.sws;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHttpServer {

	private final ServerSocketListener serverSocketListener;
	private final ExecutorService workerPool;
	private ExecutorService internalPool = Executors.newFixedThreadPool(2);
	private volatile boolean shutdownHook;
	
	public SimpleHttpServer(int port, int maxQueueSize, int poolsize) throws IOException {
		serverSocketListener = new ServerSocketListener(port, maxQueueSize);
		workerPool = Executors.newFixedThreadPool(poolsize);
		shutdownHook = true;
	}
	
	public void start() throws Exception {
		internalPool.execute(serverSocketListener);
		
		internalPool.execute(new Runnable() {
			
			public void run() {
				while(shutdownHook) {
					try {
						dispatch(serverSocketListener.getNextRequest());
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
	}
	
	public void stop() throws IOException {
		shutdownHook = false;
		serverSocketListener.stop();
		internalPool.shutdownNow();
		workerPool.shutdownNow();
	}
	
	private void dispatch(final Socket socket) throws IOException {
		workerPool.execute(new Runnable() {
			public void run() {
				byte[] buffer = new byte[1024];
				try {
					DataInputStream dis = new DataInputStream(socket.getInputStream());
					while(dis.available() > 0) {
						dis.read(buffer);
					}
					String requestData = new String(buffer);
					
					HttpRequest request = HttpRequest.parse(requestData);
					
					
					
					socket.getOutputStream().write("<html><body>Hello World!</body></html>".getBytes());
			        
					
			        socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}  
				
			}
		});
	}

}
