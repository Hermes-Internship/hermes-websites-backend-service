package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.Activity;
import ro.societateahermes.backendservice.entities.dto.ActivityDTO;

import java.util.List;

public interface ActivityServiceInterface {

    List<Activity> getAll();

    List<ActivityDTO> eventIsOngoing(Activity activity);
}
