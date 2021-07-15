package ro.societateahermes.backendservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.societateahermes.backendservice.entities.TimeLine;

public interface TimeLineRepositoryInterface extends JpaRepository<TimeLine, Long> {
}
