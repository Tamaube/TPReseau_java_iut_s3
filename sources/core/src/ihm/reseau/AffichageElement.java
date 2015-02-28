package ihm.reseau;

import monde.Element;
import monde.Monde;



public interface AffichageElement {
	void begin();
	void end();
	void affiche(final Element<Float> element);
	void init(final Monde monde);
}
