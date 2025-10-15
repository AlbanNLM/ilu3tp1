package cartes;

public class JeuDeCartes {
    private Configuration[] configurations;
    private static final int NB_CONFIGURATIONS = 19;
    
    public JeuDeCartes() {
        configurations = new Configuration[NB_CONFIGURATIONS];
        initGame();
    }
    
    private void initGame() {
        int index = 0;
        
        configurations[index++] = new Configuration(new Borne(25), 10);
        configurations[index++] = new Configuration(new Borne(50), 10);
        configurations[index++] = new Configuration(new Borne(75), 10);
        configurations[index++] = new Configuration(new Borne(100), 12);
        configurations[index++] = new Configuration(new Borne(200), 4);
        
        configurations[index++] = new Configuration(new Parade(Type.FEU), 14);
        configurations[index++] = new Configuration(new Parade(Type.ESSENCE), 6);
        configurations[index++] = new Configuration(new Parade(Type.CREVAISON), 6);
        configurations[index++] = new Configuration(new Parade(Type.ACCIDENT), 6);
        
        configurations[index++] = new Configuration(new Attaque(Type.FEU), 5);
        configurations[index++] = new Configuration(new Attaque(Type.ESSENCE), 3);
        configurations[index++] = new Configuration(new Attaque(Type.CREVAISON), 3);
        configurations[index++] = new Configuration(new Attaque(Type.ACCIDENT), 3);
        
        configurations[index++] = new Configuration(new Botte(Type.FEU), 1);
        configurations[index++] = new Configuration(new Botte(Type.ESSENCE), 1);
        configurations[index++] = new Configuration(new Botte(Type.CREVAISON), 1);
        configurations[index++] = new Configuration(new Botte(Type.ACCIDENT), 1);
        
        configurations[index++] = new Configuration(new FinLimite(), 6);
        configurations[index++] = new Configuration(new DebutLimite(), 4);
    }
    
    public String affichageJeuCartes() {
        String resultat = "";
        for (Configuration config : configurations) {
            resultat = resultat + config.getNbExemplaires() + " " + config.getCarte() + "\n";
        }
        return resultat;
    }
    
    public boolean checkCount() {
        int total = 0;
        for (Configuration config : configurations) {
            total += config.getNbExemplaires();
        }
        return total == 106;
    }
    
    public Carte[] donnerCartes() {
        int totalCartes = 0;
        for (Configuration config : configurations) {
            totalCartes += config.getNbExemplaires();
        }
        
        Carte[] cartes = new Carte[totalCartes];
        int index = 0;
        
        for (Configuration config : configurations) {
            for(int i = 0; i < config.getNbExemplaires(); i++) {
                cartes[index++] = config.getCarte();
            }
        }
        
        return cartes;
    }
    
    private static class Configuration {
    	private Carte carte;
    	private int nbExemplaires;

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
}