import java.io.*;
import java.util.*;
import com.sun.net.httpserver.*;

public class LoginHandler extends Handler implements HttpHandler {
	public LoginHandler(File f) {
		super(f);
	}
}
