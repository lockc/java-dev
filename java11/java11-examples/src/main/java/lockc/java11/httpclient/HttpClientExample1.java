package lockc.java11.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 *
 */
public class HttpClientExample1 {

	public static void main(String[] args) throws Exception {

		HttpClient client = HttpClient.newBuilder().build();

		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri( URI.create( "http://bluebox:8080/queue-service/ping" ) )
				.GET()
				.build();

		HttpResponse<String> send = client.send( httpRequest, BodyHandlers.ofString() );

		String body = send.body();
		System.out.println( body );

	}

}
