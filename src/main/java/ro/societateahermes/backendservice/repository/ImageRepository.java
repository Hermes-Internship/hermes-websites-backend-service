package ro.societateahermes.backendservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.societateahermes.backendservice.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
