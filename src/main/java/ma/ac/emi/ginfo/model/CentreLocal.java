package ma.ac.emi.ginfo.model;

import jakarta.persistence.Entity;


@Entity
public class CentreLocal extends CentrePostal{

    public CentreLocal(String nom, int numero, String rue, String quartier, String ville) {
        super(nom, numero, rue, quartier, ville);
    }

    public CentreLocal() {
    }

}
