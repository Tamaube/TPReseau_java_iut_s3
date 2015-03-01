package monde;

import Outils.Point;

public interface Element<Type extends Number> {
	public Point<Type> getCoordonnees();
	public void setCoordonnees(final Point<Type> desCoordonnees);
}
