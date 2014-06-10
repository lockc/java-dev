package lockc.websocket.example;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.CloseReason.CloseCodes;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(value = "/hello/jsr", configurator=JsrServerConfigurator.class)
public class JsrServerEndpoint {

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("onOpen executed.");
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("onClose executed.");
	}
	
	@OnMessage()
	public void onMessage(String message, Session session) throws IOException {
		System.out.println("onMessage executed: " + message);
		session.getBasicRemote().sendText("hello there!!");
		session.close(new CloseReason(CloseCodes.NORMAL_CLOSURE, "Bye bye."));
	}
	
	@OnError
	public void onError(Throwable error, Session session) {
		System.out.println("onError executed.");
	}
	
}
