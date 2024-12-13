import java.util.EnumMap;

public class Variant extends Maladie {

    //Définition du constructeur de cette classe
    public Variant(String nom,
                   EnumMap<Sensibilite, Float> tauxTransmission,
                   int periodeIncubation,
                   int probabiliteGuerison,
                   int probabiliteDeces) {
        super(nom, tauxTransmission, periodeIncubation, probabiliteGuerison, probabiliteDeces);
    }
}
