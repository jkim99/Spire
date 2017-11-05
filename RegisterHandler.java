import java.io.*;
import java.util.*;
import com.sun.net.httpserver.*;

public class RegisterHandler extends Handler implements HttpHandler {
	public RegisterHandler(File f) {
		super(f);
	}
}
