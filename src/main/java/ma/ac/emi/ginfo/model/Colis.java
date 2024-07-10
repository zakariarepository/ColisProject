package ma.ac.emi.ginfo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;




@Entity
public class Colis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private LocalDate dateDepot;
    private LocalDate dateReception;

    @ManyToOne
    /*@JoinColumn(name = "facteur_id")*/
    @JsonIgnore
    //@JsonManagedReference
    private Facteur facteur;

    @ManyToOne
    /*@JoinColumn(name = "sender_habitant_id")*/
    @JsonIgnore
    //@JsonManagedReference
    private Habitant sender_habitant;


    @ManyToOne
    /*@JoinColumn(name = "receiver_habitant_id")*/
    @JsonIgnore
    //@JsonManagedReference
    private Habitant receiver_habitant;


    public Habitant getSender_habitant() {
        return sender_habitant;
    }

    public void setSender_habitant(Habitant sender_habitant) {
        this.sender_habitant = sender_habitant;
    }

    public Habitant getReceiver_habitant() {
        return receiver_habitant;
    }

    public void setReceiver_habitant(Habitant receiver_habitant) {
        this.receiver_habitant = receiver_habitant;
    }


    public Colis() {
    }

    public Colis(LocalDate dateDepot, LocalDate dateReception, Facteur facteur) {
        this.dateDepot = dateDepot;
        this.dateReception = dateReception;
        this.facteur = facteur;
    }

    public Colis(LocalDate dateDepot, LocalDate dateReception) {
        this.dateDepot = dateDepot;
        this.dateReception = dateReception;
    }

    public LocalDate getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(LocalDate dateDepot) {
        this.dateDepot = dateDepot;
    }

    public LocalDate getDateReception() {
        return dateReception;
    }

    public void setDateReception(LocalDate dateReception) {
        this.dateReception = dateReception;
    }

    public Facteur getFacteur() {
        return facteur;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public void setFacteur(Facteur facteur) {
        this.facteur = facteur;
    }

    @Override
    public String toString() {
        return "Colis{" +
                "numero=" + numero +
                ", dateDepot=" + dateDepot +
                ", dateReception=" + dateReception +
                ", facteur=" + facteur +
                ", sender_habitant=" + sender_habitant +
                ", receiver_habitant=" + receiver_habitant +
                '}';
    }
}
