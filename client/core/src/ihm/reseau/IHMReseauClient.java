package ihm.reseau;

import java.io.IOException;
import java.net.UnknownHostException;

import monde.Element;
import Outils.Point;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;

import communication.Client;
import communication.Ireseau;

public class IHMReseauClient extends ApplicationAdapter {
	
	Ireseau client = new Client();
	AffichageElement affichageCercle;
	
	@Override
	public void create () {
		try {
			client.init(Gdx.graphics.getHeight(),Gdx.graphics.getWidth());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		affichageCercle = new AffichageCercle();
		affichageCercle.init(client.getMonde());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
		affichageCercle.begin();
		for(Element<Float> cercle: client.getMonde().getCercles()){
			affichageCercle.affiche(cercle);
		}
		affichageCercle.end();
		
		Gdx.input.setInputProcessor(new InputAdapter() {
			public boolean touchDown(int x, int y, int pointer, int button) {
				if (button == Input.Buttons.LEFT) {
					Point<Float> position = new Point<Float>((float) x, (float) Gdx.graphics.getHeight() - y);
					try {
						client.envoiCoordonnees(position);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				return true;
			}
		});
		
	}
}