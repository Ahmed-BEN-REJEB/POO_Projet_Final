import java.lang.reflect.Array;
import java.util.*;

public class Espace {

    //Définition des différents attributs nécessaires
    private final int longeur;
    private final int largeur;
    private int nbPersonnes=0;
    private ArrayList<Personne> personnes;

    //Définition du constructeur de cette classe
    public Espace(int longeur, int largeur, ArrayList<Personne> personnes) {
        this.longeur = longeur;
        this.largeur = largeur;
        this.personnes= personnes;
        this.nbPersonnes= personnes.size();
    }

    //Définition des Getters
    //Permet de retourner le nombre d'individus dans une population
    public int getNbPersonnes(){
        return this.nbPersonnes;
    }

    //Définition d'une méthode permettant d'ajouter une nouvelle personne à l'espace,
    //tout en mettant à jour le nombre d'individus suite à l'ajout
    public void ajoutPersonne(Personne p){
        personnes.add(p);
        this.nbPersonnes++;
    }

    //Définition de la méthode permettant d'accéder aux vaccination(s) d'une personne
    public Set<Vaccination> getVaccinations_Personne(Personne personne) throws IllegalArgumentException{
        //Vérifier si la liste de personnes n'est pas vide
        if(personnes.size() != 0){
            boolean testExistencePersonne= false;
            for(Personne p : personnes){
                if(p.equals(personne)) {
                    testExistencePersonne= true;
                }
            }
            if (!testExistencePersonne) {
                throw new IllegalArgumentException("Cette personne ne fait pas partie de cette espace");
            }
            for(Personne p : personnes){
                if (p.equals(personne)){
                    return p.getVaccinations();
                }
            }
        }
        return null;
    }

    //Définition d'une méthode vérifiant si une personne a effectué une vaccination par un vaccin spécifique
    public boolean verifExistenceVaccin(Vaccin vaccin, Vaccination vaccination){
        if(vaccination.getVaccin().equals(vaccin)){
            return true;
        } 
        return false;
    }

    //Définition d'une méthode permettant d'accéder à une vaccination d'une personne donnée, en faisant recours aux méthodes préalablement définies
    public Vaccination getVaccination_Personne(Personne personne, Vaccin vaccin) throws IllegalArgumentException{
        Set<Vaccination> vaccinations= getVaccinations_Personne(personne);
        if(vaccinations != null){
            boolean verifierExistenceVaccin=false;
            for(Vaccination v : vaccinations){
                verifierExistenceVaccin= verifExistenceVaccin(vaccin, v);
                if (verifierExistenceVaccin) {
                    break;
                }
            }
            if (!verifierExistenceVaccin) {
                throw new IllegalArgumentException("Ce vaccin n'est pas utilisé par cette personne");
            }
            
            for(Vaccination v : vaccinations){
                if (v.getVaccin().equals(vaccin)) {
                    return v;
                }
            }
        }
        return null;
    }

    //Définition d'une méthode permettant de savoir le nombre de doses effectués pour une vaccination spécifique d'une personne, en faisant recours à la méthode getVaccination_Personne()
    public int getNbDosesPrises_Personne(Personne p, Vaccin v){
        Vaccination vaccination= getVaccination_Personne(p, v);
        if (vaccination == null) {
            throw new IllegalArgumentException("Il n'existe pas de vaccination pour la combinaison d'arguments donnés");
        }
        return vaccination.getNbDosesPrises();
    }

}
