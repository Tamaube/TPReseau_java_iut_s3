package Outils;

import java.io.IOException;
import java.util.Collection;

public class ExtractionDonneesFichier {
	public static String extract(String nomFic) throws IOException
	{
		String donneesFichier = "";
		LecteurFichier lecteurFic = new LecteurFichier(nomFic);
		Collection<String> donneesEnListe = lecteurFic.getAllContenuFichier();
		for(String ligne : donneesEnListe)
		{
			donneesFichier += ligne + " ";
		}
		return donneesFichier;
	}
}
