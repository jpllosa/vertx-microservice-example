package example;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class LogService {

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		
		HttpServer server = vertx.createHttpServer();
	
		Router router = Router.router(vertx);
		
		router.route("/log").handler(routingContext -> {
			
			String mParamValue = routingContext.request().getParam("m");
			String sParamValue = routingContext.request().getParam("s");
			if ((mParamValue != null) && (sParamValue != null)) {
				System.out.println("message: " + mParamValue + ", stacktrace: " + sParamValue);
			}

			HttpServerResponse response = routingContext.response();
			response.end();
		});
	
		server.requestHandler(router::accept).listen(8080);
		System.out.println("Vert.x HTTP server listening at port 8080...");
	}	
}
