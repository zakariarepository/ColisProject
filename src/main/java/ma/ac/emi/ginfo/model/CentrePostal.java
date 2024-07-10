package ma.ac.emi.ginfo.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

 //geters & setter + toString
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CentrePostal {

    private String nom;
    @Id
    private int numero;
    private String rue;
    private String quartier;
    private String ville;


    @ManyToOne
    //@JoinColumn(name = "centre_parent_numero")
    @JsonIgnore
    private CentreRegional centreParent;

    @OneToMany(mappedBy = "centrePostal",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Facteur> facteurs = new ArrayList<>();

    @OneToMany(mappedBy = "centrePostal")
    private List<Habitant> habitants = new ArrayList<>();

    public CentrePostal() {
    }

    public CentrePostal(String nom, int numero, String rue, String quartier, String ville) {
        this.nom = nom;
        this.numero = numero;
        this.rue = rue;
        this.quartier = quartier;
        this.ville = ville;
    }

    public CentreRegional getCentreParent() {
        return centreParent;
    }

    public void setCentreParent(CentreRegional centreParent) {
        this.centreParent = centreParent;
    }

     public List<Facteur> getFacteurs() {
         return facteurs;
     }

     public void addFacteur(Facteur facteur) {
         this.facteurs.add(facteur);
     }

     @Override
     public String toString() {
         return "CentrePostal{" +
                 "nom='" + nom + '\'' +
                 ", numero=" + numero +
                 ", rue='" + rue + '\'' +
                 ", quartier='" + quartier + '\'' +
                 ", ville='" + ville + '\'' +
                 ", centreParent=" + centreParent +
                 '}';
     }

     public String getNom() {
         return nom;
     }

     public void setNom(String nom) {
         this.nom = nom;
     }
 }
