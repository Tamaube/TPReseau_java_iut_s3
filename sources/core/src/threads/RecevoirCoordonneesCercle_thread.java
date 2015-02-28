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
			BufferedReader buff = new BufferedReader(new InputStreamReader(input));
			String ligne;
			ligne = buff.readLine();
	
		float x = Float.parseFloat(ligne.substring(0, ligne.indexOf(',') - 1));
		float y = Float.parseFloat(ligne.substring(0, ligne.indexOf(',') + 1));
		monde.ajoutCercle(new Point<Float>(x,y));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
