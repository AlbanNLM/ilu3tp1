package jeu;

import cartes.Carte;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class Sabot implements Iterable<Carte> {
    private Carte[] cartes;
    private int nbCartes;
    private int modCount;
    
    public Sabot(Carte[] cartesJeu) {
        this.cartes = cartesJeu;
        this.nbCartes = cartesJeu.length;
        this.modCount = 0;
    }
    
    public boolean estVide() {
        return nbCartes == 0;
    }
    
    public void ajouterCarte(Carte carte) {
        if (nbCartes >= cartes.length) {
            throw new ArrayIndexOutOfBoundsException("depassement de capacite");
        }
        cartes[nbCartes++] = carte;
        modCount++;
    }
    
    public Carte piocher() {
        if (estVide()) {
            throw new NoSuchElementException("le sabot est vide");
        }
        
        Iterator<Carte> it = iterator();
        Carte carte = it.next();
        it.remove();
        return carte;
    }
    
    @Override
    public Iterator<Carte> iterator() {
        return new IterateurSabot();
    }
    
    private class IterateurSabot implements Iterator<Carte> {
        private int indiceIterateur = 0;
        private boolean nextEffectue = false;
        private int modCountAttendu = modCount;
        
        @Override
        public boolean hasNext() {
            return indiceIterateur < nbCartes;
        }
        
        @Override
        public Carte next() {
            verifierConcurrence();
            if (!hasNext()) {
                throw new NoSuchElementException("limite des cartes atteinte");
            }
            nextEffectue = true;
            return cartes[indiceIterateur++];
        }
        
        @Override
        public void remove() {
            verifierConcurrence();
            if (!nextEffectue) {
                throw new IllegalStateException("next non effectue");
            }
            
            for (int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
                cartes[i] = cartes[i + 1];
            }
            
            cartes[nbCartes - 1] = null;
            nbCartes--;
            indiceIterateur--;
            nextEffectue = false;
            modCount++;
            modCountAttendu++;
        }
        
        private void verifierConcurrence() {
            if (modCount != modCountAttendu) {
                throw new ConcurrentModificationException();
            }
        }
    }
}