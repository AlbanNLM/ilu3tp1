package cartes;

public class Configuration {
	Carte carte;
	int nbExemplaires;

	Configuration(Carte carte, int nbExemplaires) {
		this.carte = carte;
		this.nbExemplaires = nbExemplaires;
	}

	public int getNbExemplaires() {
		return nbExemplaires;
	}
	
	public Carte getCarte() {
		return carte;
	}
}
