package ro.societateahermes.backendservice.controller;

import ro.societateahermes.backendservice.entities.dto.FullActivityDTO;

import java.util.List;

public interface ActivityControllerInterface {
    void save(FullActivityDTO activity);
    List<FullActivityDTO> getAll();
    void delete (Long activityId);
    void put(FullActivityDTO fullActivityDTO);
}
