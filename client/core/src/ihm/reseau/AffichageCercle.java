package ihm.reseau;

import monde.Cercle;
import monde.Element;
import monde.Monde;
import Outils.Point;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class AffichageCercle implements AffichageElement {
	private ShapeRenderer shapeRenderer ;
	private Monde monde;
	
	@Override
	public void init(Monde unMonde) {
		// TODO Auto-generated method stub
		monde = unMonde;
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
		shapeRenderer.circle(pt.getX()/monde.getWidth()*Gdx.graphics.getWidth(), pt.getY()/monde.getHeight()*Gdx.graphics.getHeight(), Cercle.taille);		
	}
	
}
