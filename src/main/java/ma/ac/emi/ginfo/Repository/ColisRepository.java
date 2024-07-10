package ma.ac.emi.ginfo.Repository;

import ma.ac.emi.ginfo.model.Colis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColisRepository extends JpaRepository<Colis, Long> {
    Colis findColisByNumero(Long numero);

}
