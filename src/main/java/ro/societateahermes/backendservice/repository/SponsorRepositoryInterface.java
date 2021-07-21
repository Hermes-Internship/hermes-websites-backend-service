package ro.societateahermes.backendservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.societateahermes.backendservice.entities.Sponsor;


public interface SponsorRepositoryInterface extends JpaRepository<Sponsor, Long> {
}
