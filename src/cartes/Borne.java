package cartes;

public class Borne extends Carte {
	private int km;
	
	public Borne(int kmh) {
		km = kmh;
	}
	
	@Override
	public String toString() {
		return km + " km";
	}	
}
