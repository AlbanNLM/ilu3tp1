package ilu3tp1;

public abstract class Probleme extends Carte {
	Type type;
	
	protected Probleme(Type typePb) {
		type = typePb;
	}
	
	public Type getType() {
		return type;
	}

}
