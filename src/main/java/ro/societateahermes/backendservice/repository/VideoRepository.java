package ro.societateahermes.backendservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.societateahermes.backendservice.entities.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
