package ro.societateahermes.backendservice.controller;

import ro.societateahermes.backendservice.entities.Activity;
import ro.societateahermes.backendservice.entities.DTO.ActivityDTO;
import ro.societateahermes.backendservice.entities.DTO.UserDTO;
import ro.societateahermes.backendservice.entities.User;

import java.util.List;

public interface ActivityControllerInterface {
    void save(ActivityDTO activity);
    List<ActivityDTO> getAll();
    void delete (Long activityId);
    void put(ActivityDTO activityDTO);
}
