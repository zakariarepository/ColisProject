package ma.ac.emi.ginfo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Habitant extends Personne{

    private String email;
    private String  telephone;

    @ManyToOne
    @JoinColumn(name = "centre_postal_numero")
    private CentrePostal centrePostal;

    @OneToMany(mappedBy = "sender_habitant")
    //@JsonBackReference
    private List<Colis> sent_colises = new ArrayList<>();


    @OneToMany(mappedBy = "receiver_habitant")
    //@JsonBackReference
    private List<Colis> received_colises = new ArrayList<>();

    public Habitant() {
    }

    public Habitant(String email, String telephone) {
        this.email = email;
        this.telephone = telephone;
    }

    public Habitant(String nom, String prenom, String rue, String quartier, String ville, String email, String telephone) {
        super(nom, prenom, rue, quartier, ville);
        this.email = email;
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Habitant{" +
                "email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", centrePostal=" + centrePostal +
                '}';
    }
}
