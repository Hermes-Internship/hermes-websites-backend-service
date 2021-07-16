package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.Activity;
import ro.societateahermes.backendservice.entities.DTO.ActivityDTO;
import ro.societateahermes.backendservice.entities.DTO.UserDTO;
import ro.societateahermes.backendservice.entities.User;

import java.util.List;

public interface ActivityServiceInterface {
    void save(Activity activity);

    List<Activity> getAllActivities();

    void delete(Long id);

    void update(ActivityDTO activity);
}
