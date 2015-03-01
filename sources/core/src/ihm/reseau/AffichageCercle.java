package ihm.reseau;

import monde.Cercle;
import monde.Element;
import Outils.Point;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class AffichageCercle implements AffichageElement {
	private ShapeRenderer shapeRenderer ;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub

		shapeRenderer  = new ShapeRenderer();
	}
	
	@Override
	public void begin() {
		// TODO Auto-generated method stub
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.BLUE);
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method
		shapeRenderer.end();
		
		
	}

	@Override
	public void affiche(Element<Float> element) {
		// TODO Auto-generated method stub
		Point<Float> pt = element.getCoordonnees();
		shapeRenderer.circle(pt.getX(), pt.getY(), Cercle.taille);		
	}
	
}
