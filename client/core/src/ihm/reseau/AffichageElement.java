package ihm.reseau;

import monde.Element;



public interface AffichageElement {
	void begin();
	void end();
	void affiche(final Element<Float> element);
	void init();
}
