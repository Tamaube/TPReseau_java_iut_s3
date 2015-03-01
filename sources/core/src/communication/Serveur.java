package communication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import threads.RecevoirCoordonneesCercle_thread;
import monde.Monde;
import Outils.ExtractionDonneesFichier;
import Outils.Point;

public class Serveur  implements Ireseau {
	ServerSocket serverSocket;
	Socket socketClient;
	DataOutputStream dataOutput;
	InputStream input;
	Monde monde;

	
	public void init(int hauteur, int largeur) throws IOException{
		serverSocket = new ServerSocket(10666);
		socketClient = serverSocket.accept();
		dataOutput = new DataOutputStream(socketClient.getOutputStream());
		input = socketClient.getInputStream();
		monde = new Monde( hauteur, largeur);
		
		Thread recuCoordThread = new RecevoirCoordonneesCercle_thread(this.input, this.monde);
		
		if (verificationConfiguration())
		{
			recuCoordThread.start();
		}
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


	public Monde getMonde() {
		return monde;
	}

	@Override
	public boolean verificationConfiguration() {
		boolean dataIdentique =false;
		try {
			String dataEnvoyer = ExtractionDonneesFichier.extract("fichierConfiguration.txt");
			
			InputStream in = socketClient.getInputStream();
			BufferedReader buff = new BufferedReader(new InputStreamReader(in));
			
			String dataRecu = buff.readLine();

			dataOutput.writeBytes(dataEnvoyer + "\n");

			dataIdentique = dataRecu.equals(dataEnvoyer);
//			if(dataRecu.equals(dataEnvoyer)){
//				System.out.println("dataIdentique");
//			}
			
//			System.out.println("dataEnvoyer: " + dataEnvoyer);
//			System.out.println("dataRecu: " + dataRecu);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataIdentique;
	}
	
	
	public void envoiCoordonnees(Point<Float> position) throws IOException{
		dataOutput.writeBytes(position.getX() + ":" + position.getY() + "\n");
	}
	

	public static void main(String [] args){
		Ireseau serveur = new Serveur();
		serveur.verificationConfiguration();
		
	}
	
	
}
