import java.io.*;
import java.util.*;
import com.sun.net.httpserver.*;

public class Handler implements HttpHandler {

	private File file;

	public Handler(File f) {
		file = f;
	}

	public void handle(HttpExchange he) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		OutputStream os = he.getResponseBody();
		he.sendResponseHeaders(200, 0);
		while((line = br.readLine()) != null) {
			if(line.contains("static/") && (line.contains(".css") || line.contains(".js"))) {
				int firstIndex = line.indexOf("static/");
				int secondIndex = (line.contains(".css") ? line.indexOf(".css") : line.indexOf(".js")) + 4;
				System.out.println("<style>" + getCSSCode(line.substring(firstIndex, secondIndex)) + "</style>");
				os.write(("<style>" + getCSSCode(line.substring(firstIndex, secondIndex)) + "</style>").getBytes());
			}
			else {
				System.out.println(line);
				os.write(line.getBytes());
			}
		}
		
		os.close();
	}

	public String getCSSCode(String x) throws IOException {
		Scanner scan = new Scanner(new File("C:/Users/jonat/Desktop/spire/html/" + x));
		String ret = "";
		while(scan.hasNextLine())
			ret += scan.nextLine();
		return ret;
	}
}
