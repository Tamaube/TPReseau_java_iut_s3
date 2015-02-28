package ihm.reseau;


import monde.Element;
import monde.Monde;
import Outils.Point;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;


public class IHMReseau extends ApplicationAdapter {
	Monde monde;
	AffichageElement affichageCercle;
	
	@Override
	public void create () {
		monde = new Monde(Gdx.graphics.getHeight(),Gdx.graphics.getWidth());
		affichageCercle = new AffichageCercle();
		affichageCercle.init(monde);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
		affichageCercle.begin();
		for(Element<Float> cercle: monde.getCercles()){
			affichageCercle.affiche(cercle);
		}
		affichageCercle.end();
		
		Gdx.input.setInputProcessor(new InputAdapter() {
			public boolean touchDown(int x, int y, int pointer, int button) {
				if (button == Input.Buttons.LEFT) {
					Point<Float> position = new Point<Float>((float) x, (float) Gdx.graphics.getHeight() - y);
					monde.ajoutCercle(position);
				}

				return true;
			}
		});
		
	}
	
}
