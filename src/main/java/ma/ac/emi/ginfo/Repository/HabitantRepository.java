package ma.ac.emi.ginfo.Repository;

import ma.ac.emi.ginfo.model.Habitant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitantRepository extends JpaRepository<Habitant, Long> {
}
