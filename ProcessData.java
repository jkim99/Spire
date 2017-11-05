import java.util.*;
import java.io.*;
import java.net.*;

import com.sun.net.httpserver.*;

public class ProcessData {

	public static void main(String args[]) throws Exception {
		int port = 4444;
		HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
		System.out.println("server started at " + port);
		server.createContext("/", new RootHandler());
		server.createContext("/login", new LoginHandler());
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