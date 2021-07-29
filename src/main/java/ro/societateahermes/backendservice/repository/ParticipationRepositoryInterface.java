package ro.societateahermes.backendservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.Participation;

import java.util.List;


public interface ParticipationRepositoryInterface extends JpaRepository<Participation, Long> {
    List<Participation> findParticipationByEvent(Event event);
}
