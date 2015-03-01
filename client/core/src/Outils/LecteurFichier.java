package Outils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class LecteurFichier {
	private  BufferedReader buffer;
	
	public LecteurFichier(String filePath){
		try {
			this.buffer = new BufferedReader(new FileReader
													(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Collection<String> getAllContenuFichier() throws IOException{
		Collection<String> contenuFichier = new ArrayList<String>();
		String ligne;
		while((ligne = buffer.readLine()) != null){
			contenuFichier.add(ligne);
		}
		return contenuFichier;
	}
}
