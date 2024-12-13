public class Vaccin {
    //Définition des attributs
    private String nom;
    private TypeVaccin type;
    private Variant variantTraite;

    //Définition du constructeur de la classe "Vaccin"
    public Vaccin(String nom, TypeVaccin type, Variant variantTraite) {
        this.nom = nom;
        this.type = type;
        this.variantTraite = variantTraite;
    }

    public TypeVaccin getType() {
        return type;
    }

    
}
