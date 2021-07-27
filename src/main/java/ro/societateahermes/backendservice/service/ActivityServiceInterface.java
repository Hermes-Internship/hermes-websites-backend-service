package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.dto.FullActivityDTO;

import java.util.List;

public interface ActivityServiceInterface {
    void save(FullActivityDTO activity);

    List<FullActivityDTO> getAllActivities();

    void delete(Long id);

    void update(FullActivityDTO activity);
}
