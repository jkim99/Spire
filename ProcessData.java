import java.util.*;
import java.io.*;
import java.net.*;

import com.sun.net.httpserver.*;

public class ProcessData {

	public static void main(String args[]) throws Exception {
		int port = 4444;
		HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
		System.out.println("server started at " + port);
		server.createContext("/", new RootHandler(new File("html/index.html")));
		server.createContext("/login", new LoginHandler(new File("html/login.html")));
		server.createContext("/lJn2Fv", new LoginHandler(new File("html/lJn2Fv.html")));
		server.createContext("/acc", new LoginHandler(new File("html/acc.html")));
		server.createContext("/cocat", new LoginHandler(new File("html/cocat.html")));
		server.createContext("/cohis", new LoginHandler(new File("html/cohis.html")));
		server.createContext("/gened", new LoginHandler(new File("html/gened.html")));
		server.createContext("/info", new LoginHandler(new File("html/info.html")));
		server.createContext("/search", new LoginHandler(new File("html/search.html")));
		server.createContext("/services", new LoginHandler(new File("html/services.html")));
		server.setExecutor(null);
		server.start();
	}

	
}

//class name
//class number
//class description
//gen eds
//major minor
//pre requisites