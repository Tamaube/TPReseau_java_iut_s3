package communication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;




import monde.Monde;
import threads.RecevoirCoordonneesCercle_thread;
import Outils.ExtractionDonneesFichier;
import Outils.Point;

public class Client implements Ireseau {
	Socket socketClient;
	DataOutputStream dataOutput;
	InputStream input;
	Monde monde;
	boolean canStart;
	Thread recuCoordThread;
	
	public void init(int hauteur, int largeur) throws UnknownHostException, IOException{
		socketClient = new Socket("127.0.0.1",10666);
		dataOutput = new DataOutputStream(socketClient.getOutputStream());
		input = socketClient.getInputStream();
		monde = new Monde( hauteur, largeur);
		
		recuCoordThread = new RecevoirCoordonneesCercle_thread(this.input, this.monde);
		
		canStart = verificationConfiguration();
		if (canStart) {
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


	public boolean verificationConfiguration()
	{
		boolean dataIdentique =false;
		try {
			String dataEnvoyer = ExtractionDonneesFichier.extract("fichierConfiguration.txt");
			this.dataOutput.writeBytes(dataEnvoyer + "\n");
			
			InputStream in = socketClient.getInputStream();
			BufferedReader buff = new BufferedReader(new InputStreamReader(in));
			String dataRecu = buff.readLine();
			
			dataIdentique = dataRecu.equals(dataEnvoyer);
//			if(dataRecu.equals(dataEnvoyer)){
//				System.out.println("dataIdentique");
//			}
//			System.out.println("dataEnvoyer: " + dataEnvoyer);
//			System.out.println("dataRecu: " + dataRecu);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataIdentique;
	}
	
	public Monde getMonde() {
		return monde;
	}
	
	public void envoiCoordonnees(Point<Float> position) throws IOException{
		dataOutput.writeBytes(position.getX() + ":" + position.getY() + "\n");
	}
	
	@Override
	public void renouvelerReception() {
		// TODO Auto-generated method stub
		if (canStart && this.recuCoordThread.getState() == Thread.State.TERMINATED)
		{
			this.recuCoordThread.start();
		}
	}


}
