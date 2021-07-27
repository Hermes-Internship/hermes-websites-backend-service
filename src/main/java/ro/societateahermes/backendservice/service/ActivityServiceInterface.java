package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.Activity;
import ro.societateahermes.backendservice.entities.dto.ActivityDTO;
import ro.societateahermes.backendservice.entities.dto.TimelineDTO;

import java.util.List;

public interface ActivityServiceInterface {

    void save(ActivityDTO activityDTO);

    void delete(ActivityDTO activityDTO);

    List<ActivityDTO> eventIsOngoing(Activity activity);

    void update(ActivityDTO activityDTO, TimelineDTO timelineDTO);
}
