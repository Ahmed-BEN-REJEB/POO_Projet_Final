import java.util.Set;

public class Personne {
    //Définition des attributs
    private String nom;
    private String prenom;
    private Sensibilite sensibilite;
    private int abcisse;
    private int ordonnee;
    private int dureeRemission;
    private Set<Comportement> comportements;
    private Set<Vaccination> vaccinations;

    //Définition du constructeur de la classe "Personne"
    public Personne(String nom,
                    String prenom,
                    Sensibilite sensibilite,
                    int abscisse,
                    int ordonnee,
                    int dureeRemission,
                    Set<Comportement> comportements) {
        this.nom = nom;
        this.prenom = prenom;
        this.sensibilite = sensibilite;
        this.abcisse= abscisse;
        this.ordonnee= ordonnee;
        this.dureeRemission = dureeRemission;
        this.comportements = comportements;
    }

    //Retourner la distance séparant cette personne à une autre personne donnée
    public int getDistance(Personne personne) {
        int distance = Math.abs(this.abcisse - personne.abcisse) + Math.abs(this.ordonnee - personne.ordonnee);

        if (comportements.contains(Comportement.DistanciationSociale)) {
            return distance * 2;
        } else {
            return distance;
        }
    }


    //Méthode permettant de faire vacciner une personne, si possible 
    public void seFaireVacciner(Vaccin vaccin) {
        if (vaccinations.size() != 0) {
            for (Vaccination vaccination : vaccinations) {
                if (vaccination.getVaccin().equals(vaccin)) {
                    if (vaccin.getType() == TypeVaccin.Unidose) {
                        throw new IllegalStateException("Ce vaccin ne nécessite qu'une seule dose.");
                    } else if (vaccination.getNbDosesPrises() == 2) {
                        throw new IllegalStateException("Cette personne à déjà reçu les deux doses de ce vaccin.");
                    } else {
                        vaccination.faireDeuxiemeDose();
                    }
                }
            }
        }
        else
            vaccinations.add(new Vaccination(vaccin, this));
    }

    //Retourner l'ensemble des vaccinations effectuées par une personne
    public Set<Vaccination> getVaccinations() {
        return vaccinations;
    }
}
