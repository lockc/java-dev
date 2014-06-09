package lockc.websocket.example;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

@SuppressWarnings("serial")
public class MyWebSocketServlet extends WebSocketServlet {

	@Override
	public void configure(WebSocketServletFactory factory) {
		
		factory.getPolicy().setIdleTimeout(10000);
        factory.register(MyServerEndpoint.class);
	}

}
