package lockc.java11.httpclient;

import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.sun.net.httpserver.HttpServer;

/**
 *
 */
public class HttpClientExample1 {

	public static void main( String[] args ) throws Exception {

		HttpPingServer httpPingServer = new HttpPingServer();

		try {
			httpPingServer.start();

			HttpClient client = HttpClient.newBuilder().build();

			HttpRequest httpRequest = HttpRequest.newBuilder()
					.uri( URI.create( httpPingServer.getPingUrl() ) )
					.GET()
					.build();

			HttpResponse<String> send = client.send( httpRequest, BodyHandlers.ofString() );

			String body = send.body();
			System.out.println( body );

		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			httpPingServer.stop();
		}
	}

}
