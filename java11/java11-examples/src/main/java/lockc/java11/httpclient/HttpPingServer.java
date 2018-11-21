package lockc.java11.httpclient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

import com.sun.net.httpserver.HttpServer;

/**
 *
 */
public class HttpPingServer {

	private HttpServer httpServer;

	public HttpPingServer() throws IOException {

		httpServer = HttpServer.create( new InetSocketAddress( "localhost", 8082 ), 0 );
		httpServer.createContext( "/ping", exchange -> {

			byte[] bytes = exchange.getRequestBody().readAllBytes();
			String requestBody = new String( bytes, "UTF-8" );
			System.out.println( "Request Body: " + requestBody );

			exchange.getResponseHeaders().set( "Content-Type", "text/plain" );
			exchange.getResponseHeaders().set( "Content-Length", "2" );
			exchange.getResponseHeaders().set( "encoding", "UTF-8" );
			exchange.sendResponseHeaders( 200, 2 );

			exchange.getResponseBody().write( "OK" .getBytes( "UTF-8" ) );
			exchange.getResponseBody().flush();
			exchange.getResponseBody().close();

			exchange.close();
		} );
	}

	public void start() {
		httpServer.start();
	}

	public void stop() {
		httpServer.stop( 0 );
	}

	public String getPingUrl() {
		String host = httpServer.getAddress().getHostName();
		int port = httpServer.getAddress().getPort();
		return "http://" + host + ":" + port + "/ping";
	}
}
