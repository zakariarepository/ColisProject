package ma.ac.emi.ginfo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Facteur extends Personne{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( nullable = true)//(name = "centre_postal_numero")
    @JsonIgnore
    private CentrePostal centrePostal;

    public Facteur(String nom, String prenom, String rue, String quartier, String ville) {
        super(nom, prenom, rue, quartier, ville);
    }

    public Facteur() {
    }

    @OneToMany(mappedBy = "facteur")
    //@JsonBackReference
    private Set<Colis> colises = new LinkedHashSet<>();

    public CentrePostal getCentrePostal() {
        return centrePostal;
    }

    public void setCentrePostal(CentrePostal centrePostal) {
        this.centrePostal = centrePostal;
    }

    @Override
    public String toString() {
        return "Facteur{" +
                "centrePostal=" + "hggj" +
                '}';
    }
}
