package ro.societateahermes.backendservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.societateahermes.backendservice.entities.Participation;


public interface ParticipationRepositoryInterface extends JpaRepository<Participation, Long> {

}
