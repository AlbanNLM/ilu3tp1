package testsFonctionnels;

import java.util.Iterator;

import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Type;
import jeu.Sabot;

public class TestSabot {
    public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();
        Carte[] cartes = jeu.donnerCartes();
        Sabot sabot1 = new Sabot(cartes);
        while (!sabot1.estVide()) {
            Carte carte = sabot1.piocher();
            System.out.println("je pioche " + carte);
        }
        
        Sabot sabot2 = new Sabot(jeu.donnerCartes());
        Iterator<Carte> it = sabot2.iterator();
        while (it.hasNext()) {
            Carte carte = it.next();
            System.out.println("je pioche " + carte);
            it.remove();
        }
        
        try {
            Sabot sabot3 = new Sabot(jeu.donnerCartes());
            Iterator<Carte> it3 = sabot3.iterator();
            while (it3.hasNext()) {
                Carte carte = it3.next();
                System.out.println("je pioche " + carte);
                sabot3.piocher();
                it3.remove();
            }
        } catch (Exception e) {
            System.out.println("Exception attrapee");
        }
        
        try {
            Sabot sabot4 = new Sabot(jeu.donnerCartes());
            sabot4.piocher();
            
            Iterator<Carte> it4 = sabot4.iterator();
            while (it4.hasNext()) {
                Carte carte = it4.next();
                System.out.println("je pioche " + carte);
                sabot4.ajouterCarte(new Botte(Type.FEU));
                it4.remove();
            }
        } catch (Exception e) {
            System.out.println("Exception attrapee");
        }
    }
}