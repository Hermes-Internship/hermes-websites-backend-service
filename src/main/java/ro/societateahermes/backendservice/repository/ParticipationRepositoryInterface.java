package ro.societateahermes.backendservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.societateahermes.backendservice.entities.Participation;

@Repository
public interface ParticipationRepositoryInterface extends JpaRepository<Participation, Long> {
    Participation findByUserID(Long userId);
}
