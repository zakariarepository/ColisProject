package ma.ac.emi.ginfo.Repository;

import ma.ac.emi.ginfo.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
