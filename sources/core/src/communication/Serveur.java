package communication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import Outils.ExtractionDonneesFichier;

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
	
	

	@Override
	public void verificationConfiguration() {
		try {
			this.init();
			String dataEnvoyer = ExtractionDonneesFichier.extract("fichierConfiguration.txt");
			
			InputStream in = socketClient.getInputStream();
			BufferedReader buff = new BufferedReader(new InputStreamReader(in));
			
			String dataRecu = buff.readLine();

			dataOutput.writeBytes(dataEnvoyer + "\n");
			dataOutput.close();
			
			if(dataRecu.equals(dataEnvoyer)){
				System.out.println("dataIdentique");
			}
			
			System.out.println("dataEnvoyer: " + dataEnvoyer);
			System.out.println("dataRecu: " + dataRecu);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	

	public static void main(String [] args){
		Ireseau serveur = new Serveur();
		serveur.verificationConfiguration();
		
	}
	
	
}
