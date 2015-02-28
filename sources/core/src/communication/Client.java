package communication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


import Outils.ExtractionDonneesFichier;

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
	
	public void verificationConfiguration()
	{
		try {
			this.init();
			String dataEnvoyer = ExtractionDonneesFichier.extract("fichierConfiguration.txt");
			this.dataOutput.writeBytes(dataEnvoyer + "\n");
			
			InputStream in = socketClient.getInputStream();
			BufferedReader buff = new BufferedReader(new InputStreamReader(in));
			String dataRecu = buff.readLine();
	
			if(dataRecu.equals(dataEnvoyer)){
				System.out.println("dataIdentique");
			}
			System.out.println("dataEnvoyer: " + dataEnvoyer);
			System.out.println("dataRecu: " + dataRecu);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	public static void main(String [] args){
		Ireseau client = new Client();
		client.verificationConfiguration();
		
	}


}
