package ihm.reseau;

import com.badlogic.gdx.Gdx;

import Outils.Point;
import monde.Monde;


public class OutilsGraphique {
	static public Point<Float> indiceWindowToIndiceWord(final Point<Float> pointAConvertir, final Monde unMonde) {
		return new Point<Float>(
						pointAConvertir.getX() / Gdx.graphics.getWidth() * unMonde.getWidth(),
						pointAConvertir.getY() / Gdx.graphics.getHeight() * unMonde.getHeight()
					);
	}
}
