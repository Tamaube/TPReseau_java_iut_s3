package ihm.reseau;

import java.util.ArrayList;
import java.util.Collection;

import Outils.Point;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class IHMReseau extends ApplicationAdapter {
	ShapeRenderer shape;
	Collection<Cercle> liseDeCercleRecu;
	
	@Override
	public void create () {
		shape = new ShapeRenderer();
		this.liseDeCercleRecu = new ArrayList<Cercle>();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		
		
		Gdx.input.setInputProcessor(new InputAdapter() {
			public boolean touchDown(int x, int y, int pointer, int button) {
				if (button == Input.Buttons.LEFT) {
					Point<Float> position = new Point<Float>((float) x, (float) Gdx.graphics.getHeight() - y);
					liseDeCercleRecu.add(new Cercle(position));
				}

				return true;
			}
		});
		
		this.drawCirles();
		
	}
	
	public void drawCirles()
	{
		shape.begin(ShapeType.Filled);
		shape.setColor(Color.BLUE);
		for(Cercle c : this.liseDeCercleRecu){
			
			shape.circle(c.getPosition().getX(), c.getPosition().getY(), 10);
			
		}
		shape.end();
	}
}
