package example;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;

public class LogService {

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		
		HttpServer server = vertx.createHttpServer();
	
		server.requestHandler(request -> {
			
			String mParamValue = request.getParam("m");
			String sParamValue = request.getParam("s");
			if ((mParamValue != null) && (sParamValue != null)) {
				System.out.println("message: " + mParamValue + ", stacktrace: " + sParamValue);
			}

			HttpServerResponse response = request.response();
			//response.putHeader("content-type", "text/plain");
			response.end();
		});
	
		server.listen(8080);
		System.out.println("Vert.x HTTP server listening at port 8080...");
	}

}
