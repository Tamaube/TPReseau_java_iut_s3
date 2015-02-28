package communication;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;

public interface Ireseau {
	public DataOutputStream getDataOutput();
	public InputStream getInput();
	
	public void closeDataOutput () throws IOException;
	public void closeInput() throws IOException;
	public void init() throws IOException, UnknownHostException;
}
