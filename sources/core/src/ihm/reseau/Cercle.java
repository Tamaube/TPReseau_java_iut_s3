package ihm.reseau;

import Outils.Point;

public class Cercle {
	private Point<Float> position;
	public static float taille = 10;
	
	public Cercle (Point<Float> position){
		this.position = position;
	}

	public Point<Float> getPosition() {
		return position;
	}
	
}
