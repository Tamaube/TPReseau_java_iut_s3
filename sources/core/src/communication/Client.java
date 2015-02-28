package communication;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Ireseau {
	Socket socketClient;
	DataOutputStream dataOutput;
	InputStream input;
	
	
	public void init() throws UnknownHostException, IOException{
		socketClient = new Socket("127.0.0.1",10666);
		dataOutput = new DataOutputStream(socketClient.getOutputStream());
		input = socketClient.getInputStream();
	}
	
	
	@Override
	public DataOutputStream getDataOutput() {
		// TODO Auto-generated method stub
		return dataOutput;
	}

	@Override
	public InputStream getInput() {
		// TODO Auto-generated method stub
		return input;
	}

	@Override
	public void closeDataOutput() throws IOException {
		// TODO Auto-generated method stub
		dataOutput.close();
		
	}

	@Override
	public void closeInput() throws IOException {
		// TODO Auto-generated method stub
		input.close();
	}
	
	public static void main(String [] args){
		try {
			Ireseau client = new Client();
			client.init();
			VerificationFicConf verif = new VerificationFicConfClient();
			verif.init(client, "fichierConfiguration.txt");
			verif.donneesSimilaire();
			client.closeDataOutput();
			client.closeInput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
