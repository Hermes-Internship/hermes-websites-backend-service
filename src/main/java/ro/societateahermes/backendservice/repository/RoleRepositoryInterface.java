package ro.societateahermes.backendservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.societateahermes.backendservice.entities.ERole;
import ro.societateahermes.backendservice.entities.Role;

import java.util.Optional;

public interface RoleRepositoryInterface extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
