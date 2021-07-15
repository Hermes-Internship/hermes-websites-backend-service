package ro.societateahermes.backendservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.societateahermes.backendservice.entities.Event;


public interface EventRepositoryInterface extends JpaRepository<Event, Long> {
}
