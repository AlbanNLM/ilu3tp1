package cartes;

public class JeuDeCartes {
    private Configuration[] configurations = new Configuration[] {
                new Configuration(new Borne(25), 10),
                new Configuration(new Borne(50), 10),
                new Configuration(new Borne(75), 10),
                new Configuration(new Borne(100), 12),
                new Configuration(new Borne(200), 4),
                
                new Configuration(new Parade(Type.FEU), 14),
                new Configuration(new Parade(Type.ESSENCE), 6),
                new Configuration(new Parade(Type.CREVAISON), 6),
                new Configuration(new Parade(Type.ACCIDENT), 6),
                
                new Configuration(new Attaque(Type.FEU), 5),
                new Configuration(new Attaque(Type.ESSENCE), 3),
                new Configuration(new Attaque(Type.CREVAISON), 3),
                new Configuration(new Attaque(Type.ACCIDENT), 3),
                
                new Configuration(new Botte(Type.FEU), 1),
                new Configuration(new Botte(Type.ESSENCE), 1),
                new Configuration(new Botte(Type.CREVAISON), 1),
                new Configuration(new Botte(Type.ACCIDENT), 1),
                
                new Configuration(new FinLimite(), 6),
                new Configuration(new DebutLimite(), 4)
        };

    
    public String affichageJeuCartes() {
        StringBuilder resultat = new StringBuilder();
        for (Configuration config : configurations) {
            resultat.append(config.getNbExemplaires()).append(" ").append(config.getCarte()).append("\n");
        }
        return resultat.toString();
    }
    
    public boolean checkCount() {
        int total = 0;
        for (Configuration config : configurations) {
            total += config.getNbExemplaires();
        }
        return total == 106;
    }
    
    public Carte[] donnerCartes() {
    	int nbCartes = 0;
    	for (Configuration config : configurations) {
    		nbCartes += config.getNbExemplaires();
    	}
    	
        Carte[] cartes = new Carte[nbCartes];
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

    	private Configuration(Carte carte, int nbExemplaires) {
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