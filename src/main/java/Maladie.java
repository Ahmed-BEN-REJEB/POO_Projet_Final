import java.util.EnumMap;

public abstract class Maladie {
    private String nom;
    private EnumMap<Sensibilite, Float> tauxTransmission;
    private int periodeIncubation;
    private int probabiliteGuerison;
    private int probabiliteDeces;

    public Maladie(String nom, EnumMap<Sensibilite, Float> tauxTransmission, int periodeIncubation, int probabiliteGuerison, int probabiliteDeces) {
        this.nom = nom;
        this.tauxTransmission = tauxTransmission;
        this.periodeIncubation = periodeIncubation;
        this.probabiliteGuerison = probabiliteGuerison;
        this.probabiliteDeces = probabiliteDeces;
    }
}
