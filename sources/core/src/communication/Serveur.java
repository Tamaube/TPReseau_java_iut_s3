package communication;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur  implements Ireseau {
	ServerSocket serverSocket;
	Socket socketClient;
	DataOutputStream dataOutput;
	InputStream input;
	
	public void init() throws IOException{
		serverSocket = new ServerSocket(10666);
		socketClient = serverSocket.accept();
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
			Ireseau serveur = new Serveur();
			serveur.init();
			VerificationFicConf verif = new VerificationFicConfClient();
			verif.init(serveur, "fichierConfiguration.txt");
			verif.donneesSimilaire();
			serveur.closeDataOutput();
			serveur.closeInput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
