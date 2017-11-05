import java.io.*;
import java.util.*;
import com.sun.net.httpserver.*;

public class RootHandler extends Handler implements HttpHandler {

	public RootHandler(File f) {
		super(f);
	}
}