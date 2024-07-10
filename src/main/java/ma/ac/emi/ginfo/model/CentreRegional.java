package ma.ac.emi.ginfo.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import java.util.ArrayList;
import java.util.List;



@Builder
@Entity
public class CentreRegional extends CentrePostal{
    @OneToMany(mappedBy = "centreParent",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CentrePostal> centrePostals = new ArrayList<>();

    public CentreRegional(String nom, int numero, String rue, String quartier, String vill) {
        super(nom, numero, rue, quartier, vill);
    }

    public CentreRegional(List<CentrePostal> centrePostals) {
        this.centrePostals = centrePostals;
    }

    public CentreRegional() {
    }

    public List<CentrePostal> getCentrePostals() {
        return centrePostals;
    }

    public void addCentrePostal(CentrePostal centrePostal) {
        this.centrePostals.add(centrePostal);
    }

    @Override
    public String toString() {
        return "CentreRegional{" +

                '}';
    }
}
