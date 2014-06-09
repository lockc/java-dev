package lockc.websocket.example;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.eclipse.jetty.websocket.jsr356.ClientContainer;

@ClientEndpoint
public class MyClientEndpoint {

	@OnOpen
	public void onOpen(Session session )  {
		System.out.println("client onOpen executed.");
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("client onMessage executed.");
	}
	
	@OnError
	public void onError(Throwable error, Session session) {
		System.out.println("client onError executed.");
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("client onClose executed.");
	}
	
	public static void main(String[] args) throws Exception {
		
		WebSocketContainer container = ContainerProvider.getWebSocketContainer(); 
		
		final String uri = "ws://localhost:8080/hello";
		
		Session session = container.connectToServer(MyClientEndpoint.class, URI.create(uri));
		
		for(int x = 0; x < 100; x++) {
			session.getBasicRemote().sendText("err what!? " + x);
			Thread.sleep(1000);
		}
			
		
		( ( ClientContainer )container ).stop();
		
	}
}
