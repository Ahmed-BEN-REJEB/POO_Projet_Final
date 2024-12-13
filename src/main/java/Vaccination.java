public class Vaccination {
    
    //TODO: Ajouter l'accès à un vaccin d'une personne
    //On peut accéder à la (ou aux différentes) vaccination(s) d'une personne spécifique à partir de la classe "Personne"
    //et ce, à travers l'attribut "vaccinations" que possède cette personne
    //Sinon, si on veut accéder aux différentes vaccinations d'une personne spécifique, 
    //on peut faire recours à la classe "Espace" pour implémenter ceci (voir classe "Espace")


    //Définition des attributs nécessaires
    private int nbDosesPrises;
    //Le vaccin concerné par une vaccination
    private final Vaccin vaccin;
    //La personne qui peut subir un vaccin
    private final Personne personne;

    //Définition du constructeur
    public Vaccination(Vaccin vaccin, Personne personne) {
        nbDosesPrises = 1;
        this.vaccin = vaccin;
        this.personne= personne;
        if (vaccin.getType() == TypeVaccin.Unidose) {
            personne.setSensibilite();
        }
    }

    //Méthode permettant d'effectuer une deuxième dose à une personne, si c'est possible
    public void faireDeuxiemeDose(){ 
        this.nbDosesPrises++;
    }
    
    //Définition des Getters
    //Retourner le nombre de doses prises par une personne lors du ou des vaccinations
    public int getNbDosesPrises() {
        return nbDosesPrises;
    }
    //Retourner le vaccin associé à une vaccination
    public Vaccin getVaccin() {
        return vaccin;
    }
    //Retourner la personne à laquelle est appliquée la vaccination
    public Personne getPersonne(){
        return this.personne;
    }
}
