package communication;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;

import monde.Monde;
import Outils.Point;

public interface Ireseau {
	public DataOutputStream getDataOutput();
	public InputStream getInput();

	public void init(int hauteur, int largeur) throws IOException, UnknownHostException;
	public boolean verificationConfiguration();
	public void envoiCoordonnees(Point<Float> position) throws IOException;
	
	
	public Monde getMonde();
}
