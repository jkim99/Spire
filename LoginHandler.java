import java.io.*;
import java.util.*;
import com.sun.net.httpserver.*;

public class LoginHandler implements HttpHandler {
	public void handle(HttpExchange he) throws IOException {
		Scanner scan = new Scanner(new File("C:/Users/jonat/Desktop/spire/html/login.html"));
		String response = "";
		while(scan.hasNextLine())
			response += scan.nextLine(); 
		he.sendResponseHeaders(200, response.length());
		OutputStream os = he.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}
}