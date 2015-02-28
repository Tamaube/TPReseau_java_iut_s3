package monde;

import Outils.Point;

public class Cercle implements Element<Float> {
	private Point<Float> position;
	public static float taille = 10;
	
	public Cercle (Point<Float> position){
		this.position = position;
	}

	public Point<Float> getCoordonnees() {
		return position;
	}

	@Override
	public void setCoordonnees(Point<Float> desCoordonnees) {
		// TODO Auto-generated method stub
		position = desCoordonnees;
	}
	
}
