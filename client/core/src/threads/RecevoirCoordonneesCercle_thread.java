package threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import Outils.Point;
import monde.Monde;

public class RecevoirCoordonneesCercle_thread extends Thread {
	InputStream input;
	Monde monde;
	
	public RecevoirCoordonneesCercle_thread(InputStream in, Monde monde){
		input = in;
		this.monde = monde;
	}
	
	public void run()
	{
		try {
			while(true)
			{
				BufferedReader buff = new BufferedReader(new InputStreamReader(input));
				String ligne;
				ligne = buff.readLine();
				
				if (ligne !=null)
				{
					float x = Float.parseFloat(ligne.substring(0, ligne.indexOf(':')));
					float y = Float.parseFloat(ligne.substring(ligne.indexOf(':') + 1, ligne.length()));
					monde.ajoutCercle(new Point<Float>(x,y));
					this.interrupt();
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
