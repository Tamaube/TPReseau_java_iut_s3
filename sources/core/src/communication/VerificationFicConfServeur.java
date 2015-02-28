package communication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import Outils.ExtractionDonneesFichier;

public class VerificationFicConfServeur implements VerificationFicConf{
	Ireseau interfaceComunication;
	String nomFichier;
	String dataEnvoyer;
	
	@Override
	public void init(Ireseau interfaceReseau, String nomFichier) {
		// TODO Auto-generated method stub
		interfaceComunication = interfaceReseau;
		this.nomFichier = nomFichier;
	}

	
	private void envoiDesDonnees() throws IOException {
		dataEnvoyer = ExtractionDonneesFichier.extract(nomFichier);
		DataOutputStream out = interfaceComunication.getDataOutput();
		out.writeBytes(dataEnvoyer + "\n");
	}

	private String recuperationDesDonnees() throws IOException {
		InputStream in = interfaceComunication.getInput();
		BufferedReader buff = new BufferedReader(new InputStreamReader(in));
		String ligne;
		String data = "";
		while((ligne = buff.readLine()) != null){
			data+= ligne + "\n";
		}
		System.out.println(data);
		return data;		
	}

	@Override
	public boolean donneesSimilaire() {
		// TODO Auto-generated method stub
		String dataEnvoyer = null;
		String dataRecu = null;
		try {
			
			dataEnvoyer = ExtractionDonneesFichier.extract(nomFichier);
			dataRecu = this.recuperationDesDonnees();
			this.envoiDesDonnees();
			System.out.println("Data recus:\t" + dataRecu);
			System.out.println("Data envoyes:\t" + dataEnvoyer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataEnvoyer.equals(dataRecu);
	}
}
