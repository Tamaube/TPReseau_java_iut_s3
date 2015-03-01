package monde;

import java.util.Collection;
import java.util.LinkedList;

import Outils.Point;

public class Monde {
	protected int hauteur, largeur;
	final Collection<Cercle> collCercle;
	
	public Monde(int hauteur, int largeur){
		this.hauteur = hauteur;
		this.largeur = largeur;
		collCercle = new LinkedList<Cercle>();
	}
	
	public int getHeight() {
		return hauteur;
	}

	public int getWidth() {
		return largeur;
	}
	
	
	public Collection<Cercle> getCercles()
	{
		return collCercle;
	}
	
	public void ajoutCercle(Point<Float> position)
	{
		collCercle.add(new Cercle(position));
	}
}
