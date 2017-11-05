import java.io.*;
import java.util.*;
import java.net.*;
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

	public void parseQuery(String query, Map<String, Object> parameters) throws UnsupportedEncodingException {
		if(query != null) {
			String pairs[] = query.split("[&]");
			for(String pair : pairs) {
				String param[] = pair.split("[=]");
				String key = null;
				String value = null;
				if(param.length > 0) {
					key = URLDecoder.decode(param[0], 
					System.getProperty("file.encoding"));
				}

				if(param.length > 1) {
					value = URLDecoder.decode(param[1], 
					System.getProperty("file.encoding"));
				}

				if(parameters.containsKey(key)) {
					Object obj = parameters.get(key);
					if(obj instanceof List<?>) {
						List<String> values = (List<String>) obj;
						values.add(value);
					}
					else if(obj instanceof String) {
						List<String> values = new ArrayList<String>();
						values.add((String) obj);
						values.add(value);
						parameters.put(key, values);
					}
				}
				else {
					parameters.put(key, value);
				}
			}
		}
	}
}
