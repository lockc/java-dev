package lockc.websocket.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class JsrServerConfigurator extends Configurator {

	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        System.out.println("my JsrServerConfigurator is running !!!!!!!!!!!!!!");
        super.modifyHandshake(sec, request, response);        
    }
}
